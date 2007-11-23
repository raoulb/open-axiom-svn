-- Copyright (c) 1991-2002, The Numerical ALgorithms Group Ltd.
-- All rights reserved.
-- Copyright (C) 2007, Gabriel Dos Reis.
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


import '"macros"
)package "BOOT"

f07adf() ==
  htInitPage('"F07ADF - {\it LU} factorization of real {\it m} by {\it n} matrix",nil)
  htMakePage '(
    (domainConditions 
       (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXf07adf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|f07adf| '|NagLapack|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "F07ADF computes the {\it LU} factorization of a real {\it m}")
    (text . " by {\it n} matrix ")
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Number of rows {\it m}:")
    (text . "\newline\tab{2} ")
    (bcStrings (5 4 m PI))
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Number of columns {\it n}:")
    (text . "\newline\tab{2} ")
    (bcStrings (5 4 n PI))
    )
--    (text . "\blankline ")
--    (text . "\menuitemstyle{}\tab{2}")
--    (text . "First dimension of array A, {\it lda}:")
--    (text . "\newline\tab{2} ")
--    (bcStrings (5 4 lda PI))
  htMakeDoneButton('"Continue", 'f07adfSolve)
  htShowPage()

f07adfSolve htPage ==
  m :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'm)
    objValUnwrap htpLabelSpadValue(htPage, 'm)
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  lda := m
  (n = '4 and m = '4) => f07adfDefaultSolve(htPage,lda)
  aList := 
    "append"/[fa(i,n) for i in 1..m] where fa(i,n) ==
       labelList := 
         "append"/[fb(i,j) for j in 1..n] where fb(i,j) ==
            anam := INTERN STRCONC ('"a",STRINGIMAGE i,STRINGIMAGE j)
            [['bcStrings,[6, 0, anam, 'F]]]
       prefix := ('"\newline ")
       labelList := [['text,:prefix],:labelList]
  equationPart := [
     '(domainConditions 
        (isDomain EM $EmptyMode)
          (isDomain S (String))
            (isDomain F (Float))
              (isDomain I (Integer))),
                :aList]
  page := htInitPage('"F07ADF - {\it LU} factorization of real {\it m} by {\it n} matrix",nil)
  htSay '"\menuitemstyle{}\tab{2} "
  htSay '"Enter the array {\it A}:"
  htSay '"\newline "
  htMakePage equationPart
  htMakeDoneButton('"Continue",'f07adfGen)
  htpSetProperty(page,'n,n)
  htpSetProperty(page,'m,m)
--  htpSetProperty(page,'lda,lda)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htShowPage()

f07adfDefaultSolve (htPage,lda)   ==
  n := '4
  m := '4
  page := htInitPage('"F07ADF - {\it LU} factorization of real {\it m} by {\it n} matrix",nil)
  htMakePage '(
    (domainConditions 
       (isDomain EM $EmptyMode)
       (isDomain F (Float))
       (isDomain I (Integer)))
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the array {\it A}:")
    (text . "\newline ")
    (bcStrings (5 "1.8" a11 F))
    (bcStrings (5 "2.88" a12 F))
    (bcStrings (5 "2.05" a13 F))
    (bcStrings (5 "-0.89" a14 F))
    (text . "\newline ")
    (bcStrings (5 "5.25" a21 F))
    (bcStrings (5 "-2.95" a22 F))
    (bcStrings (5 "-0.95" a23 F))
    (bcStrings (5 "-3.8" a24 F))
    (text . "\newline ")
    (bcStrings (5 "1.58" a31 F))
    (bcStrings (5 "-2.69" a32 F))
    (bcStrings (5 "-2.9" a33 F))
    (bcStrings (5 "-1.04" a34 F))
    (text . "\newline ")
    (bcStrings (5 "-1.11" a41 F))
    (bcStrings (5 "-0.66" a42 F))
    (bcStrings (5 "-0.59" a43 F))
    (bcStrings (5 "0.8" a44 F)))
  htpSetProperty(page,'n,n)
  htpSetProperty(page,'m,m)
--  htpSetProperty(page,'lda,lda)
  htMakeDoneButton('"Continue",'f07adfGen)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htShowPage()

f07adfGen htPage ==
  n := htpProperty(htPage, 'n)
  m := htpProperty(htPage, 'm)
  lda := m
  alist := htpInputAreaAlist htPage
  y := alist
  for i in 1..n repeat
    for j in 1..m repeat
      a := STRCONC((first y).1," ")
      rowList := [a,:rowList]
      y := rest y
    aList := [rowList,:aList]
    rowList := []
  astring := bcwords2liststring [bcwords2liststring x for x in aList]
  prefix := STRCONC("f07adf(",STRINGIMAGE m,", ",STRINGIMAGE n,", ")
  prefix := STRCONC(prefix,STRINGIMAGE lda,", ",astring,")")
  linkGen prefix
  

f07aef() ==
  htInitPage('"F07AEF - Solution of a real system of linear equations with multiple right-hand sides after factorization by F07ADF",nil)
  htMakePage '(
    (domainConditions
       (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXf07aef} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|f07aef| '|NagLapack|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "F07AEF solves a real system of linear equations with multiple right-hand sides, {\it AX=B} or ")
    (text . "\htbitmap{aTx=b} , where {\it a} has been factorized by F07ADF ")
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Form of the equations:")
    (text . "\blankline ")
    (radioButtons trans
        ("" "  N, the equations are {\it AX=B}" norm)
        ("" "  T, the equations are \htbitmap{aTx=b}" transp))
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "The order {\it n} of {\it A}: ")
    (text . "\newline ")
    (bcStrings (5 4 n PI))
--    (text . "\blankline ")
--    (text . "\menuitemstyle{}\tab{2}")
--    (text . "The order {\it m} of {\it A} used by F07AEF: ")
--    (text . "\newline ")
--    (bcStrings (5 4 m PI))
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "The number of right-hand sides, {\it nrhs}: ")
    (text . "\newline ")
    (bcStrings (5 2 nrhs PI))
--    (text . "\blankline ")
--    (text . "\menuitemstyle{}\tab{2}")
--    (text . "First dimension of {\it A}, {\it lda}: ")
--    (text . "\newline ")
--    (bcStrings (5 4 lda PI))
--    (text . "\blankline ")
--    (text . "\menuitemstyle{}\tab{2}")
--    (text . "First dimension of {\it B}, {\it ldb}: ")
--    (text . "\newline ")
--    (bcStrings (5 4 ldb PI))
  )
  htMakeDoneButton('"Continue", 'f07aefSolve)
  htShowPage()

f07aefSolve htPage ==
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
--  m :=
--    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'm)
--    objValUnwrap htpLabelSpadValue(htPage, 'm)
  nrhs :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'nrhs)
    objValUnwrap htpLabelSpadValue(htPage, 'nrhs)
  lda := n
--    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'lda)
--    objValUnwrap htpLabelSpadValue(htPage, 'lda)
  ldb := n
--    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'ldb)
--    objValUnwrap htpLabelSpadValue(htPage, 'ldb)
  equa := htpButtonValue(htPage, 'trans)
  trans :=
    equa = 'norm => '"N"
    '"T"
  (n = '4 and nrhs = '2 ) => f07aefDefaultSolve (htPage,trans)
  aList :=
    "append"/[fa(i,n) for i in 1..lda] where fa(i,n) ==
       labelList :=
         "append"/[faa(i,j) for j in 1..n] where faa(i,j) ==
            anam := INTERN STRCONC ('"a",STRINGIMAGE i,STRINGIMAGE j)
            [['bcStrings, [6, 0, anam, 'F]]]
       prefix := ('"\newline ")
       labelList := [['text,:prefix],:labelList]
  ipList :=
       [fp(i) for i in 1..n] where fp(i) ==
           ipnam := INTERN STRCONC ('"ip",STRINGIMAGE i)
           ['bcStrings,[5, 0, ipnam, 'I]]
  middle := ('"\blankline \menuitemstyle{}\tab{2} Enter the pivot ")
  middle := STRCONC(middle,'"indices {\it IPIV} from F07ADF: ")
  middle := STRCONC(middle,'"\newline ")
  ipList := [['text,:middle],:ipList]
  bList :=
    "append"/[fb(i,nrhs) for i in 1..n] where fb(i,nrhs) ==
       labelList :=
         "append"/[fbb(i,j) for j in 1..nrhs] where fbb(i,j) ==
            bnam := INTERN STRCONC ('"b",STRINGIMAGE i,STRINGIMAGE j)
            [['bcStrings, [6, 0, bnam, 'F]]]
       prefix := ('"\newline ")
       labelList := [['text,:prefix],:labelList]
  prefix := ("\blankline \menuitemstyle{}\tab{2} Enter the matrix {\it B}: ")
  bList := [['text,:prefix],:bList]
  equationPart := [
     '(domainConditions
        (isDomain EM $EmptyMode)
         (isDomain S (String))
          (isDomain F (Float))
           (isDomain I (Integer)))
             ,:aList,:ipList,:bList]
  page := htInitPage('"F07AEF - Solution of a real system of linear equations with multiple right-hand sides after factorization by F07ADF",nil)
  htSay '"\menuitemstyle{}\tab{2} "
  htSay '"Enter the matrix {\it A}:"
  htSay '"\newline "
  htMakePage equationPart
  htMakeDoneButton('"Continue",'f07aefGen)
  htpSetProperty(page,'n,n)
--  htpSetProperty(page,'m,m)
  htpSetProperty(page,'nrhs,nrhs)
--  htpSetProperty(page,'lda,lda)
--  htpSetProperty(page,'ldb,ldb)
  htpSetProperty(page,'trans,trans)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htShowPage()

f07aefDefaultSolve (htPage,trans) ==
  n := '4
  nrhs := '2
  lda := '4
  ldb := '4
  length := '4
  page := htInitPage('"F07AEF - Solution of a real system of linear equations with multiple right-hand sides after factorization by F07ADF",nil)
  htMakePage '(
    (domainConditions
       (isDomain EM $EmptyMode)
       (isDomain F (Float))
       (isDomain I (Integer)))
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the matrix {\it A}:")
    (text . "\newline ")
    (bcStrings (5 "5.25" a11 F))
    (bcStrings (5 "-2.95" a12 F))
    (bcStrings (5 "-0.95" a13 F))
    (bcStrings (5 "-3.8" a14 F))
    (text . "\newline ")
    (bcStrings (5 "0.34" a21 F))
    (bcStrings (5 "3.89" a22 F))
    (bcStrings (5 "2.38" a23 F))
    (bcStrings (5 "0.41" a24 F))
    (text . "\newline ")
    (bcStrings (5 "0.3" a31 F))
    (bcStrings (5 "-0.46" a32 F))
    (bcStrings (5 "-1.51" a33 F))
    (bcStrings (5 "0.29" a34 F))
    (text . "\newline ")
    (bcStrings (5 "-0.21" a41 F))
    (bcStrings (5 "-0.33" a42 F))
    (bcStrings (5 "0.00" a43 F))
    (bcStrings (5 "0.13" a44 F))
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the pivot indices {\it IPIV} from F07ADF: ")
    (text . "\newline ")
    (bcStrings (5 2 ip1 PI))
    (bcStrings (5 2 ip2 PI))
    (bcStrings (5 3 ip3 PI))
    (bcStrings (5 4 ip4 PI))
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the matrix {\it B}:")
    (text . "\newline ")
    (bcStrings (5 "9.52" b11 F))
    (bcStrings (5 "18.47" b12 F))
    (text . "\newline ")
    (bcStrings (5 "24.35" b21 F))
    (bcStrings (5 "2.25" b22 F))
    (text . "\newline ")
    (bcStrings (5 "0.77" b31 F))
    (bcStrings (5 "-13.28" b32 F))
    (text . "\newline ")
    (bcStrings (5 "-6.22" b41 F))
    (bcStrings (5 "-6.21" b42 F)))
  htpSetProperty(page,'trans,trans)
  htpSetProperty(page,'n,n)
  htpSetProperty(page,'nrhs,nrhs)
--  htpSetProperty(page,'lda,lda)
--  htpSetProperty(page,'ldb,ldb)
  htpSetProperty(page,'length,length)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htMakeDoneButton('"Continue",'f07aefGen)
  htShowPage()

f07aefGen htPage ==
  n := htpProperty(htPage, 'n)
  nrhs := htpProperty(htPage, 'nrhs)
--  lda := htpProperty(htPage, 'lda)
--  ldb := htpProperty(htPage, 'ldb)
  lda := n
  ldb := n
  length := htpProperty(htPage, 'length)
  trans := htpProperty(htPage,'trans)
  aplist := htpInputAreaAlist htPage
  y := aplist
  for i in 1..n repeat
    for j in 1..nrhs repeat
      b := STRCONC((first y).1," ")
      rowList := [b,:rowList]
      y := rest y
    bList := [rowList,:bList]
    rowList := []
  bstring := bcwords2liststring [bcwords2liststring x for x in bList]
  for i in 1..length repeat
    ip := STRCONC((first y).1," ")
    ipList := [ip,:ipList]
    y := rest y
  ipstring := bcwords2liststring ipList
  for i in 1..lda repeat
    for j in 1..n repeat
      a := STRCONC((first y).1," ")
      rowList := [a,:rowList]
      y := rest y
    aList := [rowList,:aList]
    rowList := []
  astring := bcwords2liststring [bcwords2liststring x for x in aList]
  prefix := STRCONC("f07aef(_"", trans,"_", ",STRINGIMAGE n,", ")
  prefix := STRCONC(prefix,STRINGIMAGE nrhs,", ",astring,"::Matrix DoubleFloat, ")
  prefix := STRCONC(prefix,STRINGIMAGE lda,", [",ipstring,"]::Matrix INT, ")
  prefix := STRCONC(prefix,STRINGIMAGE ldb,", ",bstring,"::Matrix DoubleFloat)")
  linkGen prefix

f07fdf() ==
  htInitPage('"F07FDF - Cholesky factorization of a real symmmetric positive-definite matrix {\it A}",nil)
  htMakePage '(
    (domainConditions
       (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXf07fdf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|f07fdf| '|NagLapack|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "F07FDF computes the Cholesky factorization of a real symmetric positive-definite ")
    (text . "matrix {\it A} ")
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Method of factorization of {\it A}, {\it UPLO}:")
    (text . "\blankline ")
    (radioButtons uplo
        ("" "  L, {\it A} factorized as lower triangular" lower)
        ("" "  U, {\it A} factorized as upper triangular" upper))
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "The order {\it n} of {\it A}: ")
    (text . "\newline ")
    (bcStrings (5 4 n PI))
--    (text . "\blankline ")
--    (text . "\menuitemstyle{}\tab{2}")
--    (text . "First dimension of {\it A}, {\it lda}:")
--    (text . "\newline ")
--    (bcStrings (5 4 lda PI)))
    )
  htMakeDoneButton('"Continue", 'f07fdfSolve)
  htShowPage()

f07fdfSolve htPage ==
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  lda := n
--    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'lda)
--    objValUnwrap htpLabelSpadValue(htPage, 'lda)
  upl := htpButtonValue(htPage, 'uplo)
  uplo:=
    upl = 'lower => '"L"
    '"U"
  (n = '4 ) => f07fdfDefaultSolve(htPage,uplo)
  aList :=
    "append"/[fa(i,n) for i in 1..lda] where fa(i,n) ==
       labelList :=
         "append"/[fb(i,j) for j in 1..n] where fb(i,j) ==
            anam := INTERN STRCONC ('"a",STRINGIMAGE i,STRINGIMAGE j)
            [['bcStrings, [6, 0, anam, 'F]]]
       prefix := ('"\newline ")
       labelList := [['text,:prefix],:labelList]
  equationPart := [
     '(domainConditions
        (isDomain EM $EmptyMode)
          (isDomain S  (String))
            (isDomain F  (Float))
              (isDomain I (Integer))),
                :aList]
  page := htInitPage('"F07FDF - Cholesky factorization of a real symmmetric positive-definite matrix {\it A}",nil)
  htSay '"\menuitemstyle{}\tab{2} "
  htSay '"Enter the matrix {\it A}:"
  htSay '"\newline "
  htMakePage equationPart
  htMakeDoneButton('"Continue",'f07fdfGen)
  htpSetProperty(page,'uplo,uplo)
  htpSetProperty(page,'n,n)
--  htpSetProperty(page,'lda,lda)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htShowPage()

f07fdfDefaultSolve (htPage,uplo) ==
  n := '4
  lda := '4
  page := htInitPage('"F07FDF - Cholesky factorization of a real symmmetric positive-definite matrix {\it A}",nil)
  htMakePage '(
    (domainConditions
       (isDomain EM $EmptyMode)
       (isDomain F (Float))
       (isDomain I (Integer)))
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the matrix {\it A}:")
    (text . "\newline ")
    (bcStrings (5 "4.16" a11 F))
    (bcStrings (5 "0.0" a12 F))
    (bcStrings (5 "0.0" a13 F))
    (bcStrings (5 "0.0" a14 F))
    (text . "\newline ")
    (bcStrings (5 "-3.12" a21 F))
    (bcStrings (5 "5.03" a22 F))
    (bcStrings (5 "0.0" a23 F))
    (bcStrings (5 "0.0" a24 F))
    (text . "\newline ")
    (bcStrings (5 "0.56" a31 F))
    (bcStrings (5 "-0.83" a32 F))
    (bcStrings (5 "0.76" a33 F))
    (bcStrings (5 "0.0" a34 F))
    (text . "\newline ")
    (bcStrings (5 "-0.1" a41 F))
    (bcStrings (5 "1.18" a42 F))
    (bcStrings (5 "0.34" a43 F))
    (bcStrings (5 "1.18" a44 F)))
  htpSetProperty(page,'uplo,uplo)
  htpSetProperty(page,'n,n)
--  htpSetProperty(page,'lda,lda)
  htMakeDoneButton('"Continue",'f07fdfGen)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htShowPage()

f07fdfGen htPage ==
  n := htpProperty(htPage, 'n)
--  lda := htpProperty(htPage, 'lda)
  lda := n
  uplo := htpProperty(htPage,'uplo)
  alist := htpInputAreaAlist htPage
  y := alist
  for i in 1..n repeat
    for j in 1..n repeat
      a := STRCONC((first y).1," ")
      rowList := [a,:rowList]
      y := rest y
    aList := [rowList,:aList]
    rowList := []
  astring := bcwords2liststring [bcwords2liststring x for x in aList]
  prefix := STRCONC("f07fdf(_"", uplo,"_", ",STRINGIMAGE n,", ")
  prefix := STRCONC(prefix,STRINGIMAGE lda,", ",astring,")")
  linkGen prefix
  

f07fef() ==
  htInitPage('"F07FEF - Solution of a real symmetric positive-definite system of linear equations with multiple right-hand sides after factorization by F07FDF",nil)
  htMakePage '(
    (domainConditions
       (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXf07fef} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|f07fef| '|NagLapack|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "F07FEF solves a real symmetric positive-definite system of linear ")
    (text . "equations with multiple right-hand sides, {\it AX=B}, where ")
    (text . "{\it A} has been factorized by F07FDF ")
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Method of factorization of {\it A}, {\it UPLO}:")
    (text . "\blankline ")
    (radioButtons uplo
        ("" "  L, {\it A} factorized as lower triangular" lower)
        ("" "  U, {\it A} factorized as upper triangular" upper))
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "The order {\it n} of {\it A}: ")
    (text . "\newline ")
    (bcStrings (5 4 n PI))
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "The number of right-hand sides, {\it nrhs}: ")
    (text . "\newline ")
    (bcStrings (5 2 nrhs PI))
--    (text . "\blankline ")
--    (text . "\menuitemstyle{}\tab{2}")
--    (text . "First dimension of {\it A}, {\it lda}: ")
--    (text . "\newline ")
--    (bcStrings (5 4 lda PI))
--    (text . "\blankline ")
--    (text . "\menuitemstyle{}\tab{2}")
--    (text . "First dimension of {\it B}, {\it ldb}: ")
--    (text . "\newline ")
--    (bcStrings (5 4 ldb PI)))
    )
  htMakeDoneButton('"Continue", 'f07fefSolve)
  htShowPage()

f07fefSolve htPage ==
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  nrhs :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'nrhs)
    objValUnwrap htpLabelSpadValue(htPage, 'nrhs)
  lda := n
--    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'lda)
--    objValUnwrap htpLabelSpadValue(htPage, 'lda)
  ldb := n
--    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'ldb)
--    objValUnwrap htpLabelSpadValue(htPage, 'ldb)
  upl := htpButtonValue(htPage, 'uplo)
  uplo:=
    upl = 'lower => '"L"
    '"U"
  (n = '4 and nrhs = '2) => f07fefDefaultSolve(htPage,uplo)
  aList :=
    "append"/[fa(i,n) for i in 1..lda] where fa(i,n) ==
       labelList :=
         "append"/[faa(i,j) for j in 1..n] where faa(i,j) ==
            anam := INTERN STRCONC ('"a",STRINGIMAGE i,STRINGIMAGE j)
            [['bcStrings, [8, 0, anam, 'F]]]
       prefix := ('"\newline ")
       labelList := [['text,:prefix],:labelList]
  bList :=
    "append"/[fb(i,nrhs) for i in 1..n] where fb(i,nrhs) ==
       labelList :=
         "append"/[fbb(i,j) for j in 1..nrhs] where fbb(i,j) ==
            bnam := INTERN STRCONC ('"b",STRINGIMAGE i,STRINGIMAGE j)
            [['bcStrings, [8, 0, bnam, 'F]]]
       prefix := ('"\newline ")
       labelList := [['text,:prefix],:labelList]
  prefix := ("\blankline \menuitemstyle{}\tab{2} Enter the matrix {\it B}: ")
  bList := [['text,:prefix],:bList]
  equationPart := [
     '(domainConditions
        (isDomain EM $EmptyMode)
         (isDomain S (String))
          (isDomain F (Float))
           (isDomain I (Integer)))
             ,:aList,:bList]
  page := htInitPage('"F07FEF - Solution of a real symmetric positive-definite system of linear equations with multiple right-hand sides after factorization by F07FDF",nil)
  htSay '"\menuitemstyle{}\tab{2} "
  htSay '"Enter the matrix {\it A}:"
  htSay '"\newline "
  htMakePage equationPart
  htMakeDoneButton('"Continue",'f07fefGen)
  htpSetProperty(page,'uplo,uplo)
  htpSetProperty(page,'n,n)
  htpSetProperty(page,'nrhs,nrhs)
--  htpSetProperty(page,'lda,lda)
--  htpSetProperty(page,'ldb,ldb)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htShowPage()

f07fefDefaultSolve (htPage,uplo) ==
  n := '4
  nrhs := '2
  lda := '4
  ldb := '4
  page := htInitPage('"F07FEF - Solution of a real symmetric positive-definite system of linear equations with multiple right-hand sides after factorization by F07FDF",nil)
  htMakePage '(
    (domainConditions
       (isDomain EM $EmptyMode)
       (isDomain F (Float))
       (isDomain I (Integer)))
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the matrix {\it A}:")
    (text . "\newline ")
    (bcStrings (8 "2.04" a11 F))
    (bcStrings (8 "0.0" a12 F))
    (bcStrings (8 "0.0" a13 F))
    (bcStrings (8 "0.0" a14 F))
    (text . "\newline ")
    (bcStrings (8 "-1.53" a21 F))
    (bcStrings (8 "1.64" a22 F))
    (bcStrings (8 "0.0" a23 F))
    (bcStrings (8 "0.0" a24 F))
    (text . "\newline ")
    (bcStrings (8 "0.28" a31 F))
    (bcStrings (8 "-0.25" a32 F))
    (bcStrings (8 "0.79" a33 F))
    (bcStrings (8 "0.0" a34 F))
    (text . "\newline ")
    (bcStrings (8 "-0.05" a41 F))
    (bcStrings (8 "0.67" a42 F))
    (bcStrings (8 "0.66" a43 F))
    (bcStrings (8 "0.54" a44 F))
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the matrix {\it B}:")
    (text . "\newline ")
    (bcStrings (8 "8.7" b11 F))
    (bcStrings (8 "8.3" b12 F))
    (text . "\newline ")
    (bcStrings (8 "-13.35" b21 F))
    (bcStrings (8 "2.13" b22 F))
    (text . "\newline ")
    (bcStrings (8 "1.89" b31 F))
    (bcStrings (8 "1.61" b32 F))
    (text . "\newline ")
    (bcStrings (8 "-4.14" b41 F))
    (bcStrings (8 "5" b42 F)))
  htpSetProperty(page,'uplo,uplo)
  htpSetProperty(page,'n,n)
  htpSetProperty(page,'nrhs,nrhs)
--  htpSetProperty(page,'lda,lda)
--  htpSetProperty(page,'ldb,ldb)
  htpSetProperty(page,'inputArea, htpInputAreaAlist htPage)
  htMakeDoneButton('"Continue",'f07fefGen)
  htShowPage()

f07fefGen htPage ==
  n := htpProperty(htPage, 'n)
  nrhs := htpProperty(htPage, 'nrhs)
--  lda := htpProperty(htPage, 'lda)
--  ldb := htpProperty(htPage, 'ldb)
  lda := n
  ldb := n
  uplo := htpProperty(htPage,'uplo)
  aplist := htpInputAreaAlist htPage
  y := aplist
  for i in 1..n repeat
    for j in 1..nrhs repeat
      b := STRCONC((first y).1," ")
      rowList := [b,:rowList]
      y := rest y
    bList := [rowList,:bList]
    rowList := []
  bstring := bcwords2liststring [bcwords2liststring x for x in bList]
  for i in 1..lda repeat
    for j in 1..n repeat
      a := STRCONC((first y).1," ")
      rowList := [a,:rowList]
      y := rest y
    aList := [rowList,:aList]
    rowList := []
  astring := bcwords2liststring [bcwords2liststring x for x in aList]
  prefix := STRCONC("f07fef(_"", uplo,"_", ",STRINGIMAGE n,", ")
  prefix := STRCONC(prefix,STRINGIMAGE nrhs,", ",astring,"::Matrix DoubleFloat, ")
  prefix := STRCONC(prefix,STRINGIMAGE lda,", ")
  prefix := STRCONC(prefix,STRINGIMAGE ldb,", ",bstring,"::Matrix DoubleFloat)")
  linkGen prefix

