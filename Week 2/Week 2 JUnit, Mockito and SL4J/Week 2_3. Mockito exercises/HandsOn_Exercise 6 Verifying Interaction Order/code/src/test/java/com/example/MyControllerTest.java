package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MyControllerTest {

    @Test
    void testMethodCallOrder() {
        // Create mock
        MyService mockService = mock(MyService.class);

        // Use the controller with the mock
        MyController controller = new MyController(mockService);

        // Call method
        controller.performSteps();

        // Verify call order
        InOrder inOrder = inOrder(mockService);
        inOrder.verify(mockService).step1();
        inOrder.verify(mockService).step2();
        inOrder.verify(mockService).step3();
    }
}
