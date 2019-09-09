package com.lrh.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

    @StreamListener(Barista.FINISH_ORDER)
    public void listenerFinishOrder(String id) {
        log.info("We've finished an order [{}].", id);
    }
}
