package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;

public interface ProductService {
    Product createNewProduct(String id, Double price, Long saleQuantity, Double salePrice);
    Product createNewProduct(String id, Double price);
    void saveProduct(Product product);
    Product getProduct(Product product);
    Product getProductById(String id);
    void removeProduct(Product product);
    void removeProductById(String id);
    Double calculateTotalCost(String products);
    static ProductService of() {
        return new ProductServiceImpl();
    }
}
