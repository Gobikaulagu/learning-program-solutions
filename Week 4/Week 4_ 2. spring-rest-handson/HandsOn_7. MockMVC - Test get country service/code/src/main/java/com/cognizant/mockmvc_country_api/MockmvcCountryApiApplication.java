package com.cognizant.mockmvc_country_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
public class MockmvcCountryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockmvcCountryApiApplication.class, args);
    }
}
