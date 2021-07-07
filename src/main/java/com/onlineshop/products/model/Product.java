package com.onlineshop.products.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


public class Product extends BaseEntityImpl {


    private Double salePrice;
    private Long saleQuantity;



    public Product(String id, Double price, Long saleQuantity, Double salePrice) {
        super(id, price);
        this.salePrice = salePrice;
        this.saleQuantity = saleQuantity;
    }

    public Product(String id, Double price) {
        super(id, price);
    }

    @Override
    public String getId() {
        return super.getId();
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

    public Double pricePerEach(Long quantity) {
        Objects.requireNonNull(quantity);
        if (saleQuantity != null && quantity >= saleQuantity) {
             return quantity / saleQuantity * salePrice + (quantity % saleQuantity) * salePrice;
        } else {
            return super.getPrice() * quantity;
        }
    }

    public void setSaleQuantity(Long saleQuantity) {
        this.saleQuantity = saleQuantity;
    }


}
