package com.receiver.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.receiver.config.RabbitMQConfig;
import com.receiver.model.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUpdateListener {
    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitMQConfig.UPDATE_QUEUE)
    public void receiveCreateMessage(Product product) {
        System.out.println("Received product update message: " + product);
    }
}
