package com.cognizant.ormupdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormupdate.exception.CountryNotFoundException;
import com.cognizant.ormupdate.service.CountryService;

@SpringBootApplication
public class OrmUpdateCountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmUpdateCountryApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmUpdateCountryApplication.class, args);
        countryService = context.getBean(CountryService.class);

        try {
            updateCountryTest();
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }

    private static void updateCountryTest() throws CountryNotFoundException {
        LOGGER.info("Start");
        countryService.updateCountry("US", "United States of America");
        LOGGER.info("End");
    }
}
