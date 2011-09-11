-- Copyright (c) 1991-2002, The Numerical ALgorithms Group Ltd.
-- All rights reserved.
-- Copyright (C) 2007-2011, Gabriel Dos Reis.
-- All rights reserved.
--
-- Redistribution and use in source and binary forms, with or without
-- modification, are permitted provided that the following conditions are
-- met:
--
--     - Redistributions of source code must retain the above copyright
--       notice, this list of conditions and the following disclaimer.
--
--     - Redistributions in binary form must reproduce the above copyright
--       notice, this list of conditions and the following disclaimer in
--       the documentation and/or other materials provided with the
--       distribution.
--
--     - Neither the name of The Numerical ALgorithms Group Ltd. nor the
--       names of its contributors may be used to endorse or promote products
--       derived from this software without specific prior written permission.
--
-- THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
-- IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
-- TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
-- PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
-- OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
-- EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
-- PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
-- PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
-- LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
-- NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
-- SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.


import g_-util
namespace BOOT

--% 

$optimizableConstructorNames := $SystemInlinableConstructorNames

++ Return true if the domain `dom' is an instance of a functor
++ that has been nominated for inlining.
optimizableDomain? dom ==
  symbolMember?(opOf dom,$optimizableConstructorNames)

++ Register the domain `dom' for inlining.
nominateForInlining dom ==
  $optimizableConstructorNames := [opOf dom,:$optimizableConstructorNames]
  
--%

++ return the template of the instantiating functor for
++ the domain form `dom'.
getDomainTemplate dom ==
  dom isnt [.,:.] => nil
  getInfovec first dom

++ Emit code for an indirect call to domain-wide Spad function.  
++ This is usually the case for exported functions.
emitIndirectCall(fn,args,x) ==
  x.first := "SPADCALL"
  fn.first := '%tref
  x.rest := [:args,fn]
  x

--% OPTIMIZER

++ Change (%LET id expr) to (%store id expr) if `id' is being
++ updated as opposed to being defined. `vars' is the list of
++ all variable definitions in scope.
changeVariableDefinitionToStore(form,vars) ==
  atomic? form or form.op is 'CLOSEDFN => vars
  form is ['%LET,v,expr] =>
    vars := changeVariableDefinitionToStore(expr,vars)
    if symbolMember?(v,vars) then
      form.op := '%store
    else
      vars := [v,:vars]
    vars
  form.op is '%when =>
    for clause in form.args repeat
      -- variable defined in clause predicates are visible
      -- subsequent predicates
      vars := changeVariableDefinitionToStore(first clause,vars)
      -- but those defined in branches are local.
      changeVariableDefinitionToStore(rest clause,vars)
    vars
  -- local bindings are, well, local.
  form.op in '(%bind LET) =>
    vars' := vars
    for [v,init] in second form repeat
      vars' := changeVariableDefinitionToStore(init,vars')
      vars' := [v,:vars']
    changeVariableDefinitionToStore(third form,vars')
    vars
  abstractionOperator? form.op =>
    changeVariableDefinitionToStore(third form,[:second form,:vars])
    vars
  for x in form repeat
    vars := changeVariableDefinitionToStore(x,vars)
  vars

++ Return true if `x' contains control transfer to a point outside itself.
jumpToToplevel? x ==
  atomic? x => false
  op := x.op
  op is 'SEQ => CONTAINED('THROW,x.args) -- FIXME: what about GO?
  op in '(EXIT THROW %leave) => true
  or/[jumpToToplevel? x' for x' in x]

