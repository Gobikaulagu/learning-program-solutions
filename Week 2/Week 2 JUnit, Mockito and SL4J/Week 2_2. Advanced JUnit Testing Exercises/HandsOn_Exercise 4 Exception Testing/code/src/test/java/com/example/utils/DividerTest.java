package com.example.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DividerTest {

    @Test
    public void testValidDivision() {
        Divider d = new Divider();
        assertEquals(5, d.divide(10, 2));
    }

    @Test
    public void testDivideByZeroException() {
        Divider d = new Divider();
        assertThrows(ArithmeticException.class, () -> {
            d.divide(10, 0);
        });
    }
}
