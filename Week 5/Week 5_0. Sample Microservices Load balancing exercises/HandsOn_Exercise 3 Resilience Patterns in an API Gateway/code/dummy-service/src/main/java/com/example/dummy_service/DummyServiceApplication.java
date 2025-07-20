package com.example.dummy_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@SpringBootApplication
@RestController
public class DummyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyServiceApplication.class, args);
    }

    @GetMapping("/dummy")
    @CircuitBreaker(name = "dummyService", fallbackMethod = "fallbackResponse")
    public String fakeService() {
        throw new RuntimeException("Service down!"); // Simulate failure
    }

    public String fallbackResponse(Exception ex) {
        return "Dummy service is temporarily unavailable. Please try again later.";
    }
}
