package com.cognizant.spring_learn_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearn2Application {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(SpringLearn2Application.class, args);
        displayDate();
    }

    public static void displayDate() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        Date date = format.parse("31/12/2018");
        System.out.println("Parsed Date: " + date);
    }
}
