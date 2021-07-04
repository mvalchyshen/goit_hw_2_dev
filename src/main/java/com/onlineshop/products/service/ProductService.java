package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;

import java.util.Map;

public interface ProductService {

    Map<String, Product> getStorage();
    void saveAll(Map<String, Product> all);
    void addProduct(Product product);
    Product getById(String id);
    void removeProduct(Product product);
    void removeProductById(String id);

}
