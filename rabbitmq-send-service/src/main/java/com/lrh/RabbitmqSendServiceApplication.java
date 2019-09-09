package com.lrh;

import com.lrh.integration.Barista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(value = {Barista.class})
public class RabbitmqSendServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSendServiceApplication.class, args);
    }

}
