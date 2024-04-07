package com.rabbitmq.controller;

import com.rabbitmq.entiry.Product;
import com.rabbitmq.service.ProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String productExchange = "product_exchange";
    private final String createRoutingKey = "product.create";
    private final String updateRoutingKey = "product.update";
    private final String deleteRoutingKey = "product.delete";

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        sendToRabbitMQ(createdProduct, createRoutingKey);
        return createdProduct;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if(updatedProduct != null) {
            sendToRabbitMQ(updatedProduct, updateRoutingKey);
        }
        return updatedProduct;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            sendToRabbitMQ(id, deleteRoutingKey);
        }
        return deleted;
    }

    private void sendToRabbitMQ(Object message, String routingKey) {
        rabbitTemplate.convertAndSend(productExchange, routingKey, message);
    }

//    public <T> void sendToRabbitMQ(T message, String routingKey) {
//        rabbitTemplate.convertAndSend(productExchange, routingKey, message);
//    }
}
