package com.onlineshop.products.util;

public class ValidationUtil implements Validation<Long, Double> {
    @Override
    public boolean validSaleQuantity(Long quantity) {
        return quantity > 0L;
    }

    @Override
    public boolean validPrice(Double price) {
        return price > 0D;
    }
}
