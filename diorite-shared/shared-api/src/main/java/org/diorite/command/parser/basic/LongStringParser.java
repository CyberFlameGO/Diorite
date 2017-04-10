/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017. Diorite (by Bartłomiej Mazur (aka GotoFinal))
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.diorite.command.parser.basic;

import org.diorite.command.parser.ArgumentParseResult;
import org.diorite.command.parser.ArgumentParseResultType;
import org.diorite.command.parser.ParserContext;
import org.diorite.command.parser.TypeParser;
import org.diorite.commons.function.predicate.CharPredicate;

/**
 * Parser of long strings, long string just take all available chars from parser context, so it must be last argument of command.
 */
public final class LongStringParser implements TypeParser<String>
{
    /**
     * Instance of long string parser.
     */
    public static final LongStringParser INSTANCE = new LongStringParser();

    private LongStringParser() {}

    @Override
    public ArgumentParseResult<String> parse(ParserContext context, CharPredicate endPredicate_)
    {
        CharPredicate endPredicate = c -> (c == END) || endPredicate_.test(c);
        StringBuilder result = new StringBuilder(64);
        while (context.hasNext())
        {
            result.append(context.next());
        }
        return ArgumentParseResultType.SUCCESS.of(result.toString());
    }

    @Override
    public boolean mustBeLast()
    {
        return true;
    }
}
