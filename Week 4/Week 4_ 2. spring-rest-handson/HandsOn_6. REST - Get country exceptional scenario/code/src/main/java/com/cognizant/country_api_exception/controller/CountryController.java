package com.cognizant.country_api_exception.controller;

import com.cognizant.country_api_exception.model.Country;
import com.cognizant.country_api_exception.service.CountryService;
import com.cognizant.country_api_exception.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return countryService.getCountry(code);
    }
}
