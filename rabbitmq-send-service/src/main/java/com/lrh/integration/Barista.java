package com.lrh.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Barista {

    String NEW_ORDER = "newOrder";

    String FINISH_ORDER = "finishOrder";

    @Output(NEW_ORDER)
    MessageChannel newOrder();

    @Input(FINISH_ORDER)
    SubscribableChannel finishOrder();
}
