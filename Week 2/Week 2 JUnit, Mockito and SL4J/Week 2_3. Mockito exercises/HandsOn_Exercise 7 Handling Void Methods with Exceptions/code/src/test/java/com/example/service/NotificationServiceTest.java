package com.example.service;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void testSendEmail_throwsException() {
        NotificationService mockService = mock(NotificationService.class);

        // Stub the void method to throw exception
        doThrow(new RuntimeException("Email service failed"))
            .when(mockService).sendEmail("user@example.com");

        // Assert exception is thrown
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            mockService.sendEmail("user@example.com");
        });

        assertEquals("Email service failed", ex.getMessage());

        // Verify method was called
        verify(mockService).sendEmail("user@example.com");
    }
}
