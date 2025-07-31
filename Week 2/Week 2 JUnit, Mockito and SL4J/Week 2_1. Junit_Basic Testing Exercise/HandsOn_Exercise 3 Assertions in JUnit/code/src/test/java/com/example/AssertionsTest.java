package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Equals
        assertEquals(5, 2 + 3);

        // True
        assertTrue(5 > 3);

        // False
        assertFalse(5 < 3);

        // Null
        assertNull(null);

        // Not Null
        assertNotNull(new Object());
    }
}
