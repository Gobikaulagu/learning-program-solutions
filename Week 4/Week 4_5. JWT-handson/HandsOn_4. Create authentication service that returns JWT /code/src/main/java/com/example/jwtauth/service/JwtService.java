package com.example.jwtauth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // Use a secure 256-bit key (can be loaded from application.properties)
    private static final Key key = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey12".getBytes()); // 32+ chars

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour validity
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
