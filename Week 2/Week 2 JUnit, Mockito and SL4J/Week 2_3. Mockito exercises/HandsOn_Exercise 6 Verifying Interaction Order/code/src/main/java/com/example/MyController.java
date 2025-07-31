package com.example;

public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    public void performSteps() {
        service.step1();
        service.step2();
        service.step3();
    }
}
