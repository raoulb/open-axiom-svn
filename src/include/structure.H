// Copyright (C) 2013, Gabriel Dos Reis.
// All rights reserved.
// Written by Gabriel Dos Reis.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     - Redistributions of source code must retain the above copyright
//       notice, this list of conditions and the following disclaimer.
//
//     - Redistributions in binary form must reproduce the above copyright
//       notice, this list of conditions and the following disclaimer in
//       the documentation and/or other materials provided with the
//       distribution.
//
//     - Neither the name of OpenAxiom, nor the names of its contributors may
//       be used to endorse or promote products derived from this software
//       without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
// IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
// PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
// OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
// PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
// LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
// NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

#ifndef OPENAXIOM_STRUCTURE_included
#define OPENAXIOM_STRUCTURE_included

namespace OpenAxiom {
   // -- helper classes for structural abstractions --
   namespace structure {
      // unary structures
      template<typename T>
      struct unary {
         explicit constexpr unary(const T& t) : arg(t) { };
         constexpr const T& operand() const { return arg; }
      private:
         const T arg;
      };

      // binary structures
      template<typename T, typename U = T>
      struct binary {
         constexpr binary(const T& t, const U& u) : arg0(t), arg1(u) { };
         constexpr const T& first() const { return arg0; }
         constexpr const U& second() const { return arg1; }
      private:
         const T arg0;
         const U arg1;
      };

      // ternary structures
      template<typename T, typename U = T, typename V = U>
      struct ternary {
         constexpr ternary(const T& t, const U& u, const V& v)
               : arg0(t), arg1(u), arg2(v) { }
         constexpr const T& first() const { return arg0; }
         constexpr const U& second() const { return arg1; }
         constexpr const V& third() const { return arg2; }
      private:
         const T arg0;
         const U arg1;
         const V arg2;
      };
   }
}

#endif  // OPENAXIOM_STRUCTURE_included
