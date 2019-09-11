package com.lrh.controller;


import com.lrh.support.SendEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class SendController implements ApplicationEventPublisherAware {

    public ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/send")
    public void addSend(){
        SendEvent sendEvent = new SendEvent(UUID.randomUUID().toString());
        applicationEventPublisher.publishEvent(sendEvent);
        log.info("send event publish!!");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


}
