package com.fod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RentalApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RentalApplication.class, args);

    }
}
