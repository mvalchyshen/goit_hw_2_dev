package com.onlineshop.products.model;

import lombok.Data;

@Data
public class Product implements BaseEntity<String>{

    private String id;
    private Long price;

    public Product(String id, Long price) {
        this.id = id;
        this.price = price;
    }
}
