
(/VERSIONCHECK 2) 

(DEFPARAMETER |DivisionRing;AL| 'NIL) 

(DEFUN |DivisionRing| ()
  (LET (#:G1390)
    (COND
      (|DivisionRing;AL|)
      (T (SETQ |DivisionRing;AL| (|DivisionRing;|)))))) 

(DEFUN |DivisionRing;| ()
  (PROG (#0=#:G1388)
    (RETURN
      (PROG1 (LETT #0#
                   (|sublisV|
                       (PAIR '(#1=#:G1387)
                             (LIST '(|Fraction| (|Integer|))))
                       (|Join| (|EntireRing|) (|Algebra| '#1#)
                               (|mkCategory| '|domain|
                                   '(((** ($ $ (|Integer|))) T)
                                     ((^ ($ $ (|Integer|))) T)
                                     ((|inv| ($ $)) T))
                                   NIL '((|Integer|)) NIL)))
                   |DivisionRing|)
        (SETELT #0# 0 '(|DivisionRing|)))))) 

(MAKEPROP '|DivisionRing| 'NILADIC T) 
