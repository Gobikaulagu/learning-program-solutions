package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "0, 5, 0",
        "-2, 4, -8",
        "-3, -6, 18"
    })
    void testMultiply(int a, int b, int expected) {
        int result = mathUtils.multiply(a, b);
        assertEquals(expected, result, () -> a + " * " + b + " should equal " + expected);
    }
}
