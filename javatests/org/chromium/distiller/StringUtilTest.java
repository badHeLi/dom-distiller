// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.distiller;

import com.google.gwt.regexp.shared.RegExp;

public class StringUtilTest extends JsTestCase {
    public void testCountWords() {
        assertEquals(0, StringUtil.countWords(""));
        assertEquals(0, StringUtil.countWords("  -@# ';]"));
        assertEquals(1, StringUtil.countWords("word"));
        assertEquals(1, StringUtil.countWords("b'fore"));
        assertEquals(1, StringUtil.countWords(" _word.under_score_ "));
        assertEquals(2, StringUtil.countWords(" \ttwo\nwords"));
        assertEquals(2, StringUtil.countWords(" \ttwo @^@^&(@#$([][;;\nwords"));
        assertEquals(5, StringUtil.countWords("dør når på svært dårlig"));
        assertEquals(5, StringUtil.countWords("svært få dør av blåbærsyltetøy"));
    }

    public void testIsWhitespace() {
        assertTrue(StringUtil.isWhitespace(' '));
        assertTrue(StringUtil.isWhitespace('\t'));
        assertTrue(StringUtil.isWhitespace('\n'));
        assertTrue(StringUtil.isWhitespace('\u00a0'));
        assertFalse(StringUtil.isWhitespace('a'));
        assertFalse(StringUtil.isWhitespace('$'));
        assertFalse(StringUtil.isWhitespace('_'));
        assertFalse(StringUtil.isWhitespace('\u0460'));
    }

    public void testIsStringAllWhitespace() {
        assertTrue(StringUtil.isStringAllWhitespace(""));
        assertTrue(StringUtil.isStringAllWhitespace(" \t\r\n"));
        assertTrue(StringUtil.isStringAllWhitespace(" \u00a0     \t\t\t"));
        assertFalse(StringUtil.isStringAllWhitespace("a"));
        assertFalse(StringUtil.isStringAllWhitespace("     a  "));
        assertFalse(StringUtil.isStringAllWhitespace("\u00a0\u0460"));
        assertFalse(StringUtil.isStringAllWhitespace("\n\t_ "));
    }

    public void testFindAndReplace() {
        assertEquals("", StringUtil.findAndReplace("sdf", ".", ""));
        assertEquals("abc", StringUtil.findAndReplace(" a\tb  c ", "\\s", ""));
    }

    private RegExp toRegex(String s) {
        return RegExp.compile(StringUtil.regexEscape(s));
    }

    public void testRegexEscape() {
        assertTrue(toRegex(".*").test(".*"));
        assertFalse(toRegex(".*").test("test"));
        assertFalse(toRegex("[a-z]+").test("az"));
        assertFalse(toRegex("[a-z]+").test("[a-z]"));
        assertTrue(toRegex("[a-z]+").test("[a-z]+"));
        assertTrue(toRegex("\t\n\\\\d[").test("\t\n\\\\d["));
    }

    public void testIsDigit() {
        assertTrue(StringUtil.isDigit('1'));
        assertTrue(StringUtil.isDigit('0'));
        assertFalse(StringUtil.isDigit(' '));
        assertFalse(StringUtil.isDigit('a'));
        assertFalse(StringUtil.isDigit('$'));
        assertFalse(StringUtil.isDigit('_'));
        assertFalse(StringUtil.isDigit('\u0460'));
    }

    public void testIsStringAllDigits() {
        assertTrue(StringUtil.isStringAllDigits("0"));
        assertTrue(StringUtil.isStringAllDigits("018"));
        assertFalse(StringUtil.isStringAllDigits(""));
        assertFalse(StringUtil.isStringAllDigits("a0"));
        assertFalse(StringUtil.isStringAllDigits("0a"));
        assertFalse(StringUtil.isStringAllDigits(" "));
        assertFalse(StringUtil.isStringAllDigits(" 8"));
        assertFalse(StringUtil.isStringAllDigits("8 "));
        assertFalse(StringUtil.isStringAllDigits("'8_"));
        assertFalse(StringUtil.isStringAllDigits("\u00a0\u0460"));
    }

    public void testContainsDigit() {
        assertTrue(StringUtil.containsDigit("0"));
        assertTrue(StringUtil.containsDigit("018"));
        assertTrue(StringUtil.containsDigit("a0"));
        assertTrue(StringUtil.containsDigit("0a"));
        assertTrue(StringUtil.containsDigit(" 8"));
        assertTrue(StringUtil.containsDigit("8 "));
        assertTrue(StringUtil.containsDigit("'8_"));
        assertFalse(StringUtil.containsDigit(""));
        assertFalse(StringUtil.containsDigit(" "));
        assertFalse(StringUtil.containsDigit("\u00a0\u0460"));
        assertFalse(StringUtil.containsDigit("abc"));
        assertFalse(StringUtil.containsDigit("$"));
        assertFalse(StringUtil.containsDigit("_"));
    }

    public void testToNumber() {
        assertEquals(0, StringUtil.toNumber("0"));
        assertEquals(18, StringUtil.toNumber("018"));
        assertEquals(-1, StringUtil.toNumber("a0"));
        assertEquals(-1, StringUtil.toNumber("0a"));
        assertEquals(-1, StringUtil.toNumber(" 8"));
        assertEquals(-1, StringUtil.toNumber("8 "));
        assertEquals(-1, StringUtil.toNumber("'8_"));
        assertEquals(-1, StringUtil.toNumber(""));
        assertEquals(-1, StringUtil.toNumber(" "));
        assertEquals(-1, StringUtil.toNumber("\u00a0\u0460"));
        assertEquals(-1, StringUtil.toNumber("abc"));
        assertEquals(-1, StringUtil.toNumber("$"));
        assertEquals(-1, StringUtil.toNumber("_"));
    }

}
