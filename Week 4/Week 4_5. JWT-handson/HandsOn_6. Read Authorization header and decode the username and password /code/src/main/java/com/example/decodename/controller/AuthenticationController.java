package com.example.decodename.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/authenticate")
    public String authenticate(@RequestHeader("Authorization") String authHeader) {
        String user = getUser(authHeader);
        LOGGER.info("Authenticated user: {}", user);
        return "Authenticated user: " + user;
    }
    @GetMapping("/ping")
    public String ping() {
        return "API is live!";
    }

    private String getUser(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String encodedCredentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
            String decodedString = new String(decodedBytes);  // example: "gobika:pass"
            LOGGER.debug("Decoded credentials: {}", decodedString);
            String username = decodedString.split(":")[0];
            return username;
        }
        return "Unknown";
    }
}
