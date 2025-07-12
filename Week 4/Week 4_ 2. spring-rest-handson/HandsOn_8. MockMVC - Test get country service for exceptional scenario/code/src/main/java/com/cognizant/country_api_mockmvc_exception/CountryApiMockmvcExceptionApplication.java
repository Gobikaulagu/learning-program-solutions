package com.cognizant.country_api_mockmvc_exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
public class CountryApiMockmvcExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(CountryApiMockmvcExceptionApplication.class, args);
    }
}
