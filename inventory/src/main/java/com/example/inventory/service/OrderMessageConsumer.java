package com.example.inventory.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageConsumer {
    @RabbitListener(queues = "orderQueue")
    public void receiveOrder(String message) {
        System.out.println(message);
    }
}
