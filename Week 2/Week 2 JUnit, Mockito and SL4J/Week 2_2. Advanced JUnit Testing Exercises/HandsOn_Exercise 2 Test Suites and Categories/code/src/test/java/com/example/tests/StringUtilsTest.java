package com.example.tests;

import com.example.utils.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @Test
    void testIsEmpty() {
        StringUtils util = new StringUtils();
        assertTrue(util.isEmpty("   "));
    }
}
