package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;
import com.onlineshop.products.repository.BaseRepository;
import com.onlineshop.products.repository.ProductStorage;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    BaseRepository<Product, String> repository = new ProductStorage();
    {
        repository.save(new Product("A", 1.25, 3l, 3.0));
        repository.save(new Product("B", 4.25));
        repository.save(new Product("C", 1.0, 6l, 5.0));
        repository.save(new Product("D", 0.75));
    }
    @Override
    public Double calculateTotalPrice(String bucket) {
        Objects.requireNonNull(bucket);
        Map<Product, Long> productsQuantity = getProductsQuantity(bucket);
        return productsQuantity.entrySet().stream()
                .mapToDouble(entry -> repository.findById(entry.getKey().getId()).get().pricePerEach(entry.getValue()))
                .sum();
    }

    private Map<Product, Long> getProductsQuantity(String products) {
        return products.chars()
                .filter(Character::isAlphabetic)
                .filter(x -> repository.existsById(String.valueOf((char) x).toUpperCase(Locale.ROOT)))
                .mapToObj(x -> repository.get(String.valueOf((char) x).toUpperCase(Locale.ROOT)))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
}
