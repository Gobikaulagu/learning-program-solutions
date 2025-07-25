package com.example.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 10, 100})
    void testIsEven_withEvenNumbers(int number) {
        MathUtils mathUtils = new MathUtils();
        assertTrue(mathUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEven_withOddNumbers(int number) {
        MathUtils mathUtils = new MathUtils();
        assertFalse(mathUtils.isEven(number));
    }
}
