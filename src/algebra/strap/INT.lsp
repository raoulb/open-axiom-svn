
(/VERSIONCHECK 2) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Integer| |%Shell|) |%Void|)
                |INT;writeOMInt|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%String|)
                |INT;OMwrite;$S;2|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Boolean| |%Shell|) |%String|)
                |INT;OMwrite;$BS;3|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Integer| |%Shell|) |%Void|)
                |INT;OMwrite;Omd$V;4|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Integer| |%Boolean| |%Shell|)
                    |%Void|)
                |INT;OMwrite;Omd$BV;5|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Boolean|)
                |INT;zero?;$B;6|)) 

(PUT '|INT;zero?;$B;6| '|SPADreplace| 'ZEROP) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Boolean|)
                |INT;one?;$B;7|)) 

(PUT '|INT;one?;$B;7| '|SPADreplace| '(XLAM (|x|) (|%ieq| |x| 1))) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%Integer|) |INT;Zero;$;8|)) 

(PUT '|INT;Zero;$;8| '|SPADreplace| '(XLAM NIL 0)) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%Integer|) |INT;One;$;9|)) 

(PUT '|INT;One;$;9| '|SPADreplace| '(XLAM NIL 1)) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%Integer|) |INT;base;$;10|)) 

(PUT '|INT;base;$;10| '|SPADreplace| '(XLAM NIL 2)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;copy;2$;11|)) 

(PUT '|INT;copy;2$;11| '|SPADreplace| '(XLAM (|x|) |x|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;inc;2$;12|)) 

(PUT '|INT;inc;2$;12| '|SPADreplace| '(XLAM (|x|) (|%iadd| |x| 1))) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;dec;2$;13|)) 

(PUT '|INT;dec;2$;13| '|SPADreplace| '(XLAM (|x|) (|%isub| |x| 1))) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Short|)
                |INT;hash;$Si;14|)) 

(PUT '|INT;hash;$Si;14| '|SPADreplace| 'SXHASH) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Boolean|)
                |INT;negative?;$B;15|)) 

(PUT '|INT;negative?;$B;15| '|SPADreplace| 'MINUSP) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Thing|)
                |INT;coerce;$Of;16|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;coerce;2$;17|)) 

(PUT '|INT;coerce;2$;17| '|SPADreplace| '(XLAM (|m|) |m|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;convert;2$;18|)) 

(PUT '|INT;convert;2$;18| '|SPADreplace| '(XLAM (|x|) |x|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;length;2$;19|)) 

(PUT '|INT;length;2$;19| '|SPADreplace| 'INTEGER-LENGTH) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Integer| |%Shell|)
                    |%Integer|)
                |INT;addmod;4$;20|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Integer| |%Shell|)
                    |%Integer|)
                |INT;submod;4$;21|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Integer| |%Shell|)
                    |%Integer|)
                |INT;mulmod;4$;22|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Thing|)
                |INT;convert;$F;23|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%DoubleFloat|)
                |INT;convert;$Df;24|)) 

(PUT '|INT;convert;$Df;24| '|SPADreplace|
     '(XLAM (|x|) (FLOAT |x| |$DoubleFloatMaximum|))) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Thing|)
                |INT;convert;$If;25|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%String|)
                |INT;convert;$S;26|)) 

(PUT '|INT;convert;$S;26| '|SPADreplace| 'STRINGIMAGE) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%String|)
                |INT;latex;$S;27|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;positiveRemainder;3$;28|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Thing|)
                |INT;reducedSystem;2M;29|)) 

(PUT '|INT;reducedSystem;2M;29| '|SPADreplace| '(XLAM (|m|) |m|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| (|%Vector| *) |%Shell|) |%Pair|)
                |INT;reducedSystem;MVR;30|)) 

(PUT '|INT;reducedSystem;MVR;30| '|SPADreplace|
     '(XLAM (|m| |v|) (CONS |m| '|vec|))) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;abs;2$;31|)) 

(PUT '|INT;abs;2$;31| '|SPADreplace| '|%iabs|) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%Integer|) |INT;random;$;32|)) 

(PUT '|INT;random;$;32| '|SPADreplace| '|random|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;random;2$;33|)) 

(PUT '|INT;random;2$;33| '|SPADreplace| 'RANDOM) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Boolean|)
                |INT;=;2$B;34|)) 

(PUT '|INT;=;2$B;34| '|SPADreplace| '|%ieq|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Boolean|)
                |INT;<;2$B;35|)) 

(PUT '|INT;<;2$B;35| '|SPADreplace| '|%ilt|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Boolean|)
                |INT;>;2$B;36|)) 

