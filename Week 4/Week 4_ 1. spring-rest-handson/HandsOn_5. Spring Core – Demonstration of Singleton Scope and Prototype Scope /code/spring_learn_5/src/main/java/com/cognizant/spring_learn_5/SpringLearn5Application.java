package com.cognizant.spring_learn_5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearn5Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearn5Application.class);

    public static void main(String[] args) {
        LOGGER.info("START main()");
        SpringApplication.run(SpringLearn5Application.class, args);
        displayCountry();
        LOGGER.info("END main()");
    }

    public static void displayCountry() {
        LOGGER.info("START displayCountry()");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country1 = context.getBean("country", Country.class);
        LOGGER.debug("First Country Object: {}", country1);

        Country country2 = context.getBean("country", Country.class);
        LOGGER.debug("Second Country Object: {}", country2);

        LOGGER.info("Are both objects same? : {}", country1 == country2);

        LOGGER.info("END displayCountry()");
    }
}
