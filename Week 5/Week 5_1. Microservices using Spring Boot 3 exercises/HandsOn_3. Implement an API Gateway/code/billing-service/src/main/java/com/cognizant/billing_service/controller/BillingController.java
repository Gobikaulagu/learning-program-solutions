package com.cognizant.billing_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BillingController {

    @GetMapping("/pay")
    public String billingInfo() {
        return "Hello from Billing Service!";
    }
}

