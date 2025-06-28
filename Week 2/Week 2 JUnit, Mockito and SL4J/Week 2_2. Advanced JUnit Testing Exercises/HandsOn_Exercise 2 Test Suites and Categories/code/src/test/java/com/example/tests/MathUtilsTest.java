package com.example.tests;

import com.example.utils.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {

    @Test
    void testAddition() {
        MathUtils math = new MathUtils();
        assertEquals(5, math.add(2, 3));
    }
}
