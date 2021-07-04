package com.onlineshop.products.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Product implements BaseEntity<String>{

    private String id;
    private double price;
    private long saleQuantity;
    private double salePrice;

    public Product(String id, double price) {
        this.id = id;
        this.price = price;
    }


}
