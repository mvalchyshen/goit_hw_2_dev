package com.onlineshop.products.model;

import java.util.Objects;


public class Product implements BaseEntity<String> {

    private String id;
    private Double price;
    private Long saleQuantity;
    private Double salePrice;

    public Double pricePerEach(Long quantity) {
        Objects.requireNonNull(quantity);
        if (saleQuantity != null && quantity >= saleQuantity) {
             return quantity / saleQuantity * salePrice + (quantity % saleQuantity) * salePrice;
        } else {
            return price * quantity;
        }
    }


    @Override
    public String getId() {
        return id;
    }

    public Product(String id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Product(String id, Double price, Long saleQuantity, Double salePrice) {
        this.id = id;
        this.price = price;
        this.salePrice = salePrice;
        this.saleQuantity = saleQuantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Long getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Long saleQuantity) {
        this.saleQuantity = saleQuantity;
    }
}
