package com.example.jwtauth_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuth2Application {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuth2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(JwtAuth2Application.class, args);
        logger.info("Application Started");
    }
}
