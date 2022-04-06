package com.example.mallportal.controller;

import com.example.mallportal.component.CancelOrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/portal")
public class TestController {
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @GetMapping("/test")
    public void test(@RequestParam("orderId") Long orderId,
                     @RequestParam("delayTimes") Long delayTimes) {
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
