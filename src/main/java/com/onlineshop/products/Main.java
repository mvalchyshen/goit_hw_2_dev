package com.onlineshop.products;

import com.onlineshop.products.service.ProductService;
import com.onlineshop.products.service.ProductServiceImpl;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        System.out.println(productService.calculateTotalPrice(" "));
    }
}
