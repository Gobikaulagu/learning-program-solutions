package com.cognizant.country_rest_service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestCountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestCountryApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(RestCountryApplication.class, args);
        LOGGER.info("END");
    }
}

