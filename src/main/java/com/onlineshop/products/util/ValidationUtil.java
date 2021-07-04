package com.onlineshop.products.util;

public class ValidationUtil{

    public static boolean validSaleQuantity(Long quantity) {
        return quantity > 0L;
    }


    public static boolean validPrice(Double price) {
        return price > 0D;
    }

    public static boolean validId(String id) {
        String ids = "ABCDEFGHIJKLMNOPQRSTUVWXUZ";
        return ids.contains(id);
    }
}
