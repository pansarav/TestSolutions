package com.amdocs.test.solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringRotationTest {

    private StringRotation stringRotation;

    @Before
    public void setUp() {
        stringRotation = new StringRotation();
    }

    @Test
    public void findRotation() {
        int rotation = stringRotation.findRotation("coffee", "eecoff");
        assertEquals(2, rotation);
    }

    @Test
    public void findRotationWithSameString() {
        int rotation = stringRotation.findRotation("coffee", "coffee");
        assertEquals(0, rotation);
    }

    @Test
    public void findRotationWithDifferentCaseSameString() {
        int rotation = stringRotation.findRotation("coffee", "Coffee");
        assertEquals(-1, rotation);
    }

    @Test
    public void findRotationWithDifferentLength() {
        int rotation = stringRotation.findRotation("coffee", "eecoffe");
        assertEquals(-1, rotation);
    }

    @Test
    public void findRotationWithDifferentStringSameLength() {
        int rotation = stringRotation.findRotation("coffee", "eccoff");
        assertEquals(-1, rotation);
    }

    @Test
    public void findRotationWithNull() {
        int rotation = stringRotation.findRotation(null, null);
        assertEquals(-1, rotation);
    }

    @Test
    public void findRotationWithEmptyString() {
        int rotation = stringRotation.findRotation("", "eccoff");
        assertEquals(-1, rotation);
    }
}