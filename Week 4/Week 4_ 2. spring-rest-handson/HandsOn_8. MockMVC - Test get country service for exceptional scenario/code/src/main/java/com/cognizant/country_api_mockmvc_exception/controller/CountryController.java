package com.cognizant.country_api_mockmvc_exception.controller;

import com.cognizant.country_api_mockmvc_exception.model.Country;
import com.cognizant.country_api_mockmvc_exception.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        return service.getCountry(code);
    }
}
