package com.onlineshop.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements BaseEntity<String>{

    private String id;
    private Double price;
    private Long saleQuantity;
    private Double salePrice;

    public Product(String id, Double price) {
        this.id = id;
        this.price = price;
    }
}
