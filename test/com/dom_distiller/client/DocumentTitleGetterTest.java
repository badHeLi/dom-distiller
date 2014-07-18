// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.dom_distiller.client;

import com.google.gwt.dom.client.Element;

public class DocumentTitleGetterTest extends DomDistillerTestCase {

    public void testEmptyStringWithoutRoot() {
        String title = DocumentTitleGetter.getDocumentTitle("", null);
        assertEquals("", title);
    }

    public void testEmptyStringWithTitlelessRoot() {
        Element root = TestUtil.createDiv(0);
        String title = DocumentTitleGetter.getDocumentTitle("", root);
        assertEquals("", title);
    }

    public void testEmptyStringWithTitledRoot() {
        Element root = TestUtil.createDiv(0);
        String titleString = "testing non-string document.title with a titled root";
        Element titleElem = TestUtil.createTitle(titleString);
        root.appendChild(titleElem);
        String title = DocumentTitleGetter.getDocumentTitle("", root);
        assertEquals(titleString, title);
    }

    public void testEmptyStringWithMultiTitledRoot() {
        Element root = TestUtil.createDiv(0);
        String titleString = "first testing non-string document.title with a titled root";
        Element titleElem1 = TestUtil.createTitle(titleString);
        Element titleElem2 = TestUtil.createTitle(
            "second testing non-string document.title with a titled root");
        root.appendChild(titleElem1);
        root.appendChild(titleElem2);
        String title = DocumentTitleGetter.getDocumentTitle("", root);
        assertEquals(titleString, title);
    }

    public void testEmptyStringWithHTMLTitledRoot() {
        Element root = TestUtil.createDiv(0);
        Element titleElem = TestUtil.createTitle(
                "<a href=\"http://htmledtitle.com\">testing non-string <br>document.title</a> with a <b>HTML</b>-titled <br>root");
        root.appendChild(titleElem);
        String title = DocumentTitleGetter.getDocumentTitle("", root);
        assertEquals("testing non-string document.title with a HTML-titled root", title);
    }

    public void test1Dash2ShortParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "before dash - after dash", null);
        assertEquals("before dash - after dash", title);
    }

    public void test1Dash2LongParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "part with 6 words before dash - part with 6 words after dash", null);
        assertEquals("part with 6 words before dash", title);
    }

    public void test1DashLongAndShortParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "part with 6 words before dash - after dash", null);
        assertEquals("part with 6 words before dash", title);
    }

    public void test1DashShortAndLongParts() {
        // TODO(kuan): if using RegExp.split, this fails with "ant test.prod".
        String title = DocumentTitleGetter.getDocumentTitle(
                "before dash - part with 6 words after dash", null);
        assertEquals("part with 6 words after dash", title);
    }

    public void test2DashesShortParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "before dash - after dash0 - after dash1", null);
        assertEquals("before dash - after dash0", title);
    }

    public void test2DashesShortAndLongParts() {
        // TODO(kuan): if using RegExp.split, this fails with "ant test.prod".
        String title = DocumentTitleGetter.getDocumentTitle(
                "before - - part with 6 words after dash", null);
        assertEquals("- part with 6 words after dash", title);
    }

    public void test1Bar2ShortParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "before bar | after bar", null);
        assertEquals("before bar | after bar", title);
    }

    public void test2ColonsShortParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "start : midway : end", null);
        assertEquals("start : midway : end", title);
    }

    public void test2ColonsShortAndLongParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "start : midway : part with 6 words at end", null);
        assertEquals("part with 6 words at end", title);
    }

    public void test2ColonsShortAndLongAndShortParts() {
        String title = DocumentTitleGetter.getDocumentTitle(
                "start : part with 6 words at midway : end", null);
        assertEquals("part with 6 words at midway : end", title);
    }

    public void testH1WithShortText() {
        Element root = TestUtil.createDiv(0);
        Element h1 = TestUtil.createHeading(1, "short heading");
        root.appendChild(h1);

        String title = DocumentTitleGetter.getDocumentTitle("short title", root);
        assertEquals("short title", title);
    }

    public void testH1WithLongText() {
        Element root = TestUtil.createDiv(0);
        Element h1 = TestUtil.createHeading(1, "long heading with 5 words");
        root.appendChild(h1);

        String title = DocumentTitleGetter.getDocumentTitle("short title", root);
        assertEquals("long heading with 5 words", title);
    }

    public void testMultiHeadingsWithLongText() {
        Element root = TestUtil.createDiv(0);
        Element h1 = TestUtil.createHeading(1, "long heading1 with 5 words");
        Element h2 = TestUtil.createHeading(2, "long heading2 with 5 words");
        root.appendChild(h1);
        root.appendChild(h2);

        String title = DocumentTitleGetter.getDocumentTitle("short title", root);
        assertEquals("long heading1 with 5 words", title);
    }

    public void testH1WithLongHTML() {
        Element root = TestUtil.createDiv(0);
        Element h1 = TestUtil.createHeading(1,
                "<a href=\"http://longheading.com\"><b>long heading</b></a> with <br>5 words");
        root.appendChild(h1);

        String title = DocumentTitleGetter.getDocumentTitle("short title", root);
        assertEquals("long heading with 5 words", title);
    }

    public void testShortTitleWithoutRoot() {
        String title = DocumentTitleGetter.getDocumentTitle("short title", null);
        assertEquals("short title", title);
    }

    public void testShortTitleWithoutH1() {
        Element root = TestUtil.createDiv(0);
        String title = DocumentTitleGetter.getDocumentTitle("short title", root);
        assertEquals("short title", title);
    }
}
