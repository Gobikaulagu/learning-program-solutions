package com.example.controller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // Simulate "not found"
        throw new NoSuchElementException("User not found with ID: " + id);
    }
}
