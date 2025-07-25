package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("START");

        getAllCountriesTest();
        testAddCountry();

        LOGGER.info("END");
    }

    private void getAllCountriesTest() {
        LOGGER.info("Start getAllCountriesTest");

        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }

        LOGGER.info("End getAllCountriesTest");
    }

    private void testAddCountry() {
        LOGGER.info("Start testAddCountry");

        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia");

        countryService.addCountry(country);

        try {
            Country result = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added Country: {}", result);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error fetching added country: {}", e.getMessage());
        }

        LOGGER.info("End testAddCountry");
    }
}
