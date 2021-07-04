package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;
import com.onlineshop.products.repository.BaseRepository;
import com.onlineshop.products.repository.RepositoryFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    BaseRepository<Product, String> productRepository;

    public ProductServiceImpl() {
        this.productRepository = RepositoryFactory.of(Product.class);
    }

    @Override
    public Product createNewProduct(String id, Double price, int saleQuantity, Double salePrice) {
        return new Product(id,price,saleQuantity,salePrice);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    @Override
    public Double calculateTotalCost(String products) {
        Double totalCost = 0.0;
        Map<Product, Long> map = products.chars()
                .filter(Character::isAlphabetic)
                .mapToObj(x -> productRepository.get(String.valueOf((char) x).toUpperCase(Locale.ROOT)))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (Map.Entry<Product, Long> entry:map.entrySet()) {
            if (entry.getKey().getSaleQuantity() <= entry.getValue()) {
                totalCost += entry.getKey().getSalePrice();
            } else {
                totalCost += entry.getKey().getPrice();
            }
        }
        return totalCost;
    }
}
