
(/VERSIONCHECK 2) 

(DEFPARAMETER |OrderedRing;AL| 'NIL) 

(DEFUN |OrderedRing;| ()
  (LET ((#0=#:G1378
            (|Join| (|OrderedAbelianGroup|) (|Ring|) (|Monoid|)
                    (|mkCategory| '|domain|
                        '(((|positive?| ((|Boolean|) $)) T)
                          ((|negative?| ((|Boolean|) $)) T)
                          ((|sign| ((|Integer|) $)) T)
                          ((|abs| ($ $)) T))
                        NIL '((|Integer|) (|Boolean|)) NIL))))
    (SETF (|shellEntry| #0# 0) '(|OrderedRing|))
    #0#)) 

(DEFUN |OrderedRing| ()
  (COND
    (|OrderedRing;AL|)
    (T (SETQ |OrderedRing;AL| (|OrderedRing;|))))) 

(MAKEPROP '|OrderedRing| 'NILADIC T) 
