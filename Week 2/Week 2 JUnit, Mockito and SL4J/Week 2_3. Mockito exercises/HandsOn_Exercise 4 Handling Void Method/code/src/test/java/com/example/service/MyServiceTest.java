package com.example.service;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testProcess_ShouldCallNotifyUser() {
        MyService service = spy(new MyService());

        // Prevent real notifyUser() execution
        doNothing().when(service).notifyUser(anyString());

        // Trigger method
        service.process();

        // Verify interaction
        verify(service, times(1)).notifyUser("Processing started");
    }
}
