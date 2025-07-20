package com.example.authdemo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecureController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<h3>Welcome to the Home Page! <a href='/oauth2/authorization/google'>Login with Google</a></h3>";
    }

    @GetMapping("/secure")
    @ResponseBody
    public String secure(@AuthenticationPrincipal OAuth2User principal) {
        return "<h2>Welcome, " + principal.getAttribute("name") + "!</h2>"
             + "<p>Email: " + principal.getAttribute("email") + "</p>";
    }
}
