package com.lrh.controller;

import com.lrh.integration.Barista;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class CarController {


    @Autowired
    private Barista barista;

    @GetMapping("/send")
    public void sendMessage(){
        Message message = MessageBuilder.withPayload(UUID.randomUUID())
//                .setHeader("customer","customer")
                .build();

        log.info("send result {}",barista.newOrder().send(message));

    }

}
