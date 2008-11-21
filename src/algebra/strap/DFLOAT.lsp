
(/VERSIONCHECK 2) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%String|)
                |DFLOAT;OMwrite;$S;1|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Boolean| |%Shell|)
                    |%String|)
                |DFLOAT;OMwrite;$BS;2|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%DoubleFloat| |%Shell|) |%Void|)
                |DFLOAT;OMwrite;Omd$V;3|)) 

(DECLAIM (FTYPE (FUNCTION (|%Thing| |%DoubleFloat| |%Boolean| |%Shell|)
                    |%Void|)
                |DFLOAT;OMwrite;Omd$BV;4|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;checkComplex|)) 

(PUT '|DFLOAT;checkComplex| '|SPADreplace| 'C-TO-R) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) (|%IntegerSection| 1))
                |DFLOAT;base;Pi;6|)) 

(PUT '|DFLOAT;base;Pi;6| '|SPADreplace| '(XLAM NIL (FLOAT-RADIX 0.0))) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Integer|)
                |DFLOAT;mantissa;$I;7|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Integer|)
                |DFLOAT;exponent;$I;8|)) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) (|%IntegerSection| 1))
                |DFLOAT;precision;Pi;9|)) 

(PUT '|DFLOAT;precision;Pi;9| '|SPADreplace|
     '(XLAM NIL (FLOAT-DIGITS 0.0))) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) (|%IntegerSection| 1))
                |DFLOAT;bits;Pi;10|)) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%DoubleFloat|) |DFLOAT;max;$;11|)) 

(PUT '|DFLOAT;max;$;11| '|SPADreplace|
     '(XLAM NIL |$DoubleFloatMaximum|)) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%DoubleFloat|) |DFLOAT;min;$;12|)) 

(PUT '|DFLOAT;min;$;12| '|SPADreplace|
     '(XLAM NIL |$DoubleFloatMinimum|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Integer|)
                |DFLOAT;order;$I;13|)) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%DoubleFloat|)
                |DFLOAT;Zero;$;14|)) 

(PUT '|DFLOAT;Zero;$;14| '|SPADreplace|
     '(XLAM NIL (FLOAT 0 |$DoubleFloatMaximum|))) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%DoubleFloat|) |DFLOAT;One;$;15|)) 

(PUT '|DFLOAT;One;$;15| '|SPADreplace|
     '(XLAM NIL (FLOAT 1 |$DoubleFloatMaximum|))) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%DoubleFloat|)
                |DFLOAT;exp1;$;16|)) 

(DECLAIM (FTYPE (FUNCTION (|%Shell|) |%DoubleFloat|) |DFLOAT;pi;$;17|)) 

(PUT '|DFLOAT;pi;$;17| '|SPADreplace| '(XLAM NIL PI)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Thing|)
                |DFLOAT;coerce;$Of;18|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Thing|)
                |DFLOAT;convert;$If;19|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%Boolean|)
                |DFLOAT;<;2$B;20|)) 

