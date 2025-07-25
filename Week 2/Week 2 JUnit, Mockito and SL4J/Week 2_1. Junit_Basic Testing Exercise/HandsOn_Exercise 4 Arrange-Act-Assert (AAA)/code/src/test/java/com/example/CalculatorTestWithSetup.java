package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorTestWithSetup {

    private Calculator calculator;

    // Runs before each test
    @Before
    public void setUp() {
        calculator = new Calculator(); // Arrange
        System.out.println("Before each test");
    }

    // Runs after each test
    @After
    public void tearDown() {
        System.out.println("After each test");
    }

    @Test
    public void testAddition() {
        int result = calculator.add(10, 20); // Act
        assertEquals(30, result);            // Assert
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(50, 20); // Act
        assertEquals(30, result);                // Assert
    }
}