(PUT '|INT;>;2$B;36| '|SPADreplace| '|%igt|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Boolean|)
                |INT;<=;2$B;37|)) 

(PUT '|INT;<=;2$B;37| '|SPADreplace| '|%ile|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Boolean|)
                |INT;>=;2$B;38|)) 

(PUT '|INT;>=;2$B;38| '|SPADreplace| '|%ige|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;-;2$;39|)) 

(PUT '|INT;-;2$;39| '|SPADreplace| '-) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;+;3$;40|)) 

(PUT '|INT;+;3$;40| '|SPADreplace| '|%iadd|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;-;3$;41|)) 

(PUT '|INT;-;3$;41| '|SPADreplace| '|%isub|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;*;3$;42|)) 

(PUT '|INT;*;3$;42| '|SPADreplace| '|%imul|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;*;3$;43|)) 

(PUT '|INT;*;3$;43| '|SPADreplace| '|%imul|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| (|%IntegerSection| 0) |%Shell|)
                    |%Integer|)
                |INT;**;$Nni$;44|)) 

(PUT '|INT;**;$Nni$;44| '|SPADreplace| '|%ipow|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Boolean|)
                |INT;odd?;$B;45|)) 

(PUT '|INT;odd?;$B;45| '|SPADreplace| '|%iodd?|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;max;3$;46|)) 

(PUT '|INT;max;3$;46| '|SPADreplace| '|%imax|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;min;3$;47|)) 

(PUT '|INT;min;3$;47| '|SPADreplace| '|%imin|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Pair|)
                |INT;divide;2$R;48|)) 

(PUT '|INT;divide;2$R;48| '|SPADreplace| 'DIVIDE2) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;quo;3$;49|)) 

(PUT '|INT;quo;3$;49| '|SPADreplace| 'QUOTIENT2) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;rem;3$;50|)) 

(PUT '|INT;rem;3$;50| '|SPADreplace| 'REMAINDER2) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;shift;3$;51|)) 

(PUT '|INT;shift;3$;51| '|SPADreplace| 'ASH) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Pair|)
                |INT;recip;$U;52|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Integer| |%Shell|) |%Integer|)
                |INT;gcd;3$;53|)) 

(PUT '|INT;gcd;3$;53| '|SPADreplace| '|%igcd|) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Shell|)
                |INT;unitNormal;$R;54|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%Integer|)
                |INT;unitCanonical;2$;55|)) 

(PUT '|INT;unitCanonical;2$;55| '|SPADreplace| '|%iabs|) 

(DECLAIM (FTYPE (FUNCTION (|%List| |%Thing| |%Shell|) |%Pair|)
                |INT;solveLinearPolynomialEquation|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Thing|)
                |INT;squareFreePolynomial|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Thing|)
                |INT;factorPolynomial|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Shell|) |%Thing|)
                |INT;factorSquareFreePolynomial|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%Thing| |%Shell|) |%Thing|)
                |INT;gcdPolynomial;3Sup;60|)) 

(DEFUN |INT;writeOMInt| (|dev| |x| $)
  (SEQ (COND
         ((< |x| 0)
          (SEQ (SPADCALL |dev| (|getShellEntry| $ 13))
               (SPADCALL |dev| "arith1" "unary_minus"
                   (|getShellEntry| $ 15))
               (SPADCALL |dev| (- |x|) (|getShellEntry| $ 18))
               (EXIT (SPADCALL |dev| (|getShellEntry| $ 19)))))
         ('T (SPADCALL |dev| |x| (|getShellEntry| $ 18)))))) 

(DEFUN |INT;OMwrite;$S;2| (|x| $)
  (PROG (|sp| |dev| |s|)
    (RETURN
      (SEQ (LETT |s| "" |INT;OMwrite;$S;2|)
           (LETT |sp| (OM-STRINGTOSTRINGPTR |s|) |INT;OMwrite;$S;2|)
           (LETT |dev|
                 (SPADCALL |sp| (SPADCALL (|getShellEntry| $ 21))
                     (|getShellEntry| $ 22))
                 |INT;OMwrite;$S;2|)
           (SPADCALL |dev| (|getShellEntry| $ 23))
           (|INT;writeOMInt| |dev| |x| $)
           (SPADCALL |dev| (|getShellEntry| $ 24))
           (SPADCALL |dev| (|getShellEntry| $ 25))
           (LETT |s| (OM-STRINGPTRTOSTRING |sp|) |INT;OMwrite;$S;2|)
           (EXIT |s|))))) 

(DEFUN |INT;OMwrite;$BS;3| (|x| |wholeObj| $)
  (PROG (|sp| |dev| |s|)
    (RETURN
      (SEQ (LETT |s| "" |INT;OMwrite;$BS;3|)
           (LETT |sp| (OM-STRINGTOSTRINGPTR |s|) |INT;OMwrite;$BS;3|)
           (LETT |dev|
                 (SPADCALL |sp| (SPADCALL (|getShellEntry| $ 21))
                     (|getShellEntry| $ 22))
                 |INT;OMwrite;$BS;3|)
           (COND (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 23))))
           (|INT;writeOMInt| |dev| |x| $)
           (COND (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 24))))
           (SPADCALL |dev| (|getShellEntry| $ 25))
           (LETT |s| (OM-STRINGPTRTOSTRING |sp|) |INT;OMwrite;$BS;3|)
           (EXIT |s|))))) 

