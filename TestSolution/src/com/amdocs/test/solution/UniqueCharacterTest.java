package com.amdocs.test.solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueCharacterTest {

    private UniqueCharacter uniqueCharacter;

    @Before
    public void setUp() {
        uniqueCharacter = new UniqueCharacter();
    }

    @Test
    public void checkUniqueChar() {
        boolean output = uniqueCharacter.checkUniqueChar("abcd/-@!12 34");
        assertTrue(output);
    }

    @Test
    public void checkUniqueCharWithInvalidString() {
        boolean output = uniqueCharacter.checkUniqueChar("abcd/-@!12 3 4");
        assertFalse(output);
    }

    @Test
    public void checkUniqueCharWithNullString() {
        boolean output = uniqueCharacter.checkUniqueChar(null);
        assertFalse(output);
    }

}