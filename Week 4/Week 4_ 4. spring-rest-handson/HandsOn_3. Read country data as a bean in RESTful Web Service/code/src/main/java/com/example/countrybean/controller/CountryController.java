package com.example.countrybean.controller;

import com.example.countrybean.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    Logger logger = LoggerFactory.getLogger(CountryController.class);

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        logger.info("Country Code: {}", country.getCode());
        logger.info("Country Name: {}", country.getName());
        return country;
    }
}
