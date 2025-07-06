package com.example.order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(2)
    void testB() {
        System.out.println("Executing testB");
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Executing testA");
    }

    @Test
    @Order(3)
    void testC() {
        System.out.println("Executing testC");
    }
}
