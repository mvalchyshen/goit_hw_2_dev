package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;

public interface ProductService {
    Product createNewProduct(String id, Double price, int saleQuantity, Double salePrice);
    void saveProduct(Product product);
    Double calculateTotalCost(String products);
    static ProductService of() {
        return new ProductServiceImpl();
    }
}
