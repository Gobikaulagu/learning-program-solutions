package com.example.jwt_auth_demo.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Demo only: hardcoded user
        if ("user".equals(username)) {
            return new User("user", "{noop}password", new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
