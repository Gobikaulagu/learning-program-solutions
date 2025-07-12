package com.cognizant.spring_learn_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearn3Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearn3Application.class);

    public static void main(String[] args) {
        LOGGER.info("START - main()");
        SpringApplication.run(SpringLearn3Application.class, args);
        displayDate();
        LOGGER.info("END - main()");
    }

    public static void displayDate() {
        LOGGER.info("START - displayDate()");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Date parsing failed", e);
        }

        LOGGER.info("END - displayDate()");
    }
}
