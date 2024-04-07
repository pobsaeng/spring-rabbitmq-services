//package com.rabbitmq.listener;
//
//import com.rabbitmq.config.RabbitMQConfig;
//import com.rabbitmq.entiry.Product;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductCreateListener {
//    @RabbitListener(queues = RabbitMQConfig.CREATE_QUEUE)
//    public void receiveCreateMessage(Product product) {
//        System.out.println("Received product creation message: " + product);
//    }
//}
//
