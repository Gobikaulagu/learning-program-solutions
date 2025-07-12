package com.example.auth.controller;

import com.example.auth.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @GetMapping("/ping")
    public String ping() {
        return "Application is alive!";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        if ("gobika".equals(username) && "pass".equals(password)) {
            return JwtUtil.generateToken(username);
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, secured world!";
    }
}
