package com.lrh.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BaristaHandleOrderListener {

    @Autowired
    private Waiter waiter;

    @StreamListener(Waiter.NEW_ORDER)
    public void handleOrder(String orderId) throws InterruptedException {
        log.info("receive create order messagee ,order id [{}]", orderId);
        Thread.sleep(1000);

        log.info("return back order message  [{}]",waiter.finishOrder().send(MessageBuilder.withPayload(orderId).build()));

    }
}
