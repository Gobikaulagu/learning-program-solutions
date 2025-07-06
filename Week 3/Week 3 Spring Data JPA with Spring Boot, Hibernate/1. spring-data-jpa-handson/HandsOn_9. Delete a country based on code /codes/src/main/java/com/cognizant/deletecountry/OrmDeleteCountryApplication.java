package com.cognizant.deletecountry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.deletecountry.service.CountryService;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmDeleteCountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmDeleteCountryApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmDeleteCountryApplication.class, args);
        CountryService countryService = context.getBean(CountryService.class);
        deleteCountryTest(countryService);
    }

    private static void deleteCountryTest(CountryService service) {
        LOGGER.info("Start Delete Country Test");
        service.deleteCountry("ZZ"); // Code to delete Zootopia if added earlier
        LOGGER.info("Deleted Country with code 'ZZ'");
        LOGGER.info("End Delete Country Test");
    }
}
