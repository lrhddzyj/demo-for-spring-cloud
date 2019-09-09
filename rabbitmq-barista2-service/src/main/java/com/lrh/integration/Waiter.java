package com.lrh.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Waiter {

    String NEW_ORDER = "newOrder";

    String FINISH_ORDER = "finishOrder";


    @Output(FINISH_ORDER)
    MessageChannel finishOrder();


    @Input(NEW_ORDER)
    SubscribableChannel newOrder();

}