(DEFUN |INT;OMwrite;Omd$V;4| (|dev| |x| $)
  (SEQ (SPADCALL |dev| (|getShellEntry| $ 23))
       (|INT;writeOMInt| |dev| |x| $)
       (EXIT (SPADCALL |dev| (|getShellEntry| $ 24))))) 

(DEFUN |INT;OMwrite;Omd$BV;5| (|dev| |x| |wholeObj| $)
  (SEQ (COND (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 23))))
       (|INT;writeOMInt| |dev| |x| $)
       (EXIT (COND
               (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 24))))))) 

(DEFUN |INT;zero?;$B;6| (|x| $) (DECLARE (IGNORE $)) (ZEROP |x|)) 

(DEFUN |INT;one?;$B;7| (|x| $) (DECLARE (IGNORE $)) (EQL |x| 1)) 

(DEFUN |INT;Zero;$;8| ($) (DECLARE (IGNORE $)) 0) 

(DEFUN |INT;One;$;9| ($) (DECLARE (IGNORE $)) 1) 

(DEFUN |INT;base;$;10| ($) (DECLARE (IGNORE $)) 2) 

(DEFUN |INT;copy;2$;11| (|x| $) (DECLARE (IGNORE $)) |x|) 

(DEFUN |INT;inc;2$;12| (|x| $) (DECLARE (IGNORE $)) (+ |x| 1)) 

(DEFUN |INT;dec;2$;13| (|x| $) (DECLARE (IGNORE $)) (- |x| 1)) 

(DEFUN |INT;hash;$Si;14| (|x| $) (DECLARE (IGNORE $)) (SXHASH |x|)) 

(DEFUN |INT;negative?;$B;15| (|x| $)
  (DECLARE (IGNORE $))
  (MINUSP |x|)) 

(DEFUN |INT;coerce;$Of;16| (|x| $)
  (SPADCALL |x| (|getShellEntry| $ 45))) 

(DEFUN |INT;coerce;2$;17| (|m| $) (DECLARE (IGNORE $)) |m|) 

(DEFUN |INT;convert;2$;18| (|x| $) (DECLARE (IGNORE $)) |x|) 

(DEFUN |INT;length;2$;19| (|a| $)
  (DECLARE (IGNORE $))
  (INTEGER-LENGTH |a|)) 

