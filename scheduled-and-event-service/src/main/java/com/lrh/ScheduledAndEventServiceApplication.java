package com.lrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledAndEventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledAndEventServiceApplication.class, args);
    }

}
