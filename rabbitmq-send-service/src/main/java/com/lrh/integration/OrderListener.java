package com.lrh.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

    @StreamListener(Barista.FINISH_ORDER)
//    @SendTo
    public void listenerFinishOrder(String id) {
        log.info("We've finished an order [{}].", id);
    }
}