(DEFUN |INT;addmod;4$;20| (|a| |b| |p| $)
  (PROG (|c|)
    (RETURN
      (SEQ (LETT |c| (+ |a| |b|) |INT;addmod;4$;20|)
           (EXIT (COND ((>= |c| |p|) (- |c| |p|)) ('T |c|))))))) 

(DEFUN |INT;submod;4$;21| (|a| |b| |p| $)
  (PROG (|c|)
    (RETURN
      (SEQ (LETT |c| (- |a| |b|) |INT;submod;4$;21|)
           (EXIT (COND ((< |c| 0) (+ |c| |p|)) ('T |c|))))))) 

(DEFUN |INT;mulmod;4$;22| (|a| |b| |p| $)
  (REMAINDER2 (* |a| |b|) |p|)) 

(DEFUN |INT;convert;$F;23| (|x| $)
  (SPADCALL |x| (|getShellEntry| $ 57))) 

(DEFUN |INT;convert;$Df;24| (|x| $)
  (DECLARE (IGNORE $))
  (FLOAT |x| |$DoubleFloatMaximum|)) 

(DEFUN |INT;convert;$If;25| (|x| $)
  (SPADCALL |x| (|getShellEntry| $ 63))) 

(DEFUN |INT;convert;$S;26| (|x| $)
  (DECLARE (IGNORE $))
  (STRINGIMAGE |x|)) 

(DEFUN |INT;latex;$S;27| (|x| $)
  (PROG (|s|)
    (RETURN
      (SEQ (LETT |s| (STRINGIMAGE |x|) |INT;latex;$S;27|)
           (COND ((< -1 |x|) (COND ((< |x| 10) (EXIT |s|)))))
           (EXIT (STRCONC "{" (STRCONC |s| "}"))))))) 

(DEFUN |INT;positiveRemainder;3$;28| (|a| |b| $)
  (PROG (|r|)
    (RETURN
      (COND
        ((MINUSP (LETT |r| (REMAINDER2 |a| |b|)
                       |INT;positiveRemainder;3$;28|))
         (COND ((MINUSP |b|) (- |r| |b|)) ('T (+ |r| |b|))))
        ('T |r|))))) 

(DEFUN |INT;reducedSystem;2M;29| (|m| $) (DECLARE (IGNORE $)) |m|) 

(DEFUN |INT;reducedSystem;MVR;30| (|m| |v| $)
  (DECLARE (IGNORE $))
  (CONS |m| '|vec|)) 

(DEFUN |INT;abs;2$;31| (|x| $) (DECLARE (IGNORE $)) (ABS |x|)) 

(DEFUN |INT;random;$;32| ($) (DECLARE (IGNORE $)) (|random|)) 

(DEFUN |INT;random;2$;33| (|x| $) (DECLARE (IGNORE $)) (RANDOM |x|)) 

(DEFUN |INT;=;2$B;34| (|x| |y| $) (DECLARE (IGNORE $)) (EQL |x| |y|)) 

(DEFUN |INT;<;2$B;35| (|x| |y| $) (DECLARE (IGNORE $)) (< |x| |y|)) 

(DEFUN |INT;>;2$B;36| (|x| |y| $) (DECLARE (IGNORE $)) (> |x| |y|)) 

(DEFUN |INT;<=;2$B;37| (|x| |y| $) (DECLARE (IGNORE $)) (<= |x| |y|)) 

(DEFUN |INT;>=;2$B;38| (|x| |y| $) (DECLARE (IGNORE $)) (>= |x| |y|)) 

(DEFUN |INT;-;2$;39| (|x| $) (DECLARE (IGNORE $)) (- |x|)) 

(DEFUN |INT;+;3$;40| (|x| |y| $) (DECLARE (IGNORE $)) (+ |x| |y|)) 

(DEFUN |INT;-;3$;41| (|x| |y| $) (DECLARE (IGNORE $)) (- |x| |y|)) 

(DEFUN |INT;*;3$;42| (|x| |y| $) (DECLARE (IGNORE $)) (* |x| |y|)) 

(DEFUN |INT;*;3$;43| (|m| |y| $) (DECLARE (IGNORE $)) (* |m| |y|)) 

(DEFUN |INT;**;$Nni$;44| (|x| |n| $)
  (DECLARE (IGNORE $))
  (EXPT |x| |n|)) 

(DEFUN |INT;odd?;$B;45| (|x| $) (DECLARE (IGNORE $)) (ODDP |x|)) 

(DEFUN |INT;max;3$;46| (|x| |y| $) (DECLARE (IGNORE $)) (MAX |x| |y|)) 

(DEFUN |INT;min;3$;47| (|x| |y| $) (DECLARE (IGNORE $)) (MIN |x| |y|)) 

(DEFUN |INT;divide;2$R;48| (|x| |y| $)
  (DECLARE (IGNORE $))
  (DIVIDE2 |x| |y|)) 

(DEFUN |INT;quo;3$;49| (|x| |y| $)
  (DECLARE (IGNORE $))
  (QUOTIENT2 |x| |y|)) 

(DEFUN |INT;rem;3$;50| (|x| |y| $)
  (DECLARE (IGNORE $))
  (REMAINDER2 |x| |y|)) 

(DEFUN |INT;shift;3$;51| (|x| |y| $)
  (DECLARE (IGNORE $))
  (ASH |x| |y|)) 

(DEFUN |INT;recip;$U;52| (|x| $)
  (COND
    ((OR (EQL |x| 1) (EQL |x| -1)) (CONS 0 |x|))
    ('T (CONS 1 "failed")))) 

(DEFUN |INT;gcd;3$;53| (|x| |y| $) (DECLARE (IGNORE $)) (GCD |x| |y|)) 

(DEFUN |INT;unitNormal;$R;54| (|x| $)
  (COND ((< |x| 0) (VECTOR -1 (- |x|) -1)) ('T (VECTOR 1 |x| 1)))) 

(DEFUN |INT;unitCanonical;2$;55| (|x| $)
  (DECLARE (IGNORE $))
  (ABS |x|)) 

(DEFUN |INT;solveLinearPolynomialEquation| (|lp| |p| $)
  (SPADCALL |lp| |p| (|getShellEntry| $ 102))) 

(DEFUN |INT;squareFreePolynomial| (|p| $)
  (SPADCALL |p| (|getShellEntry| $ 106))) 

(DEFUN |INT;factorPolynomial| (|p| $)
  (PROG (|pp|)
    (RETURN
      (SEQ (LETT |pp| (SPADCALL |p| (|getShellEntry| $ 107))
                 |INT;factorPolynomial|)
           (EXIT (COND
                   ((EQL (SPADCALL |pp| (|getShellEntry| $ 108))
                         (SPADCALL |p| (|getShellEntry| $ 108)))
                    (SPADCALL |p| (|getShellEntry| $ 110)))
                   ('T
                    (SPADCALL (SPADCALL |pp| (|getShellEntry| $ 110))
                        (SPADCALL (CONS #'|INT;factorPolynomial!0| $)
                            (SPADCALL
                                (LET ((#0=#:G1499
                                       (SPADCALL
                                        (SPADCALL |p|
                                         (|getShellEntry| $ 108))
                                        (SPADCALL |pp|
                                         (|getShellEntry| $ 108))
                                        (|getShellEntry| $ 112))))
                                  (|check-union| (EQL (CAR #0#) 0) $
                                      #0#)
                                  (CDR #0#))
                                (|getShellEntry| $ 114))
                            (|getShellEntry| $ 118))
                        (|getShellEntry| $ 120))))))))) 

(DEFUN |INT;factorPolynomial!0| (|#1| $)
  (SPADCALL |#1| (|getShellEntry| $ 111))) 

(DEFUN |INT;factorSquareFreePolynomial| (|p| $)
  (SPADCALL |p| (|getShellEntry| $ 121))) 

(DEFUN |INT;gcdPolynomial;3Sup;60| (|p| |q| $)
  (COND
    ((SPADCALL |p| (|getShellEntry| $ 122))
     (SPADCALL |q| (|getShellEntry| $ 123)))
    ((SPADCALL |q| (|getShellEntry| $ 122))
     (SPADCALL |p| (|getShellEntry| $ 123)))
    ('T (SPADCALL (LIST |p| |q|) (|getShellEntry| $ 126))))) 

(DEFUN |Integer| ()
  (PROG (#0=#:G1524)
    (RETURN
      (COND
        ((SETQ #0# (HGET |$ConstructorCache| '|Integer|))
         (|CDRwithIncrement| (CDAR #0#)))
        ('T
         (UNWIND-PROTECT
           (PROG1 (CDDAR (HPUT |$ConstructorCache| '|Integer|
                               (LIST (CONS NIL (CONS 1 (|Integer;|))))))
             (SETQ #0# T))
           (COND ((NOT #0#) (HREM |$ConstructorCache| '|Integer|))))))))) 

(DEFUN |Integer;| ()
  (LET ((|dv$| (LIST '|Integer|)) ($ (|newShell| 141))
        (|pv$| (|buildPredVector| 0 0 NIL)))
    (|setShellEntry| $ 0 |dv$|)
    (|setShellEntry| $ 3 |pv$|)
    (|haddProp| |$ConstructorCache| '|Integer| NIL (CONS 1 $))
    (|stuffDomainSlots| $)
    (|setShellEntry| $ 83
        (|setShellEntry| $ 53
            (CONS (|dispatchFunction| |INT;*;3$;43|) $)))
    $)) 

(MAKEPROP '|Integer| '|infovec|
    (LIST '#(NIL NIL NIL NIL NIL NIL
             (CONS IDENTITY
                   (FUNCALL (|dispatchFunction| |INT;Zero;$;8|) $))
             (|NonNegativeInteger|) (0 . |Zero|) (|Boolean|)
             |INT;<;2$B;35| (|Void|) (|OpenMathDevice|)
             (4 . |OMputApp|) (|String|) (9 . |OMputSymbol|)
             |INT;-;2$;39| (|Integer|) (16 . |OMputInteger|)
             (22 . |OMputEndApp|) (|OpenMathEncoding|)
             (27 . |OMencodingXML|) (31 . |OMopenString|)
             (37 . |OMputObject|) (42 . |OMputEndObject|)
             (47 . |OMclose|) |INT;OMwrite;$S;2| |INT;OMwrite;$BS;3|
             |INT;OMwrite;Omd$V;4| |INT;OMwrite;Omd$BV;5|
             |INT;zero?;$B;6|
             (CONS IDENTITY
                   (FUNCALL (|dispatchFunction| |INT;One;$;9|) $))
             (52 . |One|) |INT;=;2$B;34| |INT;one?;$B;7|
             |INT;base;$;10| |INT;copy;2$;11| |INT;+;3$;40|
             |INT;inc;2$;12| |INT;-;3$;41| |INT;dec;2$;13|
             (|SingleInteger|) |INT;hash;$Si;14| |INT;negative?;$B;15|
             (|OutputForm|) (56 . |outputForm|) |INT;coerce;$Of;16|
             |INT;coerce;2$;17| |INT;convert;2$;18| |INT;length;2$;19|
             |INT;>=;2$B;38| |INT;addmod;4$;20| |INT;submod;4$;21| NIL
             |INT;rem;3$;50| |INT;mulmod;4$;22| (|Float|)
             (61 . |coerce|) |INT;convert;$F;23| (|DoubleFloat|)
             (66 . |coerce|) |INT;convert;$Df;24| (|InputForm|)
             (71 . |convert|) |INT;convert;$If;25| (76 . |string|)
             |INT;convert;$S;26| (81 . <) (87 . |concat|)
             |INT;latex;$S;27| |INT;positiveRemainder;3$;28|
             (|Matrix| 17) (|Matrix| $) |INT;reducedSystem;2M;29|
             (|Vector| 17) (|Record| (|:| |mat| 71) (|:| |vec| 74))
             (|Vector| $) |INT;reducedSystem;MVR;30| |INT;abs;2$;31|
             |INT;random;$;32| |INT;random;2$;33| |INT;>;2$B;36|
             |INT;<=;2$B;37| NIL |INT;**;$Nni$;44| |INT;odd?;$B;45|
             |INT;max;3$;46| |INT;min;3$;47|
             (|Record| (|:| |quotient| $) (|:| |remainder| $))
             |INT;divide;2$R;48| |INT;quo;3$;49| |INT;shift;3$;51|
             (|Union| $ '"failed") |INT;recip;$U;52| |INT;gcd;3$;53|
             (|Record| (|:| |unit| $) (|:| |canonical| $)
                 (|:| |associate| $))
             |INT;unitNormal;$R;54| |INT;unitCanonical;2$;55|
             (|SparseUnivariatePolynomial| 17) (|List| 98)
             (|Union| 99 '"failed")
             (|IntegerSolveLinearPolynomialEquation|)
             (93 . |solveLinearPolynomialEquation|)
             (|SparseUnivariatePolynomial| $$) (|Factored| 103)
             (|UnivariatePolynomialSquareFree| $$ 103)
             (99 . |squareFree|) (104 . |primitivePart|)
             (109 . |leadingCoefficient|) (|GaloisGroupFactorizer| 103)
             (114 . |factor|) (119 . |coerce|) (124 . |exquo|)
             (|Factored| $) (130 . |factor|) (|Mapping| 103 $$)
             (|Factored| $$) (|FactoredFunctions2| $$ 103)
             (135 . |map|) (|FactoredFunctionUtilities| 103)
             (141 . |mergeFactors|) (147 . |factorSquareFree|)
             (152 . |zero?|) (157 . |unitCanonical|) (|List| 103)
             (|HeuGcd| 103) (162 . |gcd|)
             (|SparseUnivariatePolynomial| $)
             |INT;gcdPolynomial;3Sup;60| (|Fraction| 17)
             (|Union| 129 '"failed") (|Pattern| 17)
             (|PatternMatchResult| 17 $) (|Union| 17 '"failed")
             (|List| $) (|Record| (|:| |coef| 134) (|:| |generator| $))
             (|Union| 134 '"failed")
             (|Record| (|:| |coef1| $) (|:| |coef2| $)
                 (|:| |generator| $))
             (|Record| (|:| |coef1| $) (|:| |coef2| $))
             (|Union| 138 '"failed") (|PositiveInteger|))
          '#(~= 167 |zero?| 173 |unitNormal| 178 |unitCanonical| 183
             |unit?| 188 |symmetricRemainder| 193 |subtractIfCan| 199
             |submod| 205 |squareFreePart| 212 |squareFree| 217
             |sizeLess?| 222 |sign| 228 |shift| 233 |sample| 239
             |retractIfCan| 243 |retract| 248 |rem| 253 |reducedSystem|
             259 |recip| 275 |rationalIfCan| 280 |rational?| 285
             |rational| 290 |random| 295 |quo| 304 |principalIdeal| 310
             |prime?| 315 |powmod| 320 |positiveRemainder| 327
             |positive?| 333 |permutation| 338 |patternMatch| 344
             |one?| 351 |odd?| 356 |nextItem| 361 |negative?| 366
             |multiEuclidean| 371 |mulmod| 377 |min| 384 |max| 390
             |mask| 396 |length| 401 |lcm| 406 |latex| 417 |invmod| 422
             |init| 428 |inc| 432 |hash| 437 |gcdPolynomial| 442 |gcd|
             448 |factorial| 459 |factor| 464 |extendedEuclidean| 469
             |exquo| 482 |expressIdealMember| 488 |even?| 494
             |euclideanSize| 499 |divide| 504 |differentiate| 510 |dec|
             521 |copy| 526 |convert| 531 |coerce| 561 |characteristic|
             581 |bit?| 585 |binomial| 591 |before?| 597 |base| 603
             |associates?| 607 |addmod| 613 |abs| 620 |Zero| 625 |One|
             629 |OMwrite| 633 D 657 >= 668 > 674 = 680 <= 686 < 692 -
             698 + 709 ** 715 * 727)
          '((|infinite| . 0) (|noetherian| . 0)
            (|canonicalsClosed| . 0) (|canonical| . 0)
            (|canonicalUnitNormal| . 0) (|multiplicativeValuation| . 0)
            (|noZeroDivisors| . 0) ((|commutative| "*") . 0)
            (|rightUnitary| . 0) (|leftUnitary| . 0)
            (|unitsKnown| . 0))
          (CONS (|makeByteWordVec2| 1
                    '(0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                      0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                      0 0 0 0 0 0))
                (CONS '#(|IntegerNumberSystem&| |EuclideanDomain&|
                         |UniqueFactorizationDomain&| NIL NIL
                         |GcdDomain&| |IntegralDomain&| |Algebra&| NIL
                         NIL |OrderedRing&| NIL NIL |Module&| NIL NIL
                         |Ring&| NIL NIL NIL NIL NIL NIL
                         |AbelianGroup&| NIL NIL NIL NIL
                         |AbelianMonoid&| |Monoid&| NIL NIL
                         |DifferentialSpace&| |OrderedSet&| NIL NIL
                         |AbelianSemiGroup&| |SemiGroup&| NIL NIL
                         |RetractableTo&| |DifferentialDomain&|
                         |SetCategory&| NIL NIL NIL NIL NIL NIL NIL NIL
                         NIL NIL NIL |BasicType&| NIL)
                      (CONS '#((|IntegerNumberSystem|)
                               (|EuclideanDomain|)
                               (|UniqueFactorizationDomain|)
                               (|PrincipalIdealDomain|)
                               (|OrderedIntegralDomain|) (|GcdDomain|)
                               (|IntegralDomain|) (|Algebra| $$)
                               (|CharacteristicZero|)
                               (|DifferentialRing|) (|OrderedRing|)
                               (|CommutativeRing|) (|EntireRing|)
                               (|Module| $$)
                               (|LinearlyExplicitRingOver| 17)
                               (|BiModule| $$ $$) (|Ring|)
                               (|LeftModule| 17)
                               (|OrderedAbelianGroup|)
                               (|LeftModule| $$) (|Rng|)
                               (|RightModule| $$)
                               (|OrderedCancellationAbelianMonoid|)
                               (|AbelianGroup|)
                               (|OrderedAbelianMonoid|)
                               (|CancellationAbelianMonoid|)
                               (|OrderedAbelianSemiGroup|)
                               (|LinearSet| $$) (|AbelianMonoid|)
                               (|Monoid|) (|StepThrough|)
                               (|PatternMatchable| 17)
                               (|DifferentialSpace|) (|OrderedSet|)
                               (|LeftLinearSet| $$)
                               (|RightLinearSet| $$)
                               (|AbelianSemiGroup|) (|SemiGroup|)
                               (|LeftLinearSet| 17) (|RealConstant|)
                               (|RetractableTo| 17)
                               (|DifferentialDomain| $$)
                               (|SetCategory|) (|OpenMath|)
                               (|ConvertibleTo| 14)
                               (|ConvertibleTo| 56)
                               (|ConvertibleTo| 59)
                               (|CombinatorialFunctionCategory|)
                               (|ConvertibleTo| 131)
                               (|ConvertibleTo| 62)
                               (|ConvertibleTo| 17) (|Type|)
                               (|CoercibleFrom| $$)
                               (|CoercibleFrom| 17) (|BasicType|)
                               (|CoercibleTo| 44))
                            (|makeByteWordVec2| 140
                                '(0 7 0 8 1 12 11 0 13 3 12 11 0 14 14
                                  15 2 12 11 0 17 18 1 12 11 0 19 0 20
                                  0 21 2 12 0 14 20 22 1 12 11 0 23 1
                                  12 11 0 24 1 12 11 0 25 0 7 0 32 1 44
                                  0 17 45 1 56 0 17 57 1 59 0 17 60 1
                                  62 0 17 63 1 14 0 17 65 2 17 9 0 0 67
                                  2 14 0 0 0 68 2 101 100 99 98 102 1
                                  105 104 103 106 1 103 0 0 107 1 103 2
                                  0 108 1 109 104 103 110 1 103 0 2 111
                                  2 0 92 0 0 112 1 0 113 0 114 2 117
                                  104 115 116 118 2 119 104 104 104 120
                                  1 109 104 103 121 1 103 9 0 122 1 103
                                  0 0 123 1 125 103 124 126 2 0 9 0 0 1
                                  1 0 9 0 30 1 0 95 0 96 1 0 0 0 97 1 0
                                  9 0 1 2 0 0 0 0 1 2 0 92 0 0 1 3 0 0
                                  0 0 0 52 1 0 0 0 1 1 0 113 0 1 2 0 9
                                  0 0 1 1 0 17 0 1 2 0 0 0 0 91 0 0 0 1
                                  1 0 133 0 1 1 0 17 0 1 2 0 0 0 0 54 1
                                  0 71 72 73 1 0 71 76 1 2 0 75 72 76
                                  77 1 0 92 0 93 1 0 130 0 1 1 0 9 0 1
                                  1 0 129 0 1 0 0 0 79 1 0 0 0 80 2 0 0
                                  0 0 90 1 0 135 134 1 1 0 9 0 1 3 0 0
                                  0 0 0 1 2 0 0 0 0 70 1 0 9 0 1 2 0 0
                                  0 0 1 3 0 132 0 131 132 1 1 0 9 0 34
                                  1 0 9 0 85 1 0 92 0 1 1 0 9 0 43 2 0
                                  136 134 0 1 3 0 0 0 0 0 55 2 0 0 0 0
                                  87 2 0 0 0 0 86 1 0 0 0 1 1 0 0 0 49
                                  1 0 0 134 1 2 0 0 0 0 1 1 0 14 0 69 2
                                  0 0 0 0 1 0 0 0 1 1 0 0 0 38 1 0 41 0
                                  42 2 0 127 127 127 128 1 0 0 134 1 2
                                  0 0 0 0 94 1 0 0 0 1 1 0 113 0 114 2
                                  0 137 0 0 1 3 0 139 0 0 0 1 2 0 92 0
                                  0 112 2 0 136 134 0 1 1 0 9 0 1 1 0 7
                                  0 1 2 0 88 0 0 89 2 0 0 0 7 1 1 0 0 0
                                  1 1 0 0 0 40 1 0 0 0 36 1 0 14 0 66 1
                                  0 59 0 61 1 0 56 0 58 1 0 131 0 1 1 0
                                  62 0 64 1 0 17 0 48 1 0 0 17 47 1 0 0
                                  0 1 1 0 0 17 47 1 0 44 0 46 0 0 7 1 2
                                  0 9 0 0 1 2 0 0 0 0 1 2 0 9 0 0 1 0 0
                                  0 35 2 0 9 0 0 1 3 0 0 0 0 0 51 1 0 0
                                  0 78 0 0 0 6 0 0 0 31 3 0 11 12 0 9
                                  29 2 0 14 0 9 27 2 0 11 12 0 28 1 0
                                  14 0 26 2 0 0 0 7 1 1 0 0 0 1 2 0 9 0
                                  0 50 2 0 9 0 0 81 2 0 9 0 0 33 2 0 9
                                  0 0 82 2 0 9 0 0 10 1 0 0 0 16 2 0 0
                                  0 0 39 2 0 0 0 0 37 2 0 0 0 7 84 2 0
                                  0 0 140 1 2 0 0 17 0 83 2 0 0 0 0 53
                                  2 0 0 17 0 83 2 0 0 7 0 1 2 0 0 140 0
                                  1)))))
          '|lookupComplete|)) 

(MAKEPROP '|Integer| 'NILADIC T) 
