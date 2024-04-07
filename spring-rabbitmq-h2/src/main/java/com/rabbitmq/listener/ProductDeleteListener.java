//package com.rabbitmq.listener;
//
//import com.rabbitmq.config.RabbitMQConfig;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductDeleteListener {
//
//    @RabbitListener(queues = RabbitMQConfig.DELETE_QUEUE)
//    public void receiveDeleteMessage(Long productId) {
//        System.out.println("Received product deletion message for ID: " + productId);
//    }
//}
