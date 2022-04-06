package com.example.mallportal.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"mall.order.cancel"})
public class CancelOrderReceiver {
    private final static Logger LOGGER = LoggerFactory.getLogger(CancelOrderSender.class);

    @RabbitHandler
    public void handle(Long orderId) {
        // TODO : 取消订单等一系列操作
        // LOGGER.info("process orderId : {}", orderId);
        System.out.printf("%d order cancel\n", orderId);
    }
}
