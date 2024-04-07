package com.receiver.listener;

import com.receiver.config.RabbitMQConfig;
import com.receiver.model.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductCreateListener {
    @RabbitListener(queues = RabbitMQConfig.CREATE_QUEUE)
    public void receiveCreateMessage(Product product) {
        System.out.println("Received product creation message: " + product);
    }
}

