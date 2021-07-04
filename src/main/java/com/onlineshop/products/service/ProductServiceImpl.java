package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;
import com.onlineshop.products.repository.BaseRepository;
import com.onlineshop.products.repository.RepositoryFactory;

import java.util.*;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    BaseRepository<Product, String> productRepository;

    public ProductServiceImpl() {
        this.productRepository = RepositoryFactory.of(Product.class);
    }

    @Override
    public Product createNewProduct(String id, Double price, Long saleQuantity, Double salePrice) {
        if (validPrice(price) && validPrice(salePrice) && validQuantity(saleQuantity)) {
            return new Product(id,price,saleQuantity,salePrice);
        }
        throw new RuntimeException("Price and Quantity must more or equal 0");

    }

    @Override
    public Product createNewProduct(String id, Double price) {
        if (validPrice(price)){
            return new Product(id, price);
        }
        throw new RuntimeException("Price must more or equal 0");
    }

    @Override
    public void saveProduct(Product product) {
        Objects.requireNonNull(product);
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Product product) {
        Objects.requireNonNull(product);
        return productRepository.get(product.getId());
    }

    @Override
    public Product getProductById(String id) {
        Objects.requireNonNull(id);
        return productRepository.get(id);
    }

    @Override
    public void removeProduct(Product product) {
        Objects.requireNonNull(product);
        removeProductById(product.getId());
    }

    @Override
    public void removeProductById(String id) {
        Objects.requireNonNull(id);
        productRepository.deleteById(id);
    }

    private boolean validQuantity(Long quantity) {
        return quantity > 0L;
    }

    private boolean validPrice(Double price) {
        return price >= 0D;
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
