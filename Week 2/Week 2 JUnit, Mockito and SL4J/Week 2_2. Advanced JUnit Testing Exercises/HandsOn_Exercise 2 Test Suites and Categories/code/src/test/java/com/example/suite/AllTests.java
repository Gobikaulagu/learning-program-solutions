package com.example.suite;

import com.example.tests.MathUtilsTest;
import com.example.tests.StringUtilsTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    MathUtilsTest.class,
    StringUtilsTest.class
})
public class AllTests {
}
