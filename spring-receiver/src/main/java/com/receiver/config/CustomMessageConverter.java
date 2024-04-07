package com.receiver.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import java.io.IOException;
import java.util.Objects;

public class CustomMessageConverter implements MessageConverter {
    private final ObjectMapper objectMapper;
    private final Class<?> targetClass;

    public CustomMessageConverter(ObjectMapper objectMapper, Class<?> targetClass) {
        this.objectMapper = Objects.requireNonNull(objectMapper, "ObjectMapper must not be null");
        this.targetClass = Objects.requireNonNull(targetClass, "Target class must not be null");
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        try {
            String jsonPayload = objectMapper.writeValueAsString(object);
            return new Message(jsonPayload.getBytes(), messageProperties);
        } catch (JsonProcessingException e) {
            throw new MessageConversionException("Error converting object to message", e);
        }
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        try {
            // Convert JSON string payload to target class object
            return objectMapper.readValue(message.getBody(), targetClass);
        } catch (IOException e) {
            throw new MessageConversionException("Error converting message to object", e);
        }
    }
}
