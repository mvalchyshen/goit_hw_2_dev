package com.onlineshop.products.controller;

import com.onlineshop.products.service.ProductService;
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

}
