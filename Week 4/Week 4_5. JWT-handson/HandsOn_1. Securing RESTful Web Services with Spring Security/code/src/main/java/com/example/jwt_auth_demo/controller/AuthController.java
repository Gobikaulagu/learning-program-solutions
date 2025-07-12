package com.example.jwt_auth_demo.controller;

import com.example.jwt_auth_demo.model.AuthRequest;
import com.example.jwt_auth_demo.model.AuthResponse;
import com.example.jwt_auth_demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private com.example.jwt_auth_demo.service.CustomUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public AuthResponse createToken(@RequestBody AuthRequest request) throws Exception {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new AuthResponse(jwt);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, this is a secured endpoint!";
    }
}
