package com.example.mallportal.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderTimeOutCancelTask {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    @Scheduled(cron = "0/10 * * * * *")
    private void cancelTimeOutOrder() {
        //LOGGER.debug("Spring Task Test");
        System.out.println("Spring Task Test");
    }
}
