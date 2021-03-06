/*
  Copyright (C) 1991-2002, The Numerical Algorithms Group Ltd.
  All rights reserved.
  Copyright (C) 2007-2010, Gabriel Dos Reis.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without
  modification, are permitted provided that the following conditions are
  met:

      - Redistributions of source code must retain the above copyright
        notice, this list of conditions and the following disclaimer.

      - Redistributions in binary form must reproduce the above copyright
        notice, this list of conditions and the following disclaimer in
        the documentation and/or other materials provided with the
        distribution.

      - Neither the name of The Numerical Algorithms Group Ltd. nor the
        names of its contributors may be used to endorse or promote products
        derived from this software without specific prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

#include "openaxiom-c-macros.h"
#include "sockio.h"
#include "debug.h"
#include "halloc.h"
#include "extent.h"

/*
 * Here are structures needed for manipulating the item stack
 */
ItemStack *gTopOfItemStack = NULL;


void
push_item_stack(void)
{
    ItemStack *is = (ItemStack *) halloc(sizeof(ItemStack), "Item stack");

    is->indent = indent;
    is->item_indent = item_indent;
    is->next = gTopOfItemStack;
    is->in_item = gInItem;
    gTopOfItemStack = is;
    return;
}
void
clear_item_stack(void)
{
    ItemStack *is = gTopOfItemStack, *chuck;

    while (is != NULL) {
        chuck = is;
        is = is->next;
        free(chuck);
    }
    return;
}
void
pop_item_stack(void)
{
    ItemStack *chuck;

    if (gTopOfItemStack == NULL) {
        fprintf(stderr, "Tried to pop an empty item stack\n");
        return;
    }
    chuck = gTopOfItemStack;
    gTopOfItemStack = gTopOfItemStack->next;
    indent = chuck->indent;
    item_indent = chuck->item_indent;
    gInItem = chuck->in_item;
    free(chuck);
}

ItemStack *
copy_item_stack(void)
{
    ItemStack *stack = NULL;
    ItemStack *prev = NULL;
    ItemStack *trace = gTopOfItemStack;
    ItemStack *first = NULL;

    while (trace) {
        stack = (ItemStack *) halloc(sizeof(ItemStack), "Item stack");
        stack->indent = trace->indent;
        stack->item_indent = trace->item_indent;
        stack->in_item = gInItem;
        if (!first)
            first = stack;
        else
            prev->next = stack;
        prev = stack;
        trace = trace->next;
    }
    if (stack)
        stack->next = NULL;
    return first;
}

void
free_item_stack(ItemStack *is)
{
    ItemStack *junk = NULL;
    ItemStack *trace = is;

    while (trace) {
        junk = trace;
        trace = trace->next;
        free(junk);
    }
}
