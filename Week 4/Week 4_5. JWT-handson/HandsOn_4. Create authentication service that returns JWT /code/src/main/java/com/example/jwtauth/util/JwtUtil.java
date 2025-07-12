package com.example.jwtauth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final Key SECRET_KEY = Keys.hmacShaKeyFor("ThisIsASecretKeyForJwtTokenGeneration12345".getBytes());

    public static String generateToken(String username) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 10 * 60 * 1000)) // 10 minutes
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
}
