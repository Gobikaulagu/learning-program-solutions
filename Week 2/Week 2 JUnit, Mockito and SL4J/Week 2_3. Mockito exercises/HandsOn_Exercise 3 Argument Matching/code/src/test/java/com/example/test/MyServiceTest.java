package com.example.test;

import com.example.service.ExternalApi;
import com.example.service.MyService;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.handleData("mocked input");

        verify(mockApi).process(eq("mocked input"));
        verify(mockApi).process(anyString());
    }
}
