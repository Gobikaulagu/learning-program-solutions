package com.cognizant.spring_learn_6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringLearn6Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearn6Application.class);

    public static void main(String[] args) {
        LOGGER.info("START main()");
        SpringApplication.run(SpringLearn6Application.class, args);
        displayCountries();
        LOGGER.info("END main()");
    }

    public static void displayCountries() {
        LOGGER.info("START displayCountries()");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        @SuppressWarnings("unchecked")
        List<Country> countries = (List<Country>) context.getBean("countryList");

        for (Country country : countries) {
            LOGGER.debug("Country : {}", country);
        }

        LOGGER.info("END displayCountries()");
    }
}
