
(/VERSIONCHECK 2) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Shell|)
                |INTDOM-;unitNormal;SR;1|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Thing|)
                |INTDOM-;unitCanonical;2S;2|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Pair|)
                |INTDOM-;recip;SU;3|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Boolean|)
                |INTDOM-;unit?;SB;4|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Thing| |%Shell|) |%Boolean|)
                |INTDOM-;associates?;2SB;5|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Thing| |%Shell|) |%Boolean|)
                |INTDOM-;associates?;2SB;6|)) 

(DEFUN |INTDOM-;unitNormal;SR;1| (|x| $)
  (VECTOR (|spadConstant| $ 7) |x| (|spadConstant| $ 7))) 

(DEFUN |INTDOM-;unitCanonical;2S;2| (|x| $)
  (SVREF (SPADCALL |x| (|getShellEntry| $ 10)) 1)) 

(DEFUN |INTDOM-;recip;SU;3| (|x| $)
  (COND
    ((SPADCALL |x| (|getShellEntry| $ 13)) (CONS 1 "failed"))
    (T (SPADCALL (|spadConstant| $ 7) |x| (|getShellEntry| $ 15))))) 

(DEFUN |INTDOM-;unit?;SB;4| (|x| $)
  (COND
    ((EQL (CAR (SPADCALL |x| (|getShellEntry| $ 17))) 1) NIL)
    (T T))) 

(DEFUN |INTDOM-;associates?;2SB;5| (|x| |y| $)
  (SPADCALL (SVREF (SPADCALL |x| (|getShellEntry| $ 10)) 1)
      (SVREF (SPADCALL |y| (|getShellEntry| $ 10)) 1)
      (|getShellEntry| $ 21))) 

(DEFUN |INTDOM-;associates?;2SB;6| (|x| |y| $)
  (COND
    ((SPADCALL |x| (|getShellEntry| $ 13))
     (SPADCALL |y| (|getShellEntry| $ 13)))
    ((OR (SPADCALL |y| (|getShellEntry| $ 13))
         (OR (EQL (CAR (SPADCALL |x| |y| (|getShellEntry| $ 15))) 1)
             (EQL (CAR (SPADCALL |y| |x| (|getShellEntry| $ 15))) 1)))
     NIL)
    (T T))) 

(DEFUN |IntegralDomain&| (|#1|)
  (LET* ((|dv$1| (|devaluate| |#1|))
         (|dv$| (LIST '|IntegralDomain&| |dv$1|)) ($ (|newShell| 23))
         (|pv$| (|buildPredVector| 0 0 NIL)))
    (SETF (|shellEntry| $ 0) |dv$|)
    (SETF (|shellEntry| $ 3) |pv$|)
    (|stuffDomainSlots| $)
    (SETF (|shellEntry| $ 6) |#1|)
    (COND
      ((|HasCategory| |#1| '(|Field|)))
      (T (SETF (|shellEntry| $ 9)
               (CONS (|dispatchFunction| |INTDOM-;unitNormal;SR;1|) $))))
    (COND
      ((|HasAttribute| |#1| '|canonicalUnitNormal|)
       (SETF (|shellEntry| $ 22)
             (CONS (|dispatchFunction| |INTDOM-;associates?;2SB;5|) $)))
      (T (SETF (|shellEntry| $ 22)
               (CONS (|dispatchFunction| |INTDOM-;associates?;2SB;6|)
                     $))))
    $)) 

(MAKEPROP '|IntegralDomain&| '|infovec|
    (LIST '#(NIL NIL NIL NIL NIL NIL (|local| |#1|) (0 . |One|)
             (|Record| (|:| |unit| $) (|:| |canonical| $)
                 (|:| |associate| $))
             (4 . |unitNormal|) (9 . |unitNormal|)
             |INTDOM-;unitCanonical;2S;2| (|Boolean|) (14 . |zero?|)
             (|Union| $ '"failed") (19 . |exquo|) |INTDOM-;recip;SU;3|
             (25 . |recip|) (30 . |false|) (34 . |true|)
             |INTDOM-;unit?;SB;4| (38 . =) (44 . |associates?|))
          '#(|unitNormal| 50 |unitCanonical| 55 |unit?| 60 |recip| 65
             |associates?| 70)
          'NIL
          (CONS (|makeByteWordVec2| 1 'NIL)
                (CONS '#()
                      (CONS '#()
                            (|makeByteWordVec2| 22
                                '(0 6 0 7 1 0 8 0 9 1 6 8 0 10 1 6 12 0
                                  13 2 6 14 0 0 15 1 6 14 0 17 0 12 0
                                  18 0 12 0 19 2 6 12 0 0 21 2 0 12 0 0
                                  22 1 0 8 0 9 1 0 0 0 11 1 0 12 0 20 1
                                  0 14 0 16 2 0 12 0 0 22)))))
          '|lookupComplete|)) 
