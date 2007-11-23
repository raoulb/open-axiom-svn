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

s01eaf() ==
  page := htInitPage("S01EAF - Complex exponential {\em exp(z)} ",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs01eaf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s01eaf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Evaluates the exponential function, exp(z), for complex z. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "-0.5" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "2.0" y F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's01eafGen)
  htShowPage()

s01eafGen htPage == 
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  linkGen STRCONC('"s01eaf(complex(",x,",",y,"),",STRINGIMAGE ifail,")")



s13aaf() ==
  page := htInitPage("S13AAF - Exponential integral \htbitmap{s13aaf2}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs13aaf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s13aaf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the exponential integral \vspace{-32} ")
    (text . "\htbitmap{s13aaf1} ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "2.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s13aaf")
  htShowPage()

s13acf() ==
  page := htInitPage("S13ACF - Cosine integral {\em Ci(x)} ",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs13acf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s13acf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the cosine integral \space{1} ")
    (text . "\htbitmap{s13acf} ")
    (text . ", where \gamma denotes Euler's constant. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.2" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s13acf")
  htShowPage()

s13adf() ==
  page := htInitPage("S13ADF - Sine integral Si(x) ",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs13adf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s13adf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the sine integral \space{1} \vspace{-32} ")
    (text . "\inputbitmap{\htbmdir{}/s13adf.bitmap} \vspace{-37}. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.2" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s13adf")
  htShowPage()

s14aaf() ==
  page := htInitPage("S14AAF - Gamma Function \Gamma(x) ",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs14aaf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s14aaf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the gamma function, {\em Gamma(x)}. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "1.25" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s14aaf")
  htShowPage()

s14abf() ==
  page := htInitPage("S14ABF - Log Gamma Function \Gamma(x) ",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs14abf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s14abf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the logarithm of the gamma function, ")
    (text . "{\em ln Gamma(x)}. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "1.25" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s14abf")
  htShowPage()

s14baf() ==
  htInitPage("S14BAF - Incomplete Gamma Functions P(a,x) & Q(a,x)",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs14baf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s14baf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the incomplete gamma functions, \space{1} ")
    (text . "\vspace{-32} \inputbitmap{\htbmdir{}/s14baf.bitmap} \vspace{-37}, ")
    (text . "which are normalised such that P(a,x) + Q(a,x) = 1. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\newline \menuitemstyle{}\tab{2} ")
    (text . "Enter the value of {\em a}: > 0.0")
    (text . "\tab{32} \menuitemstyle{}\tab{34} ")
    (text . "Enter the value of {\em x}:  >= 0.0 ")
    (text . "\newline\tab{2} ")
    (bcStrings (10 "2.0" a F))
    (text . "\tab{34} ")
    (bcStrings (10 "3.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the tolerance:")
    (text . "\newline\tab{2} ")
    (bcStrings (30 "1.1102230246251600E-16" tol F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's14bafGen)
  htShowPage()

s14bafGen htPage == 
  a := htpLabelInputString(htPage,'a)
  x := htpLabelInputString(htPage,'x)
  tol := htpLabelInputString(htPage,'tol)
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  linkGen STRCONC('"s14baf(",a,",",x,",",tol,",",STRINGIMAGE ifail,")")

s15adf() ==
  page := htInitPage("S15ADF - Complement of error function erfc x",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs15adf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s15adf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the complementary gamma functions, erfc x = ")
    (text . "\space{1} \vspace{-32} \inputbitmap{\htbmdir{}/s15adf.bitmap} ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "-10.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s15adf")
  htShowPage()

s15aef() ==
  page := htInitPage("S15AEF - Error Function erf x", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs15aef} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s15aef| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the error function, erf x = \space{1} ")
    (text . "\vspace{-32} \inputbitmap{\htbmdir{}/s15aef.bitmap} ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "-6.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s15aef")
  htShowPage()

s17acf() ==
  page := htInitPage("S17ACF - Bessel Function \space{1} \htbitmap{s17acf}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17acf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17acf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Bessel function \space{1} \htbitmap{s17acf}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17acf")
  htShowPage()

s17adf() ==
  page := htInitPage("S17ADF - Bessel Function \space{1} \htbitmap{s17adf}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17adf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17adf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Bessel function \space{1} \htbitmap{s17adf}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17adf")
  htShowPage()

s17aef() ==
  page := htInitPage("S17AEF - Bessel Function \space{1} \htbitmap{s17aef}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17aef} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17aef| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Bessel function \space{1}")
    (text . "\htbitmap{s17aef}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17aef")
  htShowPage()

s17aff() ==
  page := htInitPage("S17AFF - Bessel Function \space{1} \htbitmap{s17aff}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17aff} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17aff| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Bessel function \space{1} \htbitmap{s17aff}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17aff")
  htShowPage()

s17agf() ==
  page := htInitPage("S17AGF - Airy Function {\em Ai(x)}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17agf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17agf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Airy function {\em Ai(x)} ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "-10.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17agf")
  htShowPage()

s17ahf() ==
  page := htInitPage("S17AHF - Airy Function {\em Bi(x)}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17ahf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17ahf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Airy function {\em Bi(x)} ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "-10.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17ahf")
  htShowPage()

s17ajf() ==
  page := htInitPage("S17AJF - Airy Function {\em Ai'(x)}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17ajf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17ajf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates {\em Ai'(x)}, ")
    (text . "the derivative of the Airy function Ai(x) ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "-10.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17ajf")
  htShowPage()

s17akf() ==
  page := htInitPage("S17AKF - Airy Function {\em Bi'(x)}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs17akf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17akf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates {\em Bi'(x)}, ")
    (text . "the derivative of the Airy function Bi(x) ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "-10.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s17akf")
  htShowPage()

s17dcf() ==
  htInitPage('"S17DCF - Bessel function \htbitmap{s17dcf}, real a \space{1} \htbitmap{great=} 0, complex z, v = 0,1,2,...",nil)
  htMakePage '(
    (domainConditions 
       (isDomain F (Float))
         (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXs17dcf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17dcf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Returns a sequence of values for the Bessel functions ")
    (text . "\htbitmap{s17dcf}, for complex z, non-negative v ")
    (text . "and n = 0,1,...,N-1, with an option for exponential scaling.")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Order v of the first member of the sequence of functions ")
    (text . "{\it FNU} \htbitmap{great=} 0:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.0" fnu F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.3" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.4" y F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Number of members required in sequence {\it N} ")
    (text . "\htbitmap{great=} 1:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 2 n PI))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Scaling option: ")
    (radioButtons scale
        ("" "  Unscaled" u)
        ("" "  Scaled" s))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Ifail value: ")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's17dcfGen)
  htShowPage()


s17dcfGen htPage == 
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  fnu := htpLabelInputString(htPage,'fnu)
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  uors := htpButtonValue(htPage,'scale)
  scale := 
    uors = 'u => '"u"
    '"s"
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  prefix := STRCONC('"s17dcf(",fnu,",complex(",x,",",y,"),",STRINGIMAGE n)
  prefix := STRCONC(prefix,",_"",scale,"_", ",STRINGIMAGE ifail,")")
  linkGen prefix

s17def() ==
  htInitPage('"S17DEF - Bessel function \htbitmap{s17def}, real a \space{1} \htbitmap{great=} 0, complex z, v = 0,1,2,...",nil)
  htMakePage '(
    (domainConditions 
       (isDomain F (Float))
         (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXs17def} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17def| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Returns a sequence of values for the Bessel functions ")
    (text . "\htbitmap{s17def}, for complex z, non-negative v ")
    (text . "and n = 0,1,...,N-1, with an option for exponential scaling.")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Order v of the first member of the sequence of functions ")
    (text . "{\it FNU} \htbitmap{great=} 0:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.0" fnu F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.3" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.4" y F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Number of members required in sequence {\it N} ")
    (text . "\htbitmap{great=} 1:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 2 n PI))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Scaling option: ")
    (radioButtons scale
        ("" "  Unscaled" u)
        ("" "  Scaled" s))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Ifail value: ")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's17defGen)
  htShowPage()


s17defGen htPage == 
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  fnu := htpLabelInputString(htPage,'fnu)
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  uors := htpButtonValue(htPage,'scale)
  scale := 
    uors = 'u => '"u"
    '"s"
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  prefix := STRCONC('"s17def(",fnu,",complex(",x,",",y,"),",STRINGIMAGE n)
  prefix := STRCONC(prefix,",_"",scale,"_", ",STRINGIMAGE ifail,")")
  linkGen prefix


s17dgf() ==
  htInitPage('"S17DGF - Airy functions {\em Ai(z)} and {\em Ai'(z)} ",nil)
  htMakePage '(
    (domainConditions 
       (isDomain F (Float))
         (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXs17dgf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17dgf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Evaluates the Airy function Ai(z) or its derivative Ai'(z), ")
    (text . "for complex z, with an option for exponential scaling. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.3" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.4" y F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Function or derivative required: ")
    (radioButtons deriv
        ("" "  Function" f)
        ("" "  Derivative" d))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Scaling option: ")
    (radioButtons scale
        ("" "  Unscaled" u)
        ("" "  Scaled" s))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Ifail value: ")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's17dgfGen)
  htShowPage()


s17dgfGen htPage == 
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  ford := htpButtonValue(htPage,'deriv)
  deriv := 
    ford = 'f => '"f"
    '"d"
  uors := htpButtonValue(htPage,'scale)
  scale := 
    uors = 'u => '"u"
    '"s"
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  prefix := STRCONC('"s17dgf(_"",deriv,"_",complex(",x,",",y,"),_"")
  prefix := STRCONC(prefix,scale,"_", ",STRINGIMAGE ifail,")")
  linkGen prefix

s17dhf() ==
  htInitPage('"S17DHF - Airy functions {\em Bi(z)} and {\em Bi'(z)} ",nil)
  htMakePage '(
    (domainConditions 
       (isDomain F (Float))
         (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXs17dhf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17dhf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Evaluates the Airy function Bi(z) or its derivative Bi'(z), ")
    (text . "for complex z, with an option for exponential scaling. ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.3" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.4" y F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Function or derivative required: ")
    (radioButtons deriv
        ("" "  Function" f)
        ("" "  Derivative" d))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Scaling option: ")
    (radioButtons scale
        ("" "  Unscaled" u)
        ("" "  Scaled" s))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Ifail value: ")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's17dhfGen)
  htShowPage()


s17dhfGen htPage == 
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  ford := htpButtonValue(htPage,'deriv)
  deriv := 
    ford = 'f => '"f"
    '"d"
  uors := htpButtonValue(htPage,'scale)
  scale := 
    uors = 'u => '"u"
    '"s"
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  prefix := STRCONC('"s17dhf(_"",deriv,"_",complex(",x,",",y,"),_"")
  prefix := STRCONC(prefix,scale,"_", ",STRINGIMAGE ifail,")")
  linkGen prefix


s17dlf() ==
  htInitPage('"S17DLF - Hankel function \vspace{-28} \htbitmap{s17dlf} \vspace{-37}, j = 1,2, real a \space{1} \htbitmap{great=} 0, complex z, v = 0,1,2,...",nil)
  htMakePage '(
    (domainConditions 
       (isDomain F (Float))
         (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXs17dlf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s17dlf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Returns a sequence of values for the Hankel functions ")
    (text . "\htbitmap{s17dlf}, j = 1,2, for complex z, ")
    (text . "non-negative v ")
    (text . "and n = 0,1,...,N-1, with an option for exponential scaling.")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Order v of the first member of the sequence of functions ")
    (text . "{\it FNU} \htbitmap{great=} 0:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.0" fnu F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.3" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.4" y F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Number of members required in sequence {\it N} ")
    (text . "\htbitmap{great=} 1:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 2 n PI))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Hankel function {\it m}: ")
    (radioButtons hankel
        ("" "  \htbitmap{s17dlf1}" mone)
        ("" "  \htbitmap{s17dlf2}" mtwo))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Scaling option: ")
    (radioButtons scale
        ("" "  Unscaled" u)
        ("" "  Scaled" s))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Ifail value: ")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's17dlfGen)
  htShowPage()


s17dlfGen htPage == 
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  fnu := htpLabelInputString(htPage,'fnu)
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  hankel := htpButtonValue(htPage,'hankel)
  m := 
    hankel = 'mone => '1
    '2
  uors := htpButtonValue(htPage,'scale)
  scale := 
    uors = 'u => '"u"
    '"s"
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  prefix := STRCONC('"s17dlf(",STRINGIMAGE m,", ",fnu,",complex(")
  prefix := STRCONC(prefix,x,",",y,"),",STRINGIMAGE n)
  prefix := STRCONC(prefix,",_"",scale,"_", ",STRINGIMAGE ifail,")")
  linkGen prefix


s18acf() ==
  page := htInitPage("S18ACF - Modified Bessel Function \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s18acf1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs18acf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s18acf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the modified Bessel function \space{1} \vspace{-28}")
    (text . "\inputbitmap{\htbmdir{}/s18acf.bitmap} \vspace{-40}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.4" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s18acf")
  htShowPage()

s18adf() ==
  page := htInitPage("S18ADF - Modified Bessel Function \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s18adf1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs18adf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s18adf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the modified Bessel function \space{1} \vspace{-28}")
    (text . "\inputbitmap{\htbmdir{}/s18adf.bitmap} \vspace{-40}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.4" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s18adf")
  htShowPage()

s18aef() ==
  page := htInitPage("S18AeF - Modified Bessel Function \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s18aef1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs18aef} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s18aef| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the modified Bessel function \space{1} \vspace{-28}")
    (text . "\inputbitmap{\htbmdir{}/s18aef.bitmap} \vspace{-40}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s18aef")
  htShowPage()

s18aff() ==
  page := htInitPage("S18AFF - Modified Bessel Function \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s18aff1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs18aff} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s18aff| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the modified Bessel function \space{1} \vspace{-28}")
    (text . "\inputbitmap{\htbmdir{}/s18aff.bitmap} \vspace{-40}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s18aff")
  htShowPage()

s18dcf() ==
  htInitPage('"S18DCF - Bessel function \htbitmap{s18dcf}, real a \space{1} \htbitmap{great=} 0, complex z, v = 0,1,2,...",nil)
  htMakePage '(
    (domainConditions 
       (isDomain F (Float))
         (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXs18dcf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s18dcf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Returns a sequence of values for the modified Bessel functions ")
    (text . "\htbitmap{s18dcf}, for complex z, non-negative v ")
    (text . "and n = 0,1,...,N-1, with an option for exponential scaling.")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Order v of the first member of the sequence of functions ")
    (text . "{\it FNU} \htbitmap{great=} 0:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.0" fnu F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.3" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.4" y F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Number of members required in sequence {\it N} ")
    (text . "\htbitmap{great=} 1:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 2 n PI))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Scaling option: ")
    (radioButtons scale
        ("" "  Unscaled" u)
        ("" "  Scaled" s))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Ifail value: ")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's18dcfGen)
  htShowPage()


s18dcfGen htPage == 
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  fnu := htpLabelInputString(htPage,'fnu)
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  uors := htpButtonValue(htPage,'scale)
  scale := 
    uors = 'u => '"u"
    '"s"
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  prefix := STRCONC('"s18dcf(",fnu,",complex(",x,",",y,"),",STRINGIMAGE n)
  prefix := STRCONC(prefix,",_"",scale,"_", ",STRINGIMAGE ifail,")")
  linkGen prefix

s18def() ==
  htInitPage('"S18DEF - Modified bessel function \htbitmap{s18def}, real a \space{1} \htbitmap{great=} 0, complex z, v = 0,1,2,...",nil)
  htMakePage '(
    (domainConditions 
       (isDomain F (Float))
         (isDomain PI (PositiveInteger)))
    (text . "\windowlink{Manual Page}{manpageXXs18def} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s18def| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\newline ")
    (text . "Returns a sequence of values for the modified Bessel functions ")
    (text . "\htbitmap{s18def}, for complex z, non-negative v ")
    (text . "and n = 0,1,...,N-1, with an option for exponential scaling.")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Order v of the first member of the sequence of functions ")
    (text . "{\it FNU} \htbitmap{great=} 0:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.0" fnu F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Real part of {\it z}:")
    (text . "\tab{32} \menuitemstyle{}\tab{34}")
    (text . "Imaginary part of {\it z}:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 "0.3" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "-0.4" y F))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Number of members required in sequence {\it N} ")
    (text . "\htbitmap{great=} 1:")
    (text . "\newline \tab{2} ")
    (bcStrings (10 2 n PI))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Scaling option: ")
    (radioButtons scale
        ("" "  Unscaled" u)
        ("" "  Scaled" s))
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{} \tab{2} ")
    (text . "\newline \tab{2} ")
    (text . "Ifail value: ")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's18defGen)
  htShowPage()


s18defGen htPage == 
  n :=
    $bcParseOnly => PARSE_-INTEGER htpLabelInputString(htPage, 'n)
    objValUnwrap htpLabelSpadValue(htPage, 'n)
  fnu := htpLabelInputString(htPage,'fnu)
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  uors := htpButtonValue(htPage,'scale)
  scale := 
    uors = 'u => '"u"
    '"s"
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  prefix := STRCONC('"s18def(",fnu,",complex(",x,",",y,"),",STRINGIMAGE n)
  prefix := STRCONC(prefix,",_"",scale,"_", ",STRINGIMAGE ifail,")")
  linkGen prefix


s19aaf() ==
  page := htInitPage("S19AAF - Kelvin Function {\em ber x}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs19aaf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s19aaf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Kelvin function {\em ber x}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "1.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s19aaf")
  htShowPage()

s19abf() ==
  page := htInitPage("S19ABF - Kelvin Function {\em bei x}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs19abf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s19abf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Kelvin function {\em bei x}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.1" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s19abf")
  htShowPage()

s19acf() ==
  page := htInitPage("S19ACF - Kelvin Function {\em ker x}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs19acf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s19acf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Kelvin function {\em ker x}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x > 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.1" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s19acf")
  htShowPage()

s19adf() ==
  page := htInitPage("S19AAF - Kelvin Function {\em kei x}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs19adf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s19adf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Kelvin function {\em kei x}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x \inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.0" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s19adf")
  htShowPage()

s20acf() ==
  page := htInitPage("S20ACF - Fresnel Integral {\em S(x)}",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs20acf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s20acf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Fresnel Integral {\em S(x)}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s20acf")
  htShowPage()

s20adf() ==
  page := htInitPage("S20ADF - Fresnel Integral {\em C(x)}",nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs20adf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s20adf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the Fresnel Integral {\em C(x)}")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument x: ")
    (text . "\newline\tab{2} ")
    (bcStrings (9 "0.5" x F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 'sGen)
  htpSetProperty(page,'routine,"s20adf")
  htShowPage()

s21baf() ==
  htInitPage("S21BAF - Degenerate Symmetrised Elliptic Integral of 1st Kind \vspace{-28} \inputbitmap{\htbmdir{}/s21baf1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs21baf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s21baf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the elementary (degenerate symmetrised elliptic) ")
    (text . " integral \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s21baf.bitmap} ")
    (text . "\blankline ")
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\newline \menuitemstyle{}\tab{2} ")
    (text . "Enter the argument x \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\tab{32} \menuitemstyle{}\tab{34} ")
    (text . "Enter the argument y \notequal 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (10 "0.5" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "1.0" y F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's21bafGen)
  htShowPage()

s21bafGen htPage == 
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  linkGen STRCONC("s21baf(",x,'",",y,",",STRINGIMAGE ifail,'")")

s21bbf() ==
  htInitPage("S21BBF - Symmetrised Elliptic Integral of 1st Kind \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s21bbf1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs21bbf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s21bbf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the symmetrised elliptic integral of the first kind ")
    (text . "\space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s21bbf.bitmap} ")
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\newline \menuitemstyle{}\tab{2} ")
    (text . "Enter the argument x \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\tab{32} \menuitemstyle{}\tab{34} ")
    (text . "Enter the argument y \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (10 "0.5" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "1.0" y F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument z \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0; ")
    (text . "at most one of x,y and z may be equal to 0.0: \newline \tab{2}")
    (bcStrings (10 "1.5" z F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's21bbfGen)
  htShowPage()

s21bbfGen htPage == 
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  z := htpLabelInputString(htPage,'z)
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  linkGen STRCONC("s21bbf(",x,'",",y,",",z,",",STRINGIMAGE ifail,'")")

s21bcf() ==
  htInitPage("S21BCF - Symmetrised Elliptic Integral of 2nd Kind \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s21bcf1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs21bcf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s21bcf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the symmetrised elliptic integral of the second kind ")
    (text . "\space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s21bcf.bitmap} ")
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\newline \menuitemstyle{}\tab{2} ")
    (text . "Enter the argument x \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\tab{32} \menuitemstyle{}\tab{34} ")
    (text . "Enter the argument y \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (10 "0.5" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.5" y F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument z > 0.0; ")
    (text . "at most one of x, y and z may be equal to 0.0: \newline \tab{2}")
    (bcStrings (10 "1.0" z F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's21bcfGen)
  htShowPage()

s21bcfGen htPage == 
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  z := htpLabelInputString(htPage,'z)
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  linkGen STRCONC("s21bcf(",x,'",",y,",",z,",",STRINGIMAGE ifail,'")")

s21bdf() ==
  htInitPage("S21BDF - Symmetrised Elliptic Integral of 3rd Kind \space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s21bdf1.bitmap}", nil)
  htMakePage '(
    (domainConditions
       (isDomain F (Float)))
    (text . "\windowlink{Manual Page}{manpageXXs21bdf} for this routine ")
    (text . "\newline ")
    (text . "\lispwindowlink{Browser operation page}{(|oPageFrom| '|s21bdf| '|NagSpecialFunctionsPackage|)} for this routine")
    (text . "\newline \horizontalline ")
    (text . "\blankline ")
    (text . "Evaluates the symmetrised elliptic integral of the third kind ")
    (text . "\space{1} \vspace{-28} \inputbitmap{\htbmdir{}/s21bdf.bitmap} ")
    (text . "\newline ")
    (text . "\blankline ")
    (text . "\newline \menuitemstyle{}\tab{2} ")
    (text . "Enter the argument x \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\tab{32} \menuitemstyle{}\tab{34} ")
    (text . "Enter the argument y \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0: ")
    (text . "\newline\tab{2} ")
    (bcStrings (10 "0.5" x F))
    (text . "\tab{34} ")
    (bcStrings (10 "0.5" y F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument z \space{1}\inputbitmap{\htbmdir{}/great=.bitmap} 0.0; ")
    (text . "at most one of x, y and z may be equal to 0.0: \newline \tab{2}")
    (bcStrings (10 "0.5" z F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Enter the argument \rho \notequal 0.0: \newline \tab{2} ")
    (bcStrings (10 "2.0" r F))
    (text . "\blankline")
    (text . "\newline ")
    (text . "\menuitemstyle{}\tab{2}")
    (text . "Ifail value:")
    (radioButtons ifail
        ("" " -1, Print error messages" minusOne)
        ("" "  1, Suppress error messages" one)))
  htMakeDoneButton('"Continue", 's21bdfGen)
  htShowPage()

s21bdfGen htPage == 
  x := htpLabelInputString(htPage,'x)
  y := htpLabelInputString(htPage,'y)
  z := htpLabelInputString(htPage,'z)
  r := htpLabelInputString(htPage,'r)
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  linkGen STRCONC("s21bdf(",x,'",",y,",",z,",",r,",",STRINGIMAGE ifail,'")")

sGen htPage == 
  routine := htpProperty(htPage,'routine)
  x := htpLabelInputString(htPage,'x)
  error := htpButtonValue(htPage,'ifail)
  ifail := 
    error = 'one => 1
    -1
  linkGen STRCONC(routine,"(",x,'",",STRINGIMAGE ifail,'")")

