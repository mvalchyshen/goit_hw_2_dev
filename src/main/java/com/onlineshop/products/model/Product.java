package com.onlineshop.products.model;

import com.onlineshop.products.util.ValidationUtil;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    public void setPrice(double price) {
        if (ValidationUtil.validPrice(price)) {
            this.price = price;
        } else {
            throw new RuntimeException("Price is less than 0");
        }
    }
    public void setSaleQuantity(long saleQuantity) {
        if (ValidationUtil.validSaleQuantity(saleQuantity)) {
            this.saleQuantity = saleQuantity;
        } else {
            throw new RuntimeException("Quantity is less than 0");
        }
    }

    public void setSalePrice(double salePrice) {
        if (ValidationUtil.validPrice(salePrice)) {
            this.salePrice = salePrice;
        } else {
            throw new RuntimeException("Price is less then 0");
        }
    }

    public void setId(String id) {
        if (ValidationUtil.validId(id)) {
            this.id = id;
        } else {
            throw new RuntimeException("ID is invalid");
        }
    }


}
