;; Copyright (c) 1991-2002, The Numerical Algorithms Group Ltd.
;; All rights reserved.
;; Copyright (C) 2007-2012, Gabriel Dos Reis.
;; All rights reserved.
;;
;; Redistribution and use in source and binary forms, with or without
;; modification, are permitted provided that the following conditions are
;; met:
;;
;;     - Redistributions of source code must retain the above copyright
;;       notice, this list of conditions and the following disclaimer.
;;
;;     - Redistributions in binary form must reproduce the above copyright
;;       notice, this list of conditions and the following disclaimer in
;;       the documentation and/or other materials provided with the
;;       distribution.
;;
;;     - Neither the name of The Numerical Algorithms Group Ltd. nor the
;;       names of its contributors may be used to endorse or promote products
;;       derived from this software without specific prior written permission.
;;
;; THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
;; IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
;; TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
;; PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
;; OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
;; EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
;; PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
;; PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
;; LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
;; NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
;; SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

;; NAME:    Pre-Parsing Code
;; PURPOSE: BOOT lines are massaged by PREPARSE to make them easier to parse:
;;        1. Trailing -- comments are removed (this is already done, actually).
;;        2. Comments between { and } are removed.
;;        3. BOOT code is column-sensitive. Code which lines up columnarly is
;;           parenthesized and semicolonized accordingly.  For example,
;;
;;                a
;;                        b
;;                        c
;;                                d
;;                e
;;
;;           becomes
;;
;;                a
;;                        (b;
;;                         c
;;                                d)
;;                e
;;
;;           Note that to do this correctly, we also need to keep track of
;;           parentheses already in the code.
 


(IMPORT-MODULE "parsing")
 
(in-package "BOOT")
 
; Global storage
 
(defparameter $INDEX 0                          "File line number of most recently read line.")
(defparameter $preparse-last-line ()            "Most recently read line.")
(defparameter $preparseReportIfTrue NIL         "Should we print listings?")
(defparameter $LineList nil                     "Stack of preparsed lines.")
(defparameter $EchoLineStack nil                "Stack of lines to list.")
(defparameter $IOIndex 0                        "Number of latest terminal input line.")
 
(DEFPARAMETER TOK NIL)
(DEFPARAMETER DEFINITION_NAME NIL)
(DEFPARAMETER LABLASOC NIL)

(defun Initialize-Preparse (strm)
  (setq $INDEX 0 $LineList nil $EchoLineStack nil)
  (setq $preparse-last-line (|readLine| strm)))
 
(defvar $skipme)
 
(defun PREPARSE (Strm &aux (stack ()))
  (SETQ $COMBLOCKLIST NIL $skipme NIL)
  (when $preparse-last-line
        (if (consp $preparse-last-line)
            (setq stack $preparse-last-line)
          (push $preparse-last-line stack))
        (setq $INDEX (- $INDEX (length stack))))
  (let ((U (PREPARSE1 stack)))
    (if $skipme (preparse strm)
      (progn
        (if $preparseReportIfTrue (PARSEPRINT U))
        (setq |$headerDocumentation| NIL)
        (SETQ |$docList| NIL)
        (SETQ |$maxSignatureLineNumber| 0)
        (SETQ |$constructorLineNumber| (IFCAR (IFCAR U)))
        U))))
 
