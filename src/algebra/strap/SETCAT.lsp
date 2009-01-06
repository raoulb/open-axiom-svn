
(/VERSIONCHECK 2) 

(DEFPARAMETER |SetCategory;AL| 'NIL) 

(DEFUN |SetCategory;| ()
  (PROG (#0=#:G1399)
    (RETURN
      (PROG1 (LETT #0#
                   (|sublisV|
                       (PAIR '(#1=#:G1398) (LIST '(|OutputForm|)))
                       (|Join| (|BasicType|) (|CoercibleTo| '#1#)
                               (|mkCategory| '|domain|
                                   '(((|hash| ((|SingleInteger|) $)) T)
                                     ((|latex| ((|String|) $)) T))
                                   NIL '((|String|) (|SingleInteger|))
                                   NIL)))
                   |SetCategory|)
        (|setShellEntry| #0# 0 '(|SetCategory|)))))) 

(DEFUN |SetCategory| ()
  (LET ()
    (COND
      (|SetCategory;AL|)
      (T (SETQ |SetCategory;AL| (|SetCategory;|)))))) 

(MAKEPROP '|SetCategory| 'NILADIC T) 
