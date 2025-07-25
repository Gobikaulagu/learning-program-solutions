package com.cognizant.country_api_exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")  // Load bean config from XML
public class CountryApiExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(CountryApiExceptionApplication.class, args);
    }
}
