package com.receiver.model;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Product {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private String currency = "USD";
    private Integer quantity = 0;
    private String category;
    private String brand;
    private String color;
    private String size;
    private BigDecimal weight;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private String imageUrls;
    private String tags;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}