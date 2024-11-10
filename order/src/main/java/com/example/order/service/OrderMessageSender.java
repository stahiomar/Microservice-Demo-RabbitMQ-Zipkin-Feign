package com.example.order.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendOrderNotification(String message) {
        rabbitTemplate.convertAndSend("orderQueue", message);
    }
}
