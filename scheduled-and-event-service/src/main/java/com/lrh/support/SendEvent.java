package com.lrh.support;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class SendEvent extends ApplicationEvent {

    private String sender;

    public SendEvent(String sender) {
        super(sender);
        this.sender = sender;
    }




}