(PUT '|DFLOAT;<;2$B;20| '|SPADreplace| '<) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;-;2$;21|)) 

(PUT '|DFLOAT;-;2$;21| '|SPADreplace| '-) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;+;3$;22|)) 

(PUT '|DFLOAT;+;3$;22| '|SPADreplace| '+) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;-;3$;23|)) 

(PUT '|DFLOAT;-;3$;23| '|SPADreplace| '-) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;*;3$;24|)) 

(PUT '|DFLOAT;*;3$;24| '|SPADreplace| '*) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;*;I2$;25|)) 

(PUT '|DFLOAT;*;I2$;25| '|SPADreplace| '*) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;max;3$;26|)) 

(PUT '|DFLOAT;max;3$;26| '|SPADreplace| 'MAX) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;min;3$;27|)) 

(PUT '|DFLOAT;min;3$;27| '|SPADreplace| 'MIN) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%Boolean|)
                |DFLOAT;=;2$B;28|)) 

(PUT '|DFLOAT;=;2$B;28| '|SPADreplace| '=) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Integer| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;/;$I$;29|)) 

(PUT '|DFLOAT;/;$I$;29| '|SPADreplace| '/) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;sqrt;2$;30|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;log10;2$;31|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Integer| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;**;$I$;32|)) 

(PUT '|DFLOAT;**;$I$;32| '|SPADreplace| 'EXPT) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;**;3$;33|)) 

(DECLAIM (FTYPE (FUNCTION (|%Integer| |%Shell|) |%DoubleFloat|)
                |DFLOAT;coerce;I$;34|)) 

(PUT '|DFLOAT;coerce;I$;34| '|SPADreplace|
     '(XLAM (|i|) (FLOAT |i| |$DoubleFloatMaximum|))) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;exp;2$;35|)) 

(PUT '|DFLOAT;exp;2$;35| '|SPADreplace| 'EXP) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;log;2$;36|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;log2;2$;37|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;sin;2$;38|)) 

(PUT '|DFLOAT;sin;2$;38| '|SPADreplace| 'SIN) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;cos;2$;39|)) 

(PUT '|DFLOAT;cos;2$;39| '|SPADreplace| 'COS) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;tan;2$;40|)) 

(PUT '|DFLOAT;tan;2$;40| '|SPADreplace| 'TAN) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;cot;2$;41|)) 

(PUT '|DFLOAT;cot;2$;41| '|SPADreplace| 'COT) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;sec;2$;42|)) 

(PUT '|DFLOAT;sec;2$;42| '|SPADreplace| 'SEC) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;csc;2$;43|)) 

(PUT '|DFLOAT;csc;2$;43| '|SPADreplace| 'CSC) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;asin;2$;44|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;acos;2$;45|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;atan;2$;46|)) 

(PUT '|DFLOAT;atan;2$;46| '|SPADreplace| 'ATAN) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;acsc;2$;47|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;acot;2$;48|)) 

(PUT '|DFLOAT;acot;2$;48| '|SPADreplace| 'ACOT) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;asec;2$;49|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;sinh;2$;50|)) 

(PUT '|DFLOAT;sinh;2$;50| '|SPADreplace| 'SINH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;cosh;2$;51|)) 

(PUT '|DFLOAT;cosh;2$;51| '|SPADreplace| 'COSH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;tanh;2$;52|)) 

(PUT '|DFLOAT;tanh;2$;52| '|SPADreplace| 'TANH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;csch;2$;53|)) 

(PUT '|DFLOAT;csch;2$;53| '|SPADreplace| 'CSCH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;coth;2$;54|)) 

(PUT '|DFLOAT;coth;2$;54| '|SPADreplace| 'COTH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;sech;2$;55|)) 

(PUT '|DFLOAT;sech;2$;55| '|SPADreplace| 'SECH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;asinh;2$;56|)) 

(PUT '|DFLOAT;asinh;2$;56| '|SPADreplace| 'ASINH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;acosh;2$;57|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;atanh;2$;58|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;acsch;2$;59|)) 

(PUT '|DFLOAT;acsch;2$;59| '|SPADreplace| 'ACSCH) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;acoth;2$;60|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;asech;2$;61|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;/;3$;62|)) 

(PUT '|DFLOAT;/;3$;62| '|SPADreplace| '/) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Boolean|)
                |DFLOAT;negative?;$B;63|)) 

(PUT '|DFLOAT;negative?;$B;63| '|SPADreplace| 'MINUSP) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Boolean|)
                |DFLOAT;zero?;$B;64|)) 

(PUT '|DFLOAT;zero?;$B;64| '|SPADreplace| 'ZEROP) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Short|)
                |DFLOAT;hash;$Si;65|)) 

(PUT '|DFLOAT;hash;$Si;65| '|SPADreplace| 'HASHEQ) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Pair|)
                |DFLOAT;recip;$U;66|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;differentiate;2$;67|)) 

(PUT '|DFLOAT;differentiate;2$;67| '|SPADreplace| '(XLAM (|x|) 0.0)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;Gamma;2$;68|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;Beta;3$;69|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Integer|)
                |DFLOAT;wholePart;$I;70|)) 

(PUT '|DFLOAT;wholePart;$I;70| '|SPADreplace| 'FIX) 

(DECLAIM (FTYPE (FUNCTION
                    (|%Integer| |%Integer| (|%IntegerSection| 1)
                        |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;float;2IPi$;71|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;convert;2$;72|)) 

(PUT '|DFLOAT;convert;2$;72| '|SPADreplace| '(XLAM (|x|) |x|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Thing|)
                |DFLOAT;convert;$F;73|)) 

(DECLAIM (FTYPE (FUNCTION
                    (|%DoubleFloat| (|%IntegerSection| 0) |%Shell|)
                    |%Thing|)
                |DFLOAT;rationalApproximation;$NniF;74|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%DoubleFloat| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;atan;3$;75|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Thing|)
                |DFLOAT;retract;$F;76|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Pair|)
                |DFLOAT;retractIfCan;$U;77|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Integer|)
                |DFLOAT;retract;$I;78|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Pair|)
                |DFLOAT;retractIfCan;$U;79|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Integer|)
                |DFLOAT;sign;$I;80|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%DoubleFloat|)
                |DFLOAT;abs;2$;81|)) 

(PUT '|DFLOAT;abs;2$;81| '|SPADreplace|
     '(XLAM (|x|) (FLOAT-SIGN 1.0 |x|))) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Shell|) |%Pair|)
                |DFLOAT;manexp|)) 

(DECLAIM (FTYPE (FUNCTION
                    (|%DoubleFloat| (|%IntegerSection| 0)
                        (|%IntegerSection| 0) |%Shell|)
                    |%Thing|)
                |DFLOAT;rationalApproximation;$2NniF;83|)) 

(DECLAIM (FTYPE (FUNCTION (|%DoubleFloat| |%Thing| |%Shell|)
                    |%DoubleFloat|)
                |DFLOAT;**;$F$;84|)) 

(DEFUN |DFLOAT;OMwrite;$S;1| (|x| $)
  (PROG (|sp| |dev| |s|)
    (RETURN
      (SEQ (LETT |s| "" |DFLOAT;OMwrite;$S;1|)
           (LETT |sp| (OM-STRINGTOSTRINGPTR |s|) |DFLOAT;OMwrite;$S;1|)
           (LETT |dev|
                 (SPADCALL |sp| (SPADCALL (|getShellEntry| $ 7))
                     (|getShellEntry| $ 10))
                 |DFLOAT;OMwrite;$S;1|)
           (SPADCALL |dev| (|getShellEntry| $ 12))
           (SPADCALL |dev| |x| (|getShellEntry| $ 14))
           (SPADCALL |dev| (|getShellEntry| $ 15))
           (SPADCALL |dev| (|getShellEntry| $ 16))
           (LETT |s| (OM-STRINGPTRTOSTRING |sp|) |DFLOAT;OMwrite;$S;1|)
           (EXIT |s|))))) 

(DEFUN |DFLOAT;OMwrite;$BS;2| (|x| |wholeObj| $)
  (PROG (|sp| |dev| |s|)
    (RETURN
      (SEQ (LETT |s| "" |DFLOAT;OMwrite;$BS;2|)
           (LETT |sp| (OM-STRINGTOSTRINGPTR |s|)
                 |DFLOAT;OMwrite;$BS;2|)
           (LETT |dev|
                 (SPADCALL |sp| (SPADCALL (|getShellEntry| $ 7))
                     (|getShellEntry| $ 10))
                 |DFLOAT;OMwrite;$BS;2|)
           (COND (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 12))))
           (SPADCALL |dev| |x| (|getShellEntry| $ 14))
           (COND (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 15))))
           (SPADCALL |dev| (|getShellEntry| $ 16))
           (LETT |s| (OM-STRINGPTRTOSTRING |sp|)
                 |DFLOAT;OMwrite;$BS;2|)
           (EXIT |s|))))) 

(DEFUN |DFLOAT;OMwrite;Omd$V;3| (|dev| |x| $)
  (SEQ (SPADCALL |dev| (|getShellEntry| $ 12))
       (SPADCALL |dev| |x| (|getShellEntry| $ 14))
       (EXIT (SPADCALL |dev| (|getShellEntry| $ 15))))) 

(DEFUN |DFLOAT;OMwrite;Omd$BV;4| (|dev| |x| |wholeObj| $)
  (SEQ (COND (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 12))))
       (SPADCALL |dev| |x| (|getShellEntry| $ 14))
       (EXIT (COND
               (|wholeObj| (SPADCALL |dev| (|getShellEntry| $ 15))))))) 

(DEFUN |DFLOAT;checkComplex| (|x| $)
  (DECLARE (IGNORE $))
  (C-TO-R |x|)) 

(DEFUN |DFLOAT;base;Pi;6| ($) (DECLARE (IGNORE $)) (FLOAT-RADIX 0.0)) 

(DEFUN |DFLOAT;mantissa;$I;7| (|x| $) (QCAR (|DFLOAT;manexp| |x| $))) 

(DEFUN |DFLOAT;exponent;$I;8| (|x| $) (QCDR (|DFLOAT;manexp| |x| $))) 

(DEFUN |DFLOAT;precision;Pi;9| ($)
  (DECLARE (IGNORE $))
  (FLOAT-DIGITS 0.0)) 

(DEFUN |DFLOAT;bits;Pi;10| ($)
  (PROG (#0=#:G1422)
    (RETURN
      (COND
        ((EQL (FLOAT-RADIX 0.0) 2) (FLOAT-DIGITS 0.0))
        ((EQL (FLOAT-RADIX 0.0) 16) (* 4 (FLOAT-DIGITS 0.0)))
        ('T
         (PROG1 (LETT #0#
                      (FIX (SPADCALL (FLOAT-DIGITS 0.0)
                               (|DFLOAT;log2;2$;37|
                                   (FLOAT (FLOAT-RADIX 0.0)
                                    |$DoubleFloatMaximum|)
                                   $)
                               (|getShellEntry| $ 29)))
                      |DFLOAT;bits;Pi;10|)
           (|check-subtype| (> #0# 0) '(|PositiveInteger|) #0#))))))) 

(DEFUN |DFLOAT;max;$;11| ($)
  (DECLARE (IGNORE $))
  |$DoubleFloatMaximum|) 

(DEFUN |DFLOAT;min;$;12| ($)
  (DECLARE (IGNORE $))
  |$DoubleFloatMinimum|) 

(DEFUN |DFLOAT;order;$I;13| (|a| $)
  (- (+ (FLOAT-DIGITS 0.0) (|DFLOAT;exponent;$I;8| |a| $)) 1)) 

(DEFUN |DFLOAT;Zero;$;14| ($)
  (DECLARE (IGNORE $))
  (FLOAT 0 |$DoubleFloatMaximum|)) 

(DEFUN |DFLOAT;One;$;15| ($)
  (DECLARE (IGNORE $))
  (FLOAT 1 |$DoubleFloatMaximum|)) 

(DEFUN |DFLOAT;exp1;$;16| ($)
  (/ (FLOAT 534625820200 |$DoubleFloatMaximum|)
     (FLOAT 196677847971 |$DoubleFloatMaximum|))) 

(DEFUN |DFLOAT;pi;$;17| ($) (DECLARE (IGNORE $)) PI) 

(DEFUN |DFLOAT;coerce;$Of;18| (|x| $)
  (SPADCALL |x| (|getShellEntry| $ 39))) 

(DEFUN |DFLOAT;convert;$If;19| (|x| $)
  (SPADCALL |x| (|getShellEntry| $ 42))) 

(DEFUN |DFLOAT;<;2$B;20| (|x| |y| $) (DECLARE (IGNORE $)) (< |x| |y|)) 

(DEFUN |DFLOAT;-;2$;21| (|x| $) (DECLARE (IGNORE $)) (- |x|)) 

(DEFUN |DFLOAT;+;3$;22| (|x| |y| $) (DECLARE (IGNORE $)) (+ |x| |y|)) 

(DEFUN |DFLOAT;-;3$;23| (|x| |y| $) (DECLARE (IGNORE $)) (- |x| |y|)) 

(DEFUN |DFLOAT;*;3$;24| (|x| |y| $) (DECLARE (IGNORE $)) (* |x| |y|)) 

(DEFUN |DFLOAT;*;I2$;25| (|i| |x| $) (DECLARE (IGNORE $)) (* |i| |x|)) 

(DEFUN |DFLOAT;max;3$;26| (|x| |y| $)
  (DECLARE (IGNORE $))
  (MAX |x| |y|)) 

(DEFUN |DFLOAT;min;3$;27| (|x| |y| $)
  (DECLARE (IGNORE $))
  (MIN |x| |y|)) 

(DEFUN |DFLOAT;=;2$B;28| (|x| |y| $) (DECLARE (IGNORE $)) (= |x| |y|)) 

(DEFUN |DFLOAT;/;$I$;29| (|x| |i| $) (DECLARE (IGNORE $)) (/ |x| |i|)) 

(DEFUN |DFLOAT;sqrt;2$;30| (|x| $) (C-TO-R (SQRT |x|))) 

(DEFUN |DFLOAT;log10;2$;31| (|x| $) (C-TO-R (|log| |x|))) 

(DEFUN |DFLOAT;**;$I$;32| (|x| |i| $)
  (DECLARE (IGNORE $))
  (EXPT |x| |i|)) 

(DEFUN |DFLOAT;**;3$;33| (|x| |y| $) (C-TO-R (EXPT |x| |y|))) 

(DEFUN |DFLOAT;coerce;I$;34| (|i| $)
  (DECLARE (IGNORE $))
  (FLOAT |i| |$DoubleFloatMaximum|)) 

(DEFUN |DFLOAT;exp;2$;35| (|x| $) (DECLARE (IGNORE $)) (EXP |x|)) 

(DEFUN |DFLOAT;log;2$;36| (|x| $) (C-TO-R (LN |x|))) 

(DEFUN |DFLOAT;log2;2$;37| (|x| $) (C-TO-R (LOG2 |x|))) 

(DEFUN |DFLOAT;sin;2$;38| (|x| $) (DECLARE (IGNORE $)) (SIN |x|)) 

(DEFUN |DFLOAT;cos;2$;39| (|x| $) (DECLARE (IGNORE $)) (COS |x|)) 

(DEFUN |DFLOAT;tan;2$;40| (|x| $) (DECLARE (IGNORE $)) (TAN |x|)) 

(DEFUN |DFLOAT;cot;2$;41| (|x| $) (DECLARE (IGNORE $)) (COT |x|)) 

(DEFUN |DFLOAT;sec;2$;42| (|x| $) (DECLARE (IGNORE $)) (SEC |x|)) 

(DEFUN |DFLOAT;csc;2$;43| (|x| $) (DECLARE (IGNORE $)) (CSC |x|)) 

(DEFUN |DFLOAT;asin;2$;44| (|x| $) (C-TO-R (ASIN |x|))) 

(DEFUN |DFLOAT;acos;2$;45| (|x| $) (C-TO-R (ACOS |x|))) 

(DEFUN |DFLOAT;atan;2$;46| (|x| $) (DECLARE (IGNORE $)) (ATAN |x|)) 

(DEFUN |DFLOAT;acsc;2$;47| (|x| $) (C-TO-R (ACSC |x|))) 

(DEFUN |DFLOAT;acot;2$;48| (|x| $) (DECLARE (IGNORE $)) (ACOT |x|)) 

(DEFUN |DFLOAT;asec;2$;49| (|x| $) (C-TO-R (ASEC |x|))) 

(DEFUN |DFLOAT;sinh;2$;50| (|x| $) (DECLARE (IGNORE $)) (SINH |x|)) 

(DEFUN |DFLOAT;cosh;2$;51| (|x| $) (DECLARE (IGNORE $)) (COSH |x|)) 

(DEFUN |DFLOAT;tanh;2$;52| (|x| $) (DECLARE (IGNORE $)) (TANH |x|)) 

(DEFUN |DFLOAT;csch;2$;53| (|x| $) (DECLARE (IGNORE $)) (CSCH |x|)) 

(DEFUN |DFLOAT;coth;2$;54| (|x| $) (DECLARE (IGNORE $)) (COTH |x|)) 

(DEFUN |DFLOAT;sech;2$;55| (|x| $) (DECLARE (IGNORE $)) (SECH |x|)) 

(DEFUN |DFLOAT;asinh;2$;56| (|x| $) (DECLARE (IGNORE $)) (ASINH |x|)) 

(DEFUN |DFLOAT;acosh;2$;57| (|x| $) (C-TO-R (ACOSH |x|))) 

(DEFUN |DFLOAT;atanh;2$;58| (|x| $) (C-TO-R (ATANH |x|))) 

(DEFUN |DFLOAT;acsch;2$;59| (|x| $) (DECLARE (IGNORE $)) (ACSCH |x|)) 

(DEFUN |DFLOAT;acoth;2$;60| (|x| $) (C-TO-R (ACOTH |x|))) 

(DEFUN |DFLOAT;asech;2$;61| (|x| $) (C-TO-R (ASECH |x|))) 

(DEFUN |DFLOAT;/;3$;62| (|x| |y| $) (DECLARE (IGNORE $)) (/ |x| |y|)) 

(DEFUN |DFLOAT;negative?;$B;63| (|x| $)
  (DECLARE (IGNORE $))
  (MINUSP |x|)) 

(DEFUN |DFLOAT;zero?;$B;64| (|x| $) (DECLARE (IGNORE $)) (ZEROP |x|)) 

(DEFUN |DFLOAT;hash;$Si;65| (|x| $) (DECLARE (IGNORE $)) (HASHEQ |x|)) 

(DEFUN |DFLOAT;recip;$U;66| (|x| $)
  (COND ((ZEROP |x|) (CONS 1 "failed")) ('T (CONS 0 (/ 1.0 |x|))))) 

(DEFUN |DFLOAT;differentiate;2$;67| (|x| $) (DECLARE (IGNORE $)) 0.0) 

(DEFUN |DFLOAT;Gamma;2$;68| (|x| $)
  (SPADCALL |x| (|getShellEntry| $ 94))) 

(DEFUN |DFLOAT;Beta;3$;69| (|x| |y| $)
  (SPADCALL |x| |y| (|getShellEntry| $ 96))) 

(DEFUN |DFLOAT;wholePart;$I;70| (|x| $)
  (DECLARE (IGNORE $))
  (FIX |x|)) 

(DEFUN |DFLOAT;float;2IPi$;71| (|ma| |ex| |b| $)
  (* |ma| (EXPT (FLOAT |b| |$DoubleFloatMaximum|) |ex|))) 

(DEFUN |DFLOAT;convert;2$;72| (|x| $) (DECLARE (IGNORE $)) |x|) 

(DEFUN |DFLOAT;convert;$F;73| (|x| $)
  (SPADCALL |x| (|getShellEntry| $ 102))) 

(DEFUN |DFLOAT;rationalApproximation;$NniF;74| (|x| |d| $)
  (|DFLOAT;rationalApproximation;$2NniF;83| |x| |d| 10 $)) 

(DEFUN |DFLOAT;atan;3$;75| (|x| |y| $)
  (PROG (|theta|)
    (RETURN
      (SEQ (COND
             ((= |x| 0.0)
              (COND
                ((< 0.0 |y|) (/ PI 2))
                ((< |y| 0.0) (- (/ PI 2)))
                ('T 0.0)))
             ('T
              (SEQ (LETT |theta| (ATAN (FLOAT-SIGN 1.0 (/ |y| |x|)))
                         |DFLOAT;atan;3$;75|)
                   (COND
                     ((< |x| 0.0)
                      (LETT |theta| (- PI |theta|) |DFLOAT;atan;3$;75|)))
                   (COND
                     ((< |y| 0.0)
                      (LETT |theta| (- |theta|) |DFLOAT;atan;3$;75|)))
                   (EXIT |theta|)))))))) 

(DEFUN |DFLOAT;retract;$F;76| (|x| $)
  (PROG (#0=#:G1497)
    (RETURN
      (|DFLOAT;rationalApproximation;$2NniF;83| |x|
          (PROG1 (LETT #0# (- (FLOAT-DIGITS 0.0) 1)
                       |DFLOAT;retract;$F;76|)
            (|check-subtype| (>= #0# 0) '(|NonNegativeInteger|) #0#))
          (FLOAT-RADIX 0.0) $)))) 

(DEFUN |DFLOAT;retractIfCan;$U;77| (|x| $)
  (PROG (#0=#:G1502)
    (RETURN
      (CONS 0
            (|DFLOAT;rationalApproximation;$2NniF;83| |x|
                (PROG1 (LETT #0# (- (FLOAT-DIGITS 0.0) 1)
                             |DFLOAT;retractIfCan;$U;77|)
                  (|check-subtype| (>= #0# 0) '(|NonNegativeInteger|)
                      #0#))
                (FLOAT-RADIX 0.0) $))))) 

(DEFUN |DFLOAT;retract;$I;78| (|x| $)
  (PROG (|n|)
    (RETURN
      (SEQ (LETT |n| (FIX |x|) |DFLOAT;retract;$I;78|)
           (EXIT (COND
                   ((= |x| (FLOAT |n| |$DoubleFloatMaximum|)) |n|)
                   ('T (|error| "Not an integer")))))))) 

(DEFUN |DFLOAT;retractIfCan;$U;79| (|x| $)
  (PROG (|n|)
    (RETURN
      (SEQ (LETT |n| (FIX |x|) |DFLOAT;retractIfCan;$U;79|)
           (EXIT (COND
                   ((= |x| (FLOAT |n| |$DoubleFloatMaximum|))
                    (CONS 0 |n|))
                   ('T (CONS 1 "failed")))))))) 

(DEFUN |DFLOAT;sign;$I;80| (|x| $)
  (|DFLOAT;retract;$I;78| (FLOAT-SIGN |x| 1.0) $)) 

(DEFUN |DFLOAT;abs;2$;81| (|x| $)
  (DECLARE (IGNORE $))
  (FLOAT-SIGN 1.0 |x|)) 

(DEFUN |DFLOAT;manexp| (|x| $)
  (PROG (|s| #0=#:G1523 |me| |two53|)
    (RETURN
      (SEQ (EXIT (COND
                   ((ZEROP |x|) (CONS 0 0))
                   ('T
                    (SEQ (LETT |s| (|DFLOAT;sign;$I;80| |x| $)
                               |DFLOAT;manexp|)
                         (LETT |x| (FLOAT-SIGN 1.0 |x|)
                               |DFLOAT;manexp|)
                         (COND
                           ((< |$DoubleFloatMaximum| |x|)
                            (PROGN
                              (LETT #0#
                                    (CONS
                                     (+
                                      (* |s|
                                       (|DFLOAT;mantissa;$I;7|
                                        |$DoubleFloatMaximum| $))
                                      1)
                                     (|DFLOAT;exponent;$I;8|
                                      |$DoubleFloatMaximum| $))
                                    |DFLOAT;manexp|)
                              (GO #0#))))
                         (LETT |me| (MANEXP |x|) |DFLOAT;manexp|)
                         (LETT |two53|
                               (EXPT (FLOAT-RADIX 0.0)
                                     (FLOAT-DIGITS 0.0))
                               |DFLOAT;manexp|)
                         (EXIT (CONS (* |s|
                                      (FIX (* |two53| (QCAR |me|))))
                                     (- (QCDR |me|) (FLOAT-DIGITS 0.0))))))))
           #0# (EXIT #0#))))) 

(DEFUN |DFLOAT;rationalApproximation;$2NniF;83| (|f| |d| |b| $)
  (PROG (|#G102| |nu| |ex| BASE #0=#:G1526 |de| |tol| |#G103| |q| |r|
                 |p2| |q2| #1=#:G1544 |#G104| |#G105| |p0| |p1| |#G106|
                 |#G107| |q0| |q1| |#G108| |#G109| |s| |t| #2=#:G1542)
    (RETURN
      (SEQ (EXIT (SEQ (PROGN
                        (LETT |#G102| (|DFLOAT;manexp| |f| $)
                              |DFLOAT;rationalApproximation;$2NniF;83|)
                        (LETT |nu| (QCAR |#G102|)
                              |DFLOAT;rationalApproximation;$2NniF;83|)
                        (LETT |ex| (QCDR |#G102|)
                              |DFLOAT;rationalApproximation;$2NniF;83|)
                        |#G102|)
                      (LETT BASE (FLOAT-RADIX 0.0)
                            |DFLOAT;rationalApproximation;$2NniF;83|)
                      (EXIT (COND
                              ((< |ex| 0)
                               (SEQ (LETT |de|
                                     (EXPT BASE
                                      (PROG1
                                       (LETT #0# (- |ex|)
                                        |DFLOAT;rationalApproximation;$2NniF;83|)
                                        (|check-subtype| (>= #0# 0)
                                         '(|NonNegativeInteger|) #0#)))
                                     |DFLOAT;rationalApproximation;$2NniF;83|)
                                    (EXIT
                                     (COND
                                       ((< |b| 2)
                                        (|error| "base must be > 1"))
                                       ('T
                                        (SEQ
                                         (LETT |tol| (EXPT |b| |d|)
                                          |DFLOAT;rationalApproximation;$2NniF;83|)
                                         (LETT |s| |nu|
                                          |DFLOAT;rationalApproximation;$2NniF;83|)
                                         (LETT |t| |de|
                                          |DFLOAT;rationalApproximation;$2NniF;83|)
                                         (LETT |p0| 0
                                          |DFLOAT;rationalApproximation;$2NniF;83|)
                                         (LETT |p1| 1
                                          |DFLOAT;rationalApproximation;$2NniF;83|)
                                         (LETT |q0| 1
                                          |DFLOAT;rationalApproximation;$2NniF;83|)
                                         (LETT |q1| 0
                                          |DFLOAT;rationalApproximation;$2NniF;83|)
                                         (EXIT
                                          (SEQ G190 NIL
                                           (SEQ
                                            (PROGN
                                              (LETT |#G103|
                                               (DIVIDE2 |s| |t|)
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |q| (QCAR |#G103|)
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |r| (QCDR |#G103|)
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              |#G103|)
                                            (LETT |p2|
                                             (+ (* |q| |p1|) |p0|)
                                             |DFLOAT;rationalApproximation;$2NniF;83|)
                                            (LETT |q2|
                                             (+ (* |q| |q1|) |q0|)
                                             |DFLOAT;rationalApproximation;$2NniF;83|)
                                            (COND
                                              ((OR (EQL |r| 0)
                                                (<
                                                 (SPADCALL |tol|
                                                  (ABS
                                                   (- (* |nu| |q2|)
                                                    (* |de| |p2|)))
                                                  (|getShellEntry| $
                                                   119))
                                                 (* |de| (ABS |p2|))))
                                               (EXIT
                                                (PROGN
                                                  (LETT #1#
                                                   (SPADCALL |p2| |q2|
                                                    (|getShellEntry| $
                                                     118))
                                                   |DFLOAT;rationalApproximation;$2NniF;83|)
                                                  (GO #1#)))))
                                            (PROGN
                                              (LETT |#G104| |p1|
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |#G105| |p2|
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |p0| |#G104|
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |p1| |#G105|
                                               |DFLOAT;rationalApproximation;$2NniF;83|))
                                            (PROGN
                                              (LETT |#G106| |q1|
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |#G107| |q2|
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |q0| |#G106|
                                               |DFLOAT;rationalApproximation;$2NniF;83|)
                                              (LETT |q1| |#G107|
                                               |DFLOAT;rationalApproximation;$2NniF;83|))
                                            (EXIT
                                             (PROGN
                                               (LETT |#G108| |t|
                                                |DFLOAT;rationalApproximation;$2NniF;83|)
                                               (LETT |#G109| |r|
                                                |DFLOAT;rationalApproximation;$2NniF;83|)
                                               (LETT |s| |#G108|
                                                |DFLOAT;rationalApproximation;$2NniF;83|)
                                               (LETT |t| |#G109|
                                                |DFLOAT;rationalApproximation;$2NniF;83|))))
                                           NIL (GO G190) G191
                                           (EXIT NIL)))))))))
                              ('T
                               (SPADCALL
                                   (* |nu|
                                    (EXPT BASE
                                     (PROG1
                                      (LETT #2# |ex|
                                       |DFLOAT;rationalApproximation;$2NniF;83|)
                                       (|check-subtype| (>= #2# 0)
                                        '(|NonNegativeInteger|) #2#))))
                                   (|getShellEntry| $ 120)))))))
           #1# (EXIT #1#))))) 

(DEFUN |DFLOAT;**;$F$;84| (|x| |r| $)
  (PROG (|n| |d| #0=#:G1553)
    (RETURN
      (SEQ (EXIT (COND
                   ((ZEROP |x|)
                    (COND
                      ((SPADCALL |r| (|getShellEntry| $ 121))
                       (|error| "0**0 is undefined"))
                      ((SPADCALL |r| (|getShellEntry| $ 122))
                       (|error| "division by 0"))
                      ('T 0.0)))
                   ((OR (SPADCALL |r| (|getShellEntry| $ 121))
                        (= |x| 1.0))
                    1.0)
                   ('T
                    (COND
                      ((SPADCALL |r| (|spadConstant| $ 123)
                           (|getShellEntry| $ 124))
                       |x|)
                      ('T
                       (SEQ (LETT |n|
                                  (SPADCALL |r|
                                      (|getShellEntry| $ 125))
                                  |DFLOAT;**;$F$;84|)
                            (LETT |d|
                                  (SPADCALL |r|
                                      (|getShellEntry| $ 126))
                                  |DFLOAT;**;$F$;84|)
                            (EXIT (COND
                                    ((MINUSP |x|)
                                     (COND
                                       ((ODDP |d|)
                                        (COND
                                          ((ODDP |n|)
                                           (PROGN
                                             (LETT #0#
                                              (-
                                               (|DFLOAT;**;$F$;84|
                                                (- |x|) |r| $))
                                              |DFLOAT;**;$F$;84|)
                                             (GO #0#)))
                                          ('T
                                           (PROGN
                                             (LETT #0#
                                              (|DFLOAT;**;$F$;84|
                                               (- |x|) |r| $)
                                              |DFLOAT;**;$F$;84|)
                                             (GO #0#)))))
                                       ('T (|error| "negative root"))))
                                    ((EQL |d| 2)
                                     (EXPT (|DFLOAT;sqrt;2$;30| |x| $)
                                      |n|))
                                    ('T
                                     (|DFLOAT;**;3$;33| |x|
                                      (/
                                       (FLOAT |n|
                                        |$DoubleFloatMaximum|)
                                       (FLOAT |d|
                                        |$DoubleFloatMaximum|))
                                      $))))))))))
           #0# (EXIT #0#))))) 

(DEFUN |DoubleFloat| ()
  (PROG ()
    (RETURN
      (PROG (#0=#:G1566)
        (RETURN
          (COND
            ((LETT #0# (HGET |$ConstructorCache| '|DoubleFloat|)
                   |DoubleFloat|)
             (|CDRwithIncrement| (CDAR #0#)))
            ('T
             (UNWIND-PROTECT
               (PROG1 (CDDAR (HPUT |$ConstructorCache| '|DoubleFloat|
                                   (LIST
                                    (CONS NIL
                                     (CONS 1 (|DoubleFloat;|))))))
                 (LETT #0# T |DoubleFloat|))
               (COND
                 ((NOT #0#) (HREM |$ConstructorCache| '|DoubleFloat|))))))))))) 

(DEFUN |DoubleFloat;| ()
  (PROG (|dv$| $ |pv$|)
    (RETURN
      (PROGN
        (LETT |dv$| '(|DoubleFloat|) . #0=(|DoubleFloat|))
        (LETT $ (|newShell| 140) . #0#)
        (|setShellEntry| $ 0 |dv$|)
        (|setShellEntry| $ 3
            (LETT |pv$| (|buildPredVector| 0 0 NIL) . #0#))
        (|haddProp| |$ConstructorCache| '|DoubleFloat| NIL (CONS 1 $))
        (|stuffDomainSlots| $)
        $)))) 

(MAKEPROP '|DoubleFloat| '|infovec|
    (LIST '#(NIL NIL NIL NIL NIL NIL (|OpenMathEncoding|)
             (0 . |OMencodingXML|) (|String|) (|OpenMathDevice|)
             (4 . |OMopenString|) (|Void|) (10 . |OMputObject|)
             (|DoubleFloat|) (15 . |OMputFloat|)
             (21 . |OMputEndObject|) (26 . |OMclose|)
             |DFLOAT;OMwrite;$S;1| (|Boolean|) |DFLOAT;OMwrite;$BS;2|
             |DFLOAT;OMwrite;Omd$V;3| |DFLOAT;OMwrite;Omd$BV;4|
             (|PositiveInteger|) |DFLOAT;base;Pi;6| (|Integer|)
             |DFLOAT;mantissa;$I;7| |DFLOAT;exponent;$I;8|
             |DFLOAT;precision;Pi;9| |DFLOAT;log2;2$;37| (31 . *)
             |DFLOAT;bits;Pi;10| |DFLOAT;max;$;11| |DFLOAT;min;$;12|
             |DFLOAT;order;$I;13|
             (CONS IDENTITY
                   (FUNCALL (|dispatchFunction| |DFLOAT;Zero;$;14|) $))
             (CONS IDENTITY
                   (FUNCALL (|dispatchFunction| |DFLOAT;One;$;15|) $))
             |DFLOAT;exp1;$;16| |DFLOAT;pi;$;17| (|OutputForm|)
             (37 . |outputForm|) |DFLOAT;coerce;$Of;18| (|InputForm|)
             (42 . |convert|) |DFLOAT;convert;$If;19| |DFLOAT;<;2$B;20|
             |DFLOAT;-;2$;21| |DFLOAT;+;3$;22| |DFLOAT;-;3$;23|
             |DFLOAT;*;3$;24| |DFLOAT;*;I2$;25| |DFLOAT;max;3$;26|
             |DFLOAT;min;3$;27| |DFLOAT;=;2$B;28| |DFLOAT;/;$I$;29|
             |DFLOAT;sqrt;2$;30| |DFLOAT;log10;2$;31|
             |DFLOAT;**;$I$;32| |DFLOAT;**;3$;33| |DFLOAT;coerce;I$;34|
             |DFLOAT;exp;2$;35| |DFLOAT;log;2$;36| |DFLOAT;sin;2$;38|
             |DFLOAT;cos;2$;39| |DFLOAT;tan;2$;40| |DFLOAT;cot;2$;41|
             |DFLOAT;sec;2$;42| |DFLOAT;csc;2$;43| |DFLOAT;asin;2$;44|
             |DFLOAT;acos;2$;45| |DFLOAT;atan;2$;46|
             |DFLOAT;acsc;2$;47| |DFLOAT;acot;2$;48|
             |DFLOAT;asec;2$;49| |DFLOAT;sinh;2$;50|
             |DFLOAT;cosh;2$;51| |DFLOAT;tanh;2$;52|
             |DFLOAT;csch;2$;53| |DFLOAT;coth;2$;54|
             |DFLOAT;sech;2$;55| |DFLOAT;asinh;2$;56|
             |DFLOAT;acosh;2$;57| |DFLOAT;atanh;2$;58|
             |DFLOAT;acsch;2$;59| |DFLOAT;acoth;2$;60|
             |DFLOAT;asech;2$;61| |DFLOAT;/;3$;62|
             |DFLOAT;negative?;$B;63| |DFLOAT;zero?;$B;64|
             (|SingleInteger|) |DFLOAT;hash;$Si;65|
             (|Union| $ '"failed") |DFLOAT;recip;$U;66|
             |DFLOAT;differentiate;2$;67|
             (|DoubleFloatSpecialFunctions|) (47 . |Gamma|)
             |DFLOAT;Gamma;2$;68| (52 . |Beta|) |DFLOAT;Beta;3$;69|
             |DFLOAT;wholePart;$I;70| |DFLOAT;float;2IPi$;71|
             |DFLOAT;convert;2$;72| (|Float|) (58 . |convert|)
             |DFLOAT;convert;$F;73| (|Fraction| 24)
             (|NonNegativeInteger|)
             |DFLOAT;rationalApproximation;$2NniF;83|
             |DFLOAT;rationalApproximation;$NniF;74|
             |DFLOAT;atan;3$;75| |DFLOAT;retract;$F;76|
             (|Union| 104 '"failed") |DFLOAT;retractIfCan;$U;77|
             |DFLOAT;retract;$I;78| (|Union| 24 '"failed")
             |DFLOAT;retractIfCan;$U;79| |DFLOAT;sign;$I;80|
             |DFLOAT;abs;2$;81| (63 . |Zero|) (67 . /) (73 . *)
             (79 . |coerce|) (84 . |zero?|) (89 . |negative?|)
             (94 . |One|) (98 . =) (104 . |numer|) (109 . |denom|)
             |DFLOAT;**;$F$;84| (|PatternMatchResult| 101 $)
             (|Pattern| 101) (|Factored| $)
             (|Record| (|:| |coef1| $) (|:| |coef2| $))
             (|Union| 131 '"failed") (|List| $) (|Union| 133 '"failed")
             (|Record| (|:| |coef1| $) (|:| |coef2| $)
                 (|:| |generator| $))
             (|Record| (|:| |quotient| $) (|:| |remainder| $))
             (|SparseUnivariatePolynomial| $)
             (|Record| (|:| |coef| 133) (|:| |generator| $))
             (|Record| (|:| |unit| $) (|:| |canonical| $)
                 (|:| |associate| $)))
          '#(~= 114 |zero?| 120 |wholePart| 125 |unitNormal| 130
             |unitCanonical| 135 |unit?| 140 |truncate| 145 |tanh| 150
             |tan| 155 |subtractIfCan| 160 |squareFreePart| 166
             |squareFree| 171 |sqrt| 176 |sizeLess?| 181 |sinh| 187
             |sin| 192 |sign| 197 |sech| 202 |sec| 207 |sample| 212
             |round| 216 |retractIfCan| 221 |retract| 231 |rem| 241
             |recip| 247 |rationalApproximation| 252 |quo| 265
             |principalIdeal| 271 |prime?| 276 |precision| 281
             |positive?| 285 |pi| 290 |patternMatch| 294 |order| 301
             |one?| 306 |nthRoot| 311 |norm| 317 |negative?| 322
             |multiEuclidean| 327 |min| 333 |max| 343 |mantissa| 353
             |log2| 358 |log10| 363 |log| 368 |lcm| 373 |latex| 384
             |inv| 389 |hash| 394 |gcdPolynomial| 399 |gcd| 405
             |fractionPart| 416 |floor| 421 |float| 426 |factor| 439
             |extendedEuclidean| 444 |exquo| 457 |expressIdealMember|
             463 |exponent| 469 |exp1| 474 |exp| 478 |euclideanSize|
             483 |divide| 488 |digits| 494 |differentiate| 498 |csch|
             509 |csc| 514 |coth| 519 |cot| 524 |cosh| 529 |cos| 534
             |convert| 539 |coerce| 559 |characteristic| 589 |ceiling|
             593 |bits| 598 |base| 602 |atanh| 606 |atan| 611
             |associates?| 622 |asinh| 628 |asin| 633 |asech| 638
             |asec| 643 |acsch| 648 |acsc| 653 |acoth| 658 |acot| 663
             |acosh| 668 |acos| 673 |abs| 678 |Zero| 683 |One| 687
             |OMwrite| 691 |Gamma| 715 D 720 |Beta| 731 >= 737 > 743 =
             749 <= 755 < 761 / 767 - 779 + 790 ** 796 * 826)
          '((|approximate| . 0) (|canonicalsClosed| . 0)
            (|canonicalUnitNormal| . 0) (|noZeroDivisors| . 0)
            ((|commutative| "*") . 0) (|rightUnitary| . 0)
            (|leftUnitary| . 0) (|unitsKnown| . 0))
          (CONS (|makeByteWordVec2| 1
                    '(0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                      0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                      0 0 0 0 0 0 0 0 0))
                (CONS '#(|FloatingPointSystem&| |RealNumberSystem&|
                         |Field&| |EuclideanDomain&| NIL
                         |UniqueFactorizationDomain&| |GcdDomain&|
                         |DivisionRing&| |IntegralDomain&| |Algebra&|
                         |Algebra&| |DifferentialRing&| NIL
                         |OrderedRing&| |Module&| NIL NIL |Module&| NIL
                         NIL |Ring&| NIL NIL NIL NIL NIL NIL NIL
                         |AbelianGroup&| NIL NIL NIL |AbelianMonoid&|
                         |Monoid&| NIL |OrderedSet&|
                         |AbelianSemiGroup&| |SemiGroup&|
                         |TranscendentalFunctionCategory&|
                         |RetractableTo&| |RetractableTo&| NIL
                         |SetCategory&| NIL
                         |ElementaryFunctionCategory&| NIL
                         |HyperbolicFunctionCategory&|
                         |ArcTrigonometricFunctionCategory&|
                         |TrigonometricFunctionCategory&| NIL NIL
                         |RadicalCategory&| NIL NIL NIL NIL NIL
                         |BasicType&| NIL)
                      (CONS '#((|FloatingPointSystem|)
                               (|RealNumberSystem|) (|Field|)
                               (|EuclideanDomain|)
                               (|PrincipalIdealDomain|)
                               (|UniqueFactorizationDomain|)
                               (|GcdDomain|) (|DivisionRing|)
                               (|IntegralDomain|) (|Algebra| 104)
                               (|Algebra| $$) (|DifferentialRing|)
                               (|CharacteristicZero|) (|OrderedRing|)
                               (|Module| 104) (|EntireRing|)
                               (|CommutativeRing|) (|Module| $$)
                               (|BiModule| 104 104) (|BiModule| $$ $$)
                               (|Ring|) (|OrderedAbelianGroup|)
                               (|RightModule| 104) (|LeftModule| 104)
                               (|LeftModule| $$) (|Rng|)
                               (|RightModule| $$)
                               (|OrderedCancellationAbelianMonoid|)
                               (|AbelianGroup|)
                               (|OrderedAbelianMonoid|)
                               (|CancellationAbelianMonoid|)
                               (|OrderedAbelianSemiGroup|)
                               (|AbelianMonoid|) (|Monoid|)
                               (|PatternMatchable| 101) (|OrderedSet|)
                               (|AbelianSemiGroup|) (|SemiGroup|)
                               (|TranscendentalFunctionCategory|)
                               (|RetractableTo| 104)
                               (|RetractableTo| 24) (|RealConstant|)
                               (|SetCategory|) (|ConvertibleTo| 41)
                               (|ElementaryFunctionCategory|)
                               (|ArcHyperbolicFunctionCategory|)
                               (|HyperbolicFunctionCategory|)
                               (|ArcTrigonometricFunctionCategory|)
                               (|TrigonometricFunctionCategory|)
                               (|OpenMath|) (|ConvertibleTo| 129)
                               (|RadicalCategory|) (|CoercibleFrom| 24)
                               (|ConvertibleTo| 101)
                               (|ConvertibleTo| 13)
                               (|CoercibleFrom| 104)
                               (|CoercibleFrom| $$) (|BasicType|)
                               (|CoercibleTo| 38))
                            (|makeByteWordVec2| 139
                                '(0 6 0 7 2 9 0 8 6 10 1 9 11 0 12 2 9
                                  11 0 13 14 1 9 11 0 15 1 9 11 0 16 2
                                  0 0 22 0 29 1 38 0 13 39 1 41 0 13 42
                                  1 93 13 13 94 2 93 13 13 13 96 1 101
                                  0 13 102 0 104 0 117 2 104 0 24 24
                                  118 2 24 0 105 0 119 1 104 0 24 120 1
                                  104 18 0 121 1 104 18 0 122 0 104 0
                                  123 2 104 18 0 0 124 1 104 24 0 125 1
                                  104 24 0 126 2 0 18 0 0 1 1 0 18 0 87
                                  1 0 24 0 98 1 0 139 0 1 1 0 0 0 1 1 0
                                  18 0 1 1 0 0 0 1 1 0 0 0 75 1 0 0 0
                                  63 2 0 90 0 0 1 1 0 0 0 1 1 0 130 0 1
                                  1 0 0 0 54 2 0 18 0 0 1 1 0 0 0 73 1
                                  0 0 0 61 1 0 24 0 115 1 0 0 0 78 1 0
                                  0 0 65 0 0 0 1 1 0 0 0 1 1 0 110 0
                                  111 1 0 113 0 114 1 0 104 0 109 1 0
                                  24 0 112 2 0 0 0 0 1 1 0 90 0 91 2 0
                                  104 0 105 107 3 0 104 0 105 105 106 2
                                  0 0 0 0 1 1 0 138 133 1 1 0 18 0 1 0
                                  0 22 27 1 0 18 0 1 0 0 0 37 3 0 128 0
                                  129 128 1 1 0 24 0 33 1 0 18 0 1 2 0
                                  0 0 24 1 1 0 0 0 1 1 0 18 0 86 2 0
                                  134 133 0 1 0 0 0 32 2 0 0 0 0 51 0 0
                                  0 31 2 0 0 0 0 50 1 0 24 0 25 1 0 0 0
                                  28 1 0 0 0 55 1 0 0 0 60 2 0 0 0 0 1
                                  1 0 0 133 1 1 0 8 0 1 1 0 0 0 1 1 0
                                  88 0 89 2 0 137 137 137 1 1 0 0 133 1
                                  2 0 0 0 0 1 1 0 0 0 1 1 0 0 0 1 3 0 0
                                  24 24 22 99 2 0 0 24 24 1 1 0 130 0 1
                                  3 0 132 0 0 0 1 2 0 135 0 0 1 2 0 90
                                  0 0 1 2 0 134 133 0 1 1 0 24 0 26 0 0
                                  0 36 1 0 0 0 59 1 0 105 0 1 2 0 136 0
                                  0 1 0 0 22 1 1 0 0 0 92 2 0 0 0 105 1
                                  1 0 0 0 76 1 0 0 0 66 1 0 0 0 77 1 0
                                  0 0 64 1 0 0 0 74 1 0 0 0 62 1 0 41 0
                                  43 1 0 129 0 1 1 0 101 0 103 1 0 13 0
                                  100 1 0 0 104 1 1 0 0 24 58 1 0 0 104
                                  1 1 0 0 24 58 1 0 0 0 1 1 0 38 0 40 0
                                  0 105 1 1 0 0 0 1 0 0 22 30 0 0 22 23
                                  1 0 0 0 81 2 0 0 0 0 108 1 0 0 0 69 2
                                  0 18 0 0 1 1 0 0 0 79 1 0 0 0 67 1 0
                                  0 0 84 1 0 0 0 72 1 0 0 0 82 1 0 0 0
                                  70 1 0 0 0 83 1 0 0 0 71 1 0 0 0 80 1
                                  0 0 0 68 1 0 0 0 116 0 0 0 34 0 0 0
                                  35 2 0 11 9 0 20 3 0 11 9 0 18 21 1 0
                                  8 0 17 2 0 8 0 18 19 1 0 0 0 95 1 0 0
                                  0 1 2 0 0 0 105 1 2 0 0 0 0 97 2 0 18
                                  0 0 1 2 0 18 0 0 1 2 0 18 0 0 52 2 0
                                  18 0 0 1 2 0 18 0 0 44 2 0 0 0 24 53
                                  2 0 0 0 0 85 2 0 0 0 0 47 1 0 0 0 45
                                  2 0 0 0 0 46 2 0 0 0 0 57 2 0 0 0 104
                                  127 2 0 0 0 24 56 2 0 0 0 105 1 2 0 0
                                  0 22 1 2 0 0 104 0 1 2 0 0 0 104 1 2
                                  0 0 0 0 48 2 0 0 24 0 49 2 0 0 105 0
                                  1 2 0 0 22 0 29)))))
          '|lookupComplete|)) 

(MAKEPROP '|DoubleFloat| 'NILADIC T) 
