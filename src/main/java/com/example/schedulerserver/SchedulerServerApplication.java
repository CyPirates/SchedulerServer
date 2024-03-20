package com.example.schedulerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SchedulerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchedulerServerApplication.class, args);
    }
}
