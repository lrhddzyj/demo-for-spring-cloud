package com.lrh;

import com.lrh.integration.Waiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Waiter.class)
public class RabbitmqBaristaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqBaristaServiceApplication.class, args);
    }

}
