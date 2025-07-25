package com.cognizant.customer_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/hello")
    public String helloCustomer() {
        return "Hello from Customer Service!";
    }
}

