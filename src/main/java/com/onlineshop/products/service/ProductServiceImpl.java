package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;
import com.onlineshop.products.repository.BaseRepository;
import com.onlineshop.products.repository.RepositoryFactory;
import com.onlineshop.products.util.ValidationUtil;

import java.util.*;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    BaseRepository<Product, String> productRepository;

    public ProductServiceImpl() {
        this.productRepository = RepositoryFactory.of(Product.class);
    }

    @Override
    public Product createNewProduct(String id, Double price, Long saleQuantity, Double salePrice) {
        if (ValidationUtil.validPrice(price) && ValidationUtil.validPrice(salePrice)
                && ValidationUtil.validQuantity(saleQuantity) && ValidationUtil.validId(id)) {
            return new Product(id, price, saleQuantity, salePrice);
        }
        throw new RuntimeException("Price and Quantity must more or equal 0");

    }

    @Override
    public Product createNewProduct(String id, Double price) {
        if (ValidationUtil.validPrice(price) && ValidationUtil.validId(id)) {
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
    public void saveProducts(Product... products) {
        for (Product p : products) {
            Objects.requireNonNull(p);
            productRepository.save(p);
        }
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


    @Override
    public Double calculateTotalCost(String products) {
        double totalCost = 0.0;
        Map<Product, Long> productsQuantity = getProductsQuantity(products);
        totalCost = productsQuantity.entrySet().stream()
                .mapToDouble(entry -> productRepository.findById(entry.getKey().getId()).get().pricePerEach(entry.getValue()))
                .sum();
        return totalCost;
    }

    private Map<Product, Long> getProductsQuantity(String products) {
        return products.chars()
                .filter(Character::isAlphabetic)
                .filter(x -> productRepository.existsById(String.valueOf((char) x).toUpperCase(Locale.ROOT)))
                .mapToObj(x -> productRepository.get(String.valueOf((char) x).toUpperCase(Locale.ROOT)))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
}
