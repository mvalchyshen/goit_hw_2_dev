package com.onlineshop.products.model;

import com.onlineshop.products.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public abstract class BaseEntityImpl implements BaseEntity<String > {
    private String id;
    private Double price;

    @Override
    public String getId() {
        return id;
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

    public BaseEntityImpl(String id, Double price) {
        this.id = id;
        this.price = price;
    }
}
