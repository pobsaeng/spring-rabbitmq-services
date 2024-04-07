package com.receiver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.receiver.model.Product;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    
    // Define exchange name
    public static final String PRODUCT_EXCHANGE = "product_exchange";
    
    // Define routing keys
    public static final String CREATE_ROUTING_KEY = "product.create";
    public static final String UPDATE_ROUTING_KEY = "product.update";
    public static final String DELETE_ROUTING_KEY = "product.delete";
    
    // Define queues
    public static final String CREATE_QUEUE = "create_queue";
    public static final String UPDATE_QUEUE = "update_queue";
    public static final String DELETE_QUEUE = "delete_queue";

    @Bean
    public DirectExchange productExchange() {
        return new DirectExchange(PRODUCT_EXCHANGE);
    }

    @Bean
    public Queue createQueue() {
        return new Queue(CREATE_QUEUE);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(UPDATE_QUEUE);
    }

    @Bean
    public Queue deleteQueue() {
        return new Queue(DELETE_QUEUE);
    }

    @Bean
    public Binding bindingCreate(DirectExchange productExchange, Queue createQueue) {
        return BindingBuilder.bind(createQueue).to(productExchange).with(CREATE_ROUTING_KEY);
    }

    @Bean
    public Binding bindingUpdate(DirectExchange productExchange, Queue updateQueue) {
        return BindingBuilder.bind(updateQueue).to(productExchange).with(UPDATE_ROUTING_KEY);
    }

    @Bean
    public Binding bindingDelete(DirectExchange productExchange, Queue deleteQueue) {
        return BindingBuilder.bind(deleteQueue).to(productExchange).with(DELETE_ROUTING_KEY);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public CustomMessageConverter customMessageConverter() {
        return new CustomMessageConverter(objectMapper, Product.class);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
