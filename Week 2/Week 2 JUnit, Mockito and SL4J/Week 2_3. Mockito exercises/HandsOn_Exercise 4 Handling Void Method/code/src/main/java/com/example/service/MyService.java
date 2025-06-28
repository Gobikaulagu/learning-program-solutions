package com.example.service;

public class MyService {
    public void notifyUser(String message) {
        System.out.println("Notification sent: " + message);
    }

    public void process() {
        notifyUser("Processing started");
    }
}
