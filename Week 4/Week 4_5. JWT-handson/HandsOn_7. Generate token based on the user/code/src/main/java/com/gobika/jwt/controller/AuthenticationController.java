package com.gobika.jwt.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestParam String username) {
        Map<String, String> response = new HashMap<>();

        if (username != null && !username.trim().isEmpty()) {
            String token = generateJwt(username);
            response.put("token", token);
        } else {
            response.put("error", "Invalid user");
        }

        return response;
    }

    private String generateJwt(String username) {
        // Key must be at least 256 bits for HS256
        Key key = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey12".getBytes()); // 32 characters

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 minutes
                .signWith(key)
                .compact();
    }
}
