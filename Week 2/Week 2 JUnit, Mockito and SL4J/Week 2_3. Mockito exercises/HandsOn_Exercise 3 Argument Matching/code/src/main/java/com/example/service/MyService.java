package com.example.service;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void handleData(String data) {
        api.process(data);
    }
}