++ Return true if `form' is just one assignment expression.
nonExitingSingleAssignment? form ==
  form is ['%LET,.,rhs]
    and not CONTAINED('%LET,rhs) and not jumpToToplevel? rhs

++ Turns `form' into a `%bind'-expression if it starts with a
++ a sequence of first-time variable definitions.
groupVariableDefinitions form ==
  atomic? form => form
  form.op is '%when =>
    -- FIXME: we should not be generating store-modifying predicates
    for clause in form.args while not CONTAINED('%LET, first clause) repeat
      second(clause) := groupVariableDefinitions second clause
    form
  form isnt ['SEQ,:stmts,['EXIT,val]] => form
  defs := nil
  for x in stmts while nonExitingSingleAssignment? x  repeat
    defs := [x.args,:defs]
  defs = nil or jumpToToplevel? defs => form
  stmts := drop(#defs,stmts)
  expr :=
    stmts = nil => val
    ['SEQ,:stmts,['EXIT,val]]
  ['%bind,reverse! defs,expr]

optimizeFunctionDef(def) ==
  if $reportOptimization then
    sayBrightlyI bright '"Original LISP code:"
    pp def
 
  def' := simplifyVMForm COPY def
 
  if $reportOptimization then
    sayBrightlyI bright '"Intermediate VM code:"
    pp def'

  [name,[slamOrLam,args,body]] := def'
 
  body':=
    removeTopLevelCatch body where
      removeTopLevelCatch body ==
        body is ["CATCH",g,u] =>
          removeTopLevelCatch replaceThrowByReturn(u,g)
        body
      replaceThrowByReturn(x,g) ==
        fn(x,g)
        x
      fn(x,g) ==
        x is ["THROW", =g,:u] =>
          x.first := "RETURN"
          x.rest := replaceThrowByReturn(u,g)
        x isnt [.,:.] => nil
        replaceThrowByReturn(first x,g)
        replaceThrowByReturn(rest x,g)
  changeVariableDefinitionToStore(body',args)
  [name,[slamOrLam,args,groupVariableDefinitions body']]

resetTo(x,y) ==
  y isnt [.,:.] => x := y
  sameObject?(x,y) => x
  x.first := y.first
  x.rest := y.rest
  x

++ Simplify the VM form `x'
simplifyVMForm x ==
  x is '%icst0 => 0
  x is '%icst1 => 1
  atomic? x => x
  x.op is 'CLOSEDFN => x
  x.op isnt [.,:.] =>
    x is [op,vars,body] and abstractionOperator? op =>
      third(x) := simplifyVMForm body
      x
    if x.op is 'IF then
      resetTo(x,optIF2COND x)
    for args in tails x.args repeat
      args.first := simplifyVMForm first args
    opt := subrname x.op has OPTIMIZE => resetTo(x,FUNCALL(opt,x))
    x
  for xs in tails x repeat
    xs.first := simplifyVMForm first xs
  x
 
subrname u ==
  ident? u => u
  COMPILED_-FUNCTION_-P u or MBPIP u => BPINAME u
  nil
 
changeThrowToExit(s,g) ==
  s isnt [.,:.] or s.op in '(QUOTE SEQ REPEAT COLLECT %collect %loop) => nil
  s is ["THROW", =g,:u] => (s.first := "EXIT"; s.rest := u)
  changeThrowToExit(first s,g)
  changeThrowToExit(rest s,g)

hasNoThrows(a,g) ==
  a is ["THROW", =g,:.] => false
  a isnt [.,:.] => true
  hasNoThrows(first a,g) and hasNoThrows(rest a,g)

changeThrowToGo(s,g) ==
  s isnt [.,:.] or s.op is 'QUOTE => nil
  s is ["THROW", =g,u] =>
    changeThrowToGo(u,g)
    s.first := "PROGN"
    s.rest := [["%LET",second g,u],["GO",second g]]
  changeThrowToGo(first s,g)
  changeThrowToGo(rest s,g)

++ Change any `(THROW tag (%return expr))' in x to just
++ `(%return expr) since a %return-expression transfers control
++ out of the function body anyway.  Similarly, transform
++ reudant `(THROW tag (THROW tag expr))' to `(THROW tag expr)'.
removeNeedlessThrow x ==
  atomic? x => x
  x is ['THROW,.,y] and y is ['%return,:.] =>
    removeNeedlessThrow third y
    x.op := y.op
    x.args := y.args
  x is ['THROW,g,y] and y is ['THROW,=g,z] =>
    removeNeedlessThrow z
    second(x.args) := z
  for x' in x repeat
    removeNeedlessThrow x'

optCatch (x is ["CATCH",g,a]) ==
  $InteractiveMode => x
  a isnt [.,:.] => a
  removeNeedlessThrow a
  if a is ["SEQ",:s,["THROW", =g,u]] then
    changeThrowToExit(s,g)
    a.rest := [:s,["EXIT",u]]
    a := simplifyVMForm a
  if hasNoThrows(a,g) then
    resetTo(x,a)
  else
    changeThrowToGo(a,g)
    x.first := "SEQ"
    x.rest := [["EXIT",a],second g,["EXIT",second g]]
  x
 
optSPADCALL(form is ['SPADCALL,:argl]) ==
  not $InteractiveMode => form
  -- last arg is function/env, but may be a form
  argl is [:argl,fun] and fun is ["ELT",dom,slot] =>
    optCall ['%call,['ELT,dom,slot],:argl]
  form

++ Inline a call with arguments `args'  to a simple function with
++ parameter-list `parms' and body `body'.
doInlineCall(args,parms,body) ==
  -- 1. almost constant functions are easy
  parms = nil => body
  -- 2. identity functions too
  parms is [=body] => first args
  -- 3. We know that the body is essentially side-effect-free (at best)
  --    or simple expression (at worst.)  The issue is whether it is
  --    OK to directly substitute the arguments which may be
  --    arbitrary expressions.  The ideal semantics calls for introducting
  --    a (fresh) temporary to hold the values of the argument expressions.
  --    We attempt to short-circuit the native evaluation as follows:
  --      a. side-effect-free arguments go by themselves.
  --      b. Simple expression arguments go by themselves as long as
  --         the corresponding parameter is used linearly in the body.
  --      c. Others get evaluated to temporaries.
  tmps := nil         -- list of temporaries
  inits := nil        -- list of local bindings
  subst := nil        -- arguments substitution.
  for arg in args for parm in parms repeat
    g := gensym()
    tmps := [g,:tmps]
    n := numOfOccurencesOf(parm,body)
    atomic? arg or (sideEffectFree? arg and n < 2) or n = 1 =>
      subst := [[g,:arg],:subst]
    inits := [[g,arg],:inits]
  -- 4. Alpha-rename the body and substitute simple expression arguments.
  body := applySubst(pairList(parms,reverse! tmps),body)
  body := applySubst!(subst,body)
  -- 5. Deliver.
  inits = nil => body
  ['%bind,reverse! inits,body]    


optCall (x is ['%call,:u]) ==
  u is [['XLAM,vars,body],:args] =>
    vars isnt [.,:.] => body
    #vars > #args => systemErrorHere ['optCall,x]
    resetTo(x,doInlineCall(args,vars,body))
  [fn,:a] := u
  fn isnt [.,:.] =>
    opt := fn has OPTIMIZE => resetTo(x,FUNCALL(opt,u))
    resetTo(x,u)
  fn is ['applyFun,name] =>
    x.first := 'SPADCALL
    x.rest := [:a,name]
    x
  fn is [q,R,n] and q in '(ELT CONST) =>
    q is 'CONST => ['spadConstant,R,n]
    emitIndirectCall(fn,a,x)
  systemErrorHere ['optCall,x]
 
optCons (x is ["CONS",a,b]) ==
  a is "NIL" =>
    b is 'NIL => (x.first := 'QUOTE; x.rest := ['NIL,:'NIL]; x)
    b is ['QUOTE,:c] => (x.first := 'QUOTE; x.rest := ['NIL,:c]; x)
    x
  a is ['QUOTE,a'] =>
    b is 'NIL => (x.first := 'QUOTE; x.rest := [a',:'NIL]; x)
    b is ['QUOTE,:c] => (x.first := 'QUOTE; x.rest := [a',:c]; x)
    x
  x
 
optCond (x is ['%when,:l]) ==
  l is [['%true,c],:.] => c
  l is [['%false,.],:.] => optCond ['%when,:rest l]
  l is [['%otherwise,c]] => c
  if l is [a,[aa,b]] and aa is '%otherwise and b is ['%when,:c] then
    x.rest.rest := c
  if l is [[p1,:c1],[p2,:c2],:.] then
    if (p1 is ['%not,=p2]) or (p2 is ['%not,=p1]) then
      l:=[[p1,:c1],['%otherwise,:c2]]
      x.rest := l
    c1 is ['NIL] and p2 is '%otherwise and first c2 is '%otherwise =>
      return optNot ['%not,p1]
  l is [[p1,['%when,[p2,c2]]]] => optCond ['%when,[['%and,p1,p2],c2]]
  l is [[p1,c1],['%otherwise,'%false]] => optAnd ['%and,p1,c1]
  l is [[p1,c1],['%otherwise,'%true]] => optOr ['%or,optNot ['%not,p1],c1]
  l is [[p1,'%false],['%otherwise,c2]] => optAnd ['%and,optNot ['%not,p1],c2]
  l is [[p1,'%true],['%otherwise,c2]] => optOr ['%or,p1,c2]
  l is [[p1,:c1],[p2,:c2],[p3,:c3]] and p3 is '%otherwise =>
    EqualBarGensym(c1,c3) =>
      optCond ['%when,[['%or,p1,optNot ['%not,p2]],:c1],['%otherwise,:c2]]
    EqualBarGensym(c1,c2) =>
      optCond ['%when,[['%or,p1,p2],:c1],['%otherwise,:c3]]
    x
  for y in tails l repeat
    while y is [[a1,c1],[a2,c2],:y'] and EqualBarGensym(c1,c2) repeat
      a := ['%or,a1,a2]
      first(y).first := a
      y.rest := y'
  x
 
AssocBarGensym(key,l) ==
  for x in l repeat
    cons? x =>
      EqualBarGensym(key,first x) => return x
 
EqualBarGensym(x,y) ==
  $GensymAssoc: local := nil
  fn(x,y) where
    fn(x,y) ==
      x=y => true
      GENSYMP x and GENSYMP y =>
        z:= assoc(x,$GensymAssoc) => y=rest z
        $GensymAssoc:= [[x,:y],:$GensymAssoc]
        true
      null x => y is [g] and GENSYMP g
      null y => x is [g] and GENSYMP g
      x isnt [.,:.] or y isnt [.,:.] => false
      fn(first x,first y) and fn(rest x,rest y)
 
--Called early, to change IF to conditional form
 
optIF2COND ["IF",a,b,c] ==
  b is "%noBranch" => ['%when,[['%not,a],c]]
  c is "%noBranch" => ['%when,[a,b]]
  c is ["IF",:.] => ['%when,[a,b],:rest optIF2COND c]
  c is ['%when,:p] => ['%when,[a,b],:p]
  ['%when,[a,b],['%otherwise,c]]

++ Determine whether the symbol `g' is the name of a temporary that
++ can be replaced in the form `x', if it is of linear usage and not
++ the name of a program point.  The latter occurs when THROW forms
++ are changed to %LET form followed by a GO form -- see optCatch.
replaceableTemporary?(g,x) ==
  GENSYMP g and numOfOccurencesOf(g,x) < 2 and not jumpTarget?(g,x) where
    jumpTarget?(g,x) ==
      atomic? x => false
      x is ['GO,=g] => true
      or/[jumpTarget?(g,x') for x' in x]

optSEQ ["SEQ",:l] ==
  tryToRemoveSEQ SEQToCOND getRidOfTemps splicePROGN l where
    splicePROGN l ==
      atomic? l => l
      l is [["PROGN",:stmts],:l'] => [:stmts,:l']
      l.rest := splicePROGN rest l
    getRidOfTemps l ==
      null l => nil
      l is [["%LET",g,x],:r] and replaceableTemporary?(g,r) =>
        getRidOfTemps substitute(x,g,r)
      first l is "/throwAway" => getRidOfTemps rest l
      --this gets rid of unwanted labels generated by declarations in SEQs
      [first l,:getRidOfTemps rest l]
    SEQToCOND l ==
      transform:= [[a,b] for x in l while (x is ['%when,[a,["EXIT",b]]])]
      before:= take(#transform,l)
      aft:= after(l,before)
      null before => ["SEQ",:aft]
      null aft => ['%when,:transform,'(%otherwise (conderr))]
      optCond ['%when,:transform,['%otherwise,optSEQ ["SEQ",:aft]]]
    tryToRemoveSEQ l ==
      l is ["SEQ",[op,a]] and op in '(EXIT RETURN THROW) => a
      l
 
optSuchthat [.,:u] == ["SUCHTHAT",:u]
 
++ List of VM side effect free operators.
$VMsideEffectFreeOperators ==
  '(SPADfirst ASH FLOAT FLOAT_-SIGN
    %funcall %nothing %when %false %true %otherwise %2bit %2bool
    %and %or %not %peq %ieq %ilt %ile %igt %ige %head %tail %integer?
    %beq %blt %ble %bgt %bge %bitand %bitior %bitxor %bitnot %bcompl
    %ilength %ibit %icst0 %icst1 %icstmin %icstmax
    %imul %iadd %isub %igcd %ilcm %ipow %imin %imax %ieven? %iodd? %iinc
    %idec %irem %iquo %idivide %idec %irandom
    %feq %flt %fle %fgt %fge %fmul %fadd %fsub %fexp %fmin %fmax %float?
    %fpowi %fdiv %fneg %i2f %fminval %fmaxval %fbase %fprec %ftrunc
    %fsqrt %fpowf %flog %flog2 %flog10 %fmanexp %fNaN?
    %fsin  %fcos  %ftan  %fcot  
    %fasin %facos %fatan %facot 
    %fsinh  %fcosh  %ftanh 
    %fasinh %facosh %fatanh
    %val2z %z2val %zlit %zreal %zimag
    %zexp %zlog %zsin %zcos %ztan %zasin %zacos %zatan
    %zsinh %zcosh %ztanh %zasinh %zacosh %zatanh
    %nil %pair %list %pair? %lconcat %llength %lfirst %lsecond %lthird
    %lreverse %lempty? %hash %ismall? %string? %f2s STRINGIMAGE
    %ccst %ccstmax %ceq %clt %cle %cgt %cge %c2i %i2c %s2c %c2s %cup %cdown
    %sname
    %strlength %streq %i2s %schar %strlt %strconc
    %strcopy %bytevec2str %str2bytevec
    %vector %aref %vref %vlength %vcopy
    %bitvector
    %bitvecnot %bitvecand %bitvecnand %bivecor %bitvecnor %bitvecxor
    %bitveccopy %bitvecconc %bitveclength %bitvecref %bitveceq %bitveclt
    %before? %equal %sptreq %ident? %property %tref
    %writeString %writeNewline %writeLine
    %void %retract %pullback)

++ List of simple VM operators
$simpleVMoperators == 
  append($VMsideEffectFreeOperators,
    ['SPADCALL,'%apply, '%gensym, '%lreverse!,
      '%strstc])

++ Return true if the `form' is semi-simple with respect to
++ to the list of operators `ops'.
semiSimpleRelativeTo?(form,ops) ==
  atomic? form => true
  not symbol?(form.op) or not symbolMember?(form.op,ops) => false
  form.op is '%when =>
    and/[sideEffectFree? p and semiSimpleRelativeTo?(c,ops)
           for [p,c] in form.args]
  and/[semiSimpleRelativeTo?(f,ops) for f in form.args]

++ Return true if `form' os a side-effect free form.  
sideEffectFree? form ==
  semiSimpleRelativeTo?(form,$VMsideEffectFreeOperators)

++ Return true if `form' is a simple VM form.
++ See $simpleVMoperators for the definition of simple operators.
isSimpleVMForm form ==
  semiSimpleRelativeTo?(form,$simpleVMoperators)

++ Return true if `form' is a VM form whose evaluation does not depend
++ on the program point where it is evaluated. 
isFloatableVMForm: %Code -> %Boolean
isFloatableVMForm form ==
  form isnt [.,:.] => form isnt "$"
  form is ["QUOTE",:.] => true
  symbolMember?(form.op, $simpleVMoperators) and
    "and"/[isFloatableVMForm arg for arg in form.args]
    

++ Return true if the VM form `form' is one that we certify to 
++ evaluate to a (compile time) constant.  Note that this is a
++ fairly conservative approximation of compile time constants.
isVMConstantForm: %Code -> %Boolean
isVMConstantForm form ==
  integer? form or string? form => true
  form isnt [op,:args] => false
  op in '(%list %pair %vector) => false
  symbolMember?(op,$VMsideEffectFreeOperators) and 
    "and"/[isVMConstantForm arg for arg in args]

++ Return the set of free variables in the VM form `form'.
findVMFreeVars form ==
  ident? form => [form]
  form isnt [op,:args] => nil  
  op is "QUOTE" => nil
  vars := union/[findVMFreeVars arg for arg in args]
  op isnt [.,:.] => vars
  union(findVMFreeVars op,vars)

++ Return true is `var' is the left hand side of an assignment
++ in `form'.
varIsAssigned(var,form) ==
  atomic? form => false
  form is [op,var',:.] and op in '(%LET LETT SETQ %store) =>
    symbol? var' => var' = var   -- whole var is assigned
    var' is [.,=var]             -- only part of it is modified
  or/[varIsAssigned(var,f) for f in form]


++ Return the list of variables referenced in `expr'.  
dependentVars expr == main(expr,nil) where
  main(x,vars) ==
    ident? x =>
      symbolMember?(x,vars) => vars
      [x,:vars]
    atomic? x => vars
    x' :=
      cons? x.op => x
      x.args
    for y in x' repeat
      vars := main(y,vars)
    vars

++ Subroutine of optBind.  Return true if the variable `var' locally
++ defined in a binding form can be safely replaced by its initalization
++ `expr' in the `body' of the binding form.
canInlineVarDefinition(var,expr,body) ==
  -- Occasional situation where `expr' evaluates to itself
  gensym? var and sameObject?(var,body) => true
  -- FIXME: We should not be inlining a side-effecting initializer.
  -- If the variable is assigned to, that is a no no.
  varIsAssigned(var,body) => false
  -- Similarly, if the initial value depends on variables that are
  -- side-effected latter, it is alos a no no.
  or/[varIsAssigned(x,body) for x in dependentVars expr] => false
  -- Conversatively preserve order of inialization
  cons? body and body.op in '(%bind LET %loop %collect) => false
  -- Linearly used internal temporaries should be replaced, and
  -- so should side-effet free initializers for linear variables.
  usageCount := numOfOccurencesOf(var,body)
  usageCount < 2 and sideEffectFree? expr => true
  gensym? var and usageCount = 1 => true
  -- If the initializer is a variable and the body is
  -- a series of choices with side-effect free predicates, then
  -- no harm is done by removing the local `var'.
  ident? expr and body is ['%when,:branches] =>
    and/[sideEffectFree? pred for [pred,:.] in branches]
  false

++ Implement simple-minded LET-inlining.  It seems we can't count
++ on Lisp implementations to do this simple transformation.
++ This transformation will probably be more effective when all
++ type informations are still around.   Which is why we should
++ have a type directed compilation throughout. 
optBind form ==
  form isnt ['%bind,inits,.] => form           -- accept only simple bodies
  ok := true
  while ok and inits ~= nil repeat
    [var,expr] := first inits
    usedSymbol?(var,rest inits) => ok := false -- no dependency, please.
    body := third form
    canInlineVarDefinition(var,expr,body) =>
      third(form) := substitute!(expr,var,body)
      inits := rest inits
    ok := false
  null inits => third form                        -- no local var left
  second(form) := inits
  form

optTry form ==
  form isnt ['%try,e,hs,f] or not(isFloatableVMForm e) or f ~= nil => form
  e

optList form ==
  form is ['%list] => '%nil
  form

optCollectVector form ==
  [.,eltType,:iters,body] := form
  fromList := false      -- are we drawing from a list?
  vecSize := nil         -- size of vector
  index := nil           -- loop/vector index.
  for iter in iters while not fromList repeat
    [op,:.] := iter
    op in '(| SUCHTHAT WHILE UNTIL) => fromList := true
    op in '(IN ON) => vecSize := [['%llength,third iter],:vecSize]
    op in '(STEP ISTEP) =>
      -- pick a loop variable that we can use as the loop index.
      [.,var,lo,inc,:etc] := iter
      if lo = 0 and inc = 1 then
        index :=
          var is [.,:var'] => var'
          var
      if [hi] := etc then
        sz :=
          inc = 1 =>
            lo = 1 => hi
            lo = 0 => ['%iinc,hi]
            ['%iinc,['%isub,hi,lo]]
          lo = 1 => ['%idiv,hi,inc]
          lo = 0 => ['%idiv,['%iinc,hi],inc]
          ['%idiv,['%isub,['%iinc,hi], lo],inc]
        vecSize := [sz, :vecSize]
    systemErrorHere ["optCollectVector", iter]
  -- if we draw from a list, then just build a list and convert to vector.
  fromList => 
    ["homogeneousListToVector",["getVMType",eltType], ['%collect,:iters,body]]
  vecSize = nil => systemErrorHere ["optCollectVector",form]
  -- get the actual size of the vector.
  vecSize :=
    vecSize is [hi] => hi
    ['%imin,:reverse! vecSize]
  -- if no suitable loop index was found, introduce one.
  if index = nil then
    index := gensym()
    iters := [:iters,['STEP,index,0,1]]
  vec := gensym()
  ['%bind,[[vec,["makeSimpleArray",["getVMType",eltType],vecSize]]],
    ['%loop,:iters,["setSimpleArrayEntry",vec,index,body],vec]]

++ Translate retraction of a value denoted by `e' to sub-domain `m'
++ defined by predicate `pred',
optRetract ["%retract",e,m,pred] ==
  e isnt [.,:.] =>
    cond := simplifyVMForm substitute(e,"#1",pred)
    cond is '%true => e
    ['%when,[cond,e],['%otherwise,['moanRetract,e,MKQ m]]]
  g := gensym()
  ['%bind,[[g,e]],
    ['%when,[substitute(g,"#1",pred),g],
      ['%otherwise,['moanRetract,g,MKQ m]]]]

++ We have an expression `x' of some Union type.  Expand an attempted
++ pullback to the `n'th branch of type `t'.
optPullback ['%pullback,x,t,n] ==
  y :=
    ident? x => x
    gensym()
  expr :=
    ['%when,[['%ieq,['%head,y],n],['%tail,y]],
      ['%otherwise,['moanRetract,y,MKQ t]]]
  symbolEq?(x,y) => expr
  ['%bind,[[y,x]],expr]

--%  Boolean expression transformers

optNot(x is ['%not,a]) ==
  a is '%true => '%false
  a is '%false => '%true
  a is ['%not,b] => b
  a is ['%when,:.] =>
    optCond [a.op, :[[p,optNot ['%not,c]] for [p,c] in a.args]]
  x

optAnd(x is ['%and,a,b]) ==
  a is '%true => b
  b is '%true => a
  a is '%false => '%false
  x

optOr(x is ['%or,a,b]) ==
  a is '%false => b
  b is '%false => a
  a is '%true => '%true
  x

-- Boolean <-> bit conversion.
opt2bit ['%2bit,a] ==
  optCond ['%when,[a,'%icst1],['%otherwise,'%icst0]]

opt2bool ['%2bool,a] ==
  a is '%icst0 => '%false
  a is '%icst1 => '%true
  optIeq ['%ieq,a,'%icst1]

optIeq(x is ['%ieq,a,b]) ==
  integer? a and integer? b =>
    scalarEq?(a,b) => '%true
    '%false
  sameObject?(a,b) => '%true
  x

optIlt(x is ['%ilt,a,b]) ==
  -- 1. Don't delay if both operands are literals.
  integer? a and integer? b =>
    a < b => '%true
    '%false
  -- 2. max(a,b) cannot be negative if either a or b is zero.
  b = 0 and a is ['%imax,:.] and (second a = 0 or third a = 0) => '%false
  -- 3. min(a,b) cannot be positive if either a or b is zero.
  a = 0 and b is ['%imin,:.] and (second b = 0 or third b = 0) => '%false
  x

optIle(x is ['%ile,a,b]) ==
  optNot ['%not,optIlt ['%ilt,b,a]]

optIgt x ==
  optIlt ['%ilt,third x, second x]

optIge x ==
  optNot ['%not,optIlt ['%ilt,second x,third x]]

--% Byte operations

optBle ['%ble,a,b] ==
  optNot ['%not,['%blt,b,a]]

optBgt ['%bgt,a,b] ==
  ['%blt,b,a]

optBge ['%bge,a,b] ==
  optBle ['%ble,b,a]




--% Integer operations

optIadd(x is ['%iadd,a,b]) ==
  integer? a and integer? b => a + b
  integer? a =>
    a = 0 => b
    b is [op,b1,b2] and op in '(%iadd %isub) =>
      integer? b1 => simplifyVMForm [op,['%iadd,a,b1],b2]
      integer? b2 => simplifyVMForm ['%iadd,b1,[op,a,b2]]
      x
    x
  integer? b =>
    b = 0 => a
    a is [op,a1,a2] and op in '('%iadd %isub) =>
      integer? a1 => simplifyVMForm [op,['%iadd,a1,b],a2]
      integer? a2 => simplifyVMForm ['%iadd,a1,[op,b,a2]]
      x
    x
  x

optIinc(x is ['%iinc,a]) ==
  integer? a => a + 1
  a is [op,b,c] and op in '(%isub %iadd) =>
    integer? b => simplifyVMForm [op,[op,b,1],c]
    integer? c => simplifyVMForm [op,b,[op,c,1]]
    x
  x

optIsub(x is ['%isub,a,b]) ==
  integer? a and integer? b => a - b
  integer? a =>
    a = 0 => ['%ineg,b]
    b is ['%iadd,b1,b2] =>
      integer? b1 => simplifyVMForm ['%isub,['%isub,a,b1],b2]
      integer? b2 => simplifyVMForm ['%isub,['%isub,a,b2],b1]
      x
    b is ['%isub,b1,b2] =>
      integer? b1 => simplifyVMForm ['%iadd,['%isub,a,b1],b2]
      integer? b2 => simplifyVMForm ['%isub,['%iadd,a,b2],b1]
      x
    x
  integer? b =>
    b = 0 => a
    a is ['%iadd,a1,a2] =>
      integer? a1 => simplifyVMForm ['%iadd,['%isub,a1,b],a2]
      integer? a2 => simplifyVMForm ['%iadd,a1,['%isub,a2,b]]
      x
    a is ['%isub,a1,a2] =>
      integer? a1 => simplifyVMForm ['%isub,['%isub,a1,b],a2]
      integer? a2 => simplifyVMForm ['%isub,a1,['%iadd,a2,b]]
      x
    x
  x

optIdec(x is ['%idec,a]) ==
  integer? a => a - 1
  a is ['%iadd,b,c] =>
    integer? b => simplifyVMForm ['%iadd,['%isub,b,1],c]
    integer? c => simplifyVMForm ['%iadd,b,['%isub,c,1]]
    x
  a is ['%isub,b,c] =>
    integer? b => simplifyVMForm ['%isub,['%isub,b,1],c]
    integer? c => simplifyVMForm ['%isub,b,['%iadd,c,1]]
    x
  x

optImul(x is ['%imul,a,b]) ==
  integer? a and integer? b => a * b
  integer? a and a = 1 => b
  integer? b and b = 1 => a
  x

optIneg(x is ['%ineg,a]) ==
  integer? a => -a
  x

optIrem(x is ['%irem,a,b]) ==
  integer? a and integer? b => a rem b
  x

optIquo(x is ['%iquo,a,b]) ==
  integer? a and integer? b => a quo b
  x

--%  
--% optimizer hash table
--%
 
for x in '((%call         optCall) _
           (SEQ          optSEQ)_
           (%bind        optBind)_
           (%try         optTry)_
           (%not         optNot)_
           (%and         optAnd)_
           (%or          optOr)_
           (%ble         optBle)_
           (%bgt         optBgt)_
           (%bge         optBge)_
           (%ieq         optIeq)_
           (%ilt         optIlt)_
           (%ile         optIle)_
           (%igt         optIgt)_
           (%ige         optIge)_
           (%ineg        optIneg)_
           (%iadd        optIadd)_
           (%iinc        optIinc)_
           (%isub        optIsub)_
           (%irem        optIrem)_
           (%iquo        optIquo)_
           (%imul        optImul)_
           (%2bit        opt2bit)_
           (%2bool       opt2bool)_
           (%list        optList)_
           (SPADCALL     optSPADCALL)_
           (_|           optSuchthat)_
           (CATCH        optCatch)_
           (%when        optCond)_
           (%retract     optRetract)_
           (%pullback    optPullback)_
           (%CollectV    optCollectVector)) _
   repeat property(first x,'OPTIMIZE) := second x
       --much quicker to call functions if they have an SBC