(defun PREPARSE1 (LineList)
 (PROG (($LINELIST LineList) $EchoLineStack NUM A I L PSLOC
        INSTRING PCOUNT COMSYM STRSYM OPARSYM CPARSYM N NCOMSYM
        (SLOC -1) (CONTINUE NIL)  (PARENLEV 0) (NCOMBLOCK ())
        (LINES ()) (LOCS ()) (NUMS ()) functor  )
 READLOOP (DCQ (NUM . A) (|preparseReadLine| LineList))
         (cond ((|atEndOfUnit?| A)
                (PREPARSE-ECHO LineList)
                (COND ((NULL LINES) (RETURN NIL))
                      (NCOMBLOCK
                       (FINCOMBLOCK NIL NUMS LOCS NCOMBLOCK NIL)))
                (RETURN (|pairList| (|reverse!| NUMS)
			 (PARSEPILES (|reverse!| LOCS) (|reverse!| LINES))))))
         (cond ((and (NULL LINES) (> (LENGTH A) 0) (EQ (CHAR A 0) #\) ))
                ; this is a command line, don't parse it
                (PREPARSE-ECHO LineList)
                (setq $preparse-last-line nil) ;don't reread this line
                (SETQ LINE a)
                (CATCH 'SPAD_READER (|doSystemCommand| (subseq LINE 1)))
                (GO READLOOP)))
         (setq L (LENGTH A))
         (if (EQ L 0) (GO READLOOP))
         (setq PSLOC SLOC)
         (setq I 0 INSTRING () PCOUNT 0)
 STRLOOP (setq STRSYM (OR (position #\" A :start I ) L))
         (setq COMSYM (OR (search "--" A :start2 I ) L))
         (setq NCOMSYM (OR (search "++" A :start2 I ) L))
         (setq OPARSYM (OR (position #\( A :start I ) L))
         (setq CPARSYM (OR (position #\) A :start I ) L))
         (setq N (MIN STRSYM COMSYM NCOMSYM OPARSYM CPARSYM))
         (cond ((= N L) (GO NOCOMS))
               ((|escaped?| A N))
               ((= N STRSYM) (setq INSTRING (NOT INSTRING)))
               (INSTRING)
               ((= N COMSYM) (setq A (subseq A 0 N)) (GO NOCOMS)) ; discard trailing comment
               ((= N NCOMSYM)
                (setq SLOC (|indentationLocation| A))
                (COND
                  ((= SLOC N)
                   (COND ((AND NCOMBLOCK (NOT (= N (CAR NCOMBLOCK))))
                          (FINCOMBLOCK NUM NUMS LOCS NCOMBLOCK linelist)
                          (SETQ NCOMBLOCK NIL)))
                   (SETQ NCOMBLOCK (CONS N (CONS A (IFCDR NCOMBLOCK))))
                   (SETQ A ""))
                  ('T (PUSH (STRCONC (|makeString| N #\Space)
                                  (SUBSTRING A N ())) $LINELIST)
                      (SETQ $INDEX (1- $INDEX))
                      (SETQ A (SUBSEQ A 0 N))))
         (GO NOCOMS))
               ((= N OPARSYM) (setq PCOUNT (1+ PCOUNT)))
               ((= N CPARSYM) (setq PCOUNT (1- PCOUNT))))
         (setq I (1+ N))
         (GO STRLOOP)
 NOCOMS  (setq SLOC (|indentationLocation| A))
         (setq A (|trimTrailingBlank| A))
         (cond ((NULL SLOC) (setq SLOC PSLOC) (GO READLOOP)))
         (cond ((EQ (ELT A (|maxIndex| A)) #\_)
                (setq CONTINUE T a (subseq A (|maxIndex| A))))
               ((setq CONTINUE NIL)))
         (if (and (null LINES) (= SLOC 0)) ;;test for skipping constructors
             (if (and |$byConstructors|
                      (null (search "==>" a))
                      (not (member (setq functor (intern
                                    (substring a 0 (STRPOSL ": (=" A 0 NIL))))
                                   |$byConstructors|)))
                 (setq $skipme 't)
               (progn (push functor |$constructorsSeen|) (setq $skipme nil))))
         (when (and LINES (EQL SLOC 0))
             (IF (AND NCOMBLOCK (NOT (ZEROP (CAR NCOMBLOCK))))
               (FINCOMBLOCK NUM NUMS LOCS NCOMBLOCK linelist))
             (IF (NOT (|ioTerminal?| in-stream))
                 (setq $preparse-last-line
                       (|reverse!| $echolinestack)))
             (RETURN (|pairList| (|reverse!| NUMS)
                        (PARSEPILES (|reverse!| LOCS) (|reverse!| LINES)))))
         (cond ((> PARENLEV 0) (PUSH NIL LOCS) (setq SLOC PSLOC) (GO REREAD)))
         (COND (NCOMBLOCK
                (FINCOMBLOCK NUM NUMS LOCS NCOMBLOCK linelist)
                (setq NCOMBLOCK ())))
         (PUSH SLOC LOCS)
 REREAD  (PREPARSE-ECHO LineList)
         (PUSH A LINES)
         (PUSH NUM NUMS)
         (setq PARENLEV (+ PARENLEV PCOUNT))
         (when (and (|ioTerminal?| in-stream) (not continue))
            (setq $preparse-last-line nil)
             (RETURN (|pairList| (|reverse!| NUMS)
                           (PARSEPILES (|reverse!| LOCS) (|reverse!| LINES)))))
 
         (GO READLOOP)))
 
;; NUM is the line number of the current line
;; OLDNUMS is the list of line numbers of previous lines
;; OLDLOCS is the list of previous indentation locations
;; NCBLOCK is the current comment block
(DEFUN FINCOMBLOCK (NUM OLDNUMS OLDLOCS NCBLOCK linelist)
  (PUSH
    (COND ((EQL (CAR NCBLOCK) 0) (CONS (1- NUM) (|reverse| (CDR NCBLOCK))))
              ;; comment for constructor itself paired with 1st line -1
          ('T
           (COND ($EchoLineStack
                  (setq NUM (POP $EchoLineStack))
                  (PREPARSE-ECHO linelist)
                  (SETQ $EchoLineStack (LIST NUM))))
           (cons
            ;; scan backwards for line to left of current
            (DO ((onums oldnums (cdr onums))
                 (olocs oldlocs (cdr olocs))
                 (sloc (car ncblock)))
                ((null onums) nil)
                (if (and (numberp (car olocs))
                         (<= (car olocs) sloc))
                    (return (car onums))))
            (|reverse| (CDR NCBLOCK)))))
    $COMBLOCKLIST))
 
(defun PARSEPRINT (L)
  (if L
      (progn (format t "~&~%       ***       PREPARSE      ***~%~%")
             (dolist (X L) (format t "~5d. ~a~%" (car x) (cdr x)))
             (format t "~%"))))
 
(DEFUN |preparseReadLine1| (X)
    (PROG (LINE IND)
      (SETQ LINE (if $LINELIST
                     (pop $LINELIST)
              (expand-tabs (|readLine| in-stream))))
      (setq $preparse-last-line LINE)
      (and (stringp line) (incf $INDEX))
      (COND
        ( (NOT (STRINGP LINE))
          (RETURN (LIST $INDEX)) ) )
      (SETQ LINE (|trimTrailingBlank| LINE))
      (PUSH (COPY-SEQ LINE) $EchoLineStack)
    ;; next line must evaluate $INDEX before recursive call
      (RETURN
        (CONS
          $INDEX
          (COND
            ( (AND (> (SETQ IND (|maxIndex| LINE)) -1) (char= (ELT LINE IND) #\_))
              (setq $preparse-last-line
                    (STRCONC (SUBSTRING LINE 0 IND) (CDR (|preparseReadLine1| X))) ))
            ( 'T
              LINE ) ))) ) )
 
(defun PREPARSE-ECHO (linelist)
  (if |$Echo| (REPEAT (IN X (|reverse| $EchoLineStack))
                        (format out-stream "~&;~A~%" X)))
  (setq $EchoLineStack ()))
 
(defun PARSEPILES (LOCS LINES)
  "Add parens and semis to lines to aid parsing."
  (mapl #'add-parens-and-semis-to-line 
	(|append!| LINES '(" ")) 
	(|append!| locs '(nil)))
  LINES)
 
(defun add-parens-and-semis-to-line (slines slocs)
 
  "The line to be worked on is (CAR SLINES).  
   It's indentation is (CAR SLOCS).  
   There is a notion of current indentation. Then:
 
    A. Add open paren to beginning of following line if following 
       line's indentation is greater than current, and add close paren
       to end of last succeeding line with following line's indentation.
    B. Add semicolon to end of line if following line's indentation is
       the same.
    C. If the entire line consists of the single keyword then or else, 
       leave it alone."
 
  (let ((start-column (car slocs)))
    (if (and start-column (> start-column 0))
        (let ((count 0)
	      (i 0))
          (seq
           (mapl #'(lambda (next-lines nlocs)
                     (let ((next-line (car next-lines))
			   (next-column (car nlocs)))
                       (incf i)
                       (if next-column
                           (progn 
			     (setq next-column (abs next-column))
			     (if (< next-column start-column)
				 (exit nil))
			     (cond 
			      ((and (eq next-column start-column)
				    (rplaca nlocs (- (car nlocs)))
				    (not (|infixToken?| next-line)))
			       (setq next-lines (|drop| (1- i) slines))
			       (rplaca next-lines 
				       (|addClose| (car next-lines) #\;))
			       (setq count (1+ count))))))))
                 (cdr slines) (cdr slocs)))
          (if (> count 0)
              (progn 
		(setf (char (car slines) (1- (|firstNonblankCharPosition| (car slines))))
		      #\( )
		(setq slines (|drop| (1- i) slines))
		(rplaca slines (|addClose| (car slines) #\) ))))))))
