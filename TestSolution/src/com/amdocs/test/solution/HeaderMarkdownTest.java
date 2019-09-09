package com.amdocs.test.solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HeaderMarkdownTest {

    private HeaderMarkdown headerMarkdown;

    @Before
    public void setUp() {
        headerMarkdown = new HeaderMarkdown();
    }

    @Test
    public void parseString() {
        String outputString = headerMarkdown.parseString("### Header ");
        assertEquals("<h3>Header</h3>", outputString);
    }

    @Test
    public void parseStringWithNull() {
        String outputString = headerMarkdown.parseString(null);
        assertNull(outputString);
    }

    @Test
    public void parseStringWithEmpty() {
        String outputString = headerMarkdown.parseString("");
        assertEquals("", outputString);
    }

    @Test
    public void parseStringWithInvalidString() {
        String outputString = headerMarkdown.parseString("#Header");
        assertEquals("#Header", outputString);
    }
}