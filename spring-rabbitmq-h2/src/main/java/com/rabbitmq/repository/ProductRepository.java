package com.rabbitmq.repository;

import com.rabbitmq.entiry.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
