package com.onlineshop.products.controller;

import com.onlineshop.products.model.Product;
import com.onlineshop.products.service.ProductService;
import com.onlineshop.products.service.ProductServiceImpl;
import com.onlineshop.products.view.View;
import com.onlineshop.products.view.ViewImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProductShop {

    private final ProductService productService;
    private final View view;

    public ProductShop() {
        this.productService = ProductService.of();
        this.view = View.of();
    }

    public void startShop() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void main(String[] args) {
        ProductServiceImpl products = new ProductServiceImpl();
        Product a = products.createNewProduct("A", 1.25, 3l, 3.0);
        Product b = products.createNewProduct("B", 4.25);
        Product c = products.createNewProduct("C", 1.0, 6l, 5.0);
        Product d = products.createNewProduct("D", 0.75);
        products.saveProducts(a,b,c,d);
        System.out.println(products.calculateTotalCost("ABCDABA"));
    }

}
