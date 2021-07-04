package com.onlineshop.products.service;

import com.onlineshop.products.model.Product;

import java.rmi.MarshalledObject;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ProductService {

    private static final Map<String, Product> storage = new ConcurrentHashMap<>();

    static {
        Product a = new Product("A", 1.25D, 3, 3D);
        Product b = new Product("B", 4.25D);
        Product c = new Product("C", 1.00D, 5, 6D);
        Product d = new Product("D", 0.75D);

        storage.put(a.getId(), a);
        storage.put(b.getId(), b);
        storage.put(c.getId(), c);
        storage.put(d.getId(), d);
    }

    public Map<String, Product> getStorage() {
        return storage;
    }

    public void saveAll(Map<String, Product> products) {
        Objects.requireNonNull(products);
        storage.putAll(products);
    }

    public void save(Product product) {
        Objects.requireNonNull(product);
        storage.put(product.getId(), product);
    }

    public Product getById(String id) {
        Objects.requireNonNull(id);
        return storage.get(id);
    }

    public void removeProductById(String id) {
        Objects.requireNonNull(id);
        storage.remove(id);
    }

    public void removeProduct(Product product) {
        Objects.requireNonNull(product);
        removeProductById(product.getId());
    }

    public double calculateTotalCost(String products) {
        double totalCost = 0;
        if (!storage.isEmpty() && !products.isEmpty()) {

            Map<String, Long> collect = products.chars()
                    .mapToObj(o -> storage.get(String.valueOf((char) o).toUpperCase(Locale.ROOT)))
                    .collect(Collectors.groupingBy(Product::getId, Collectors.counting()));
            for (Map.Entry<String, Long> entry : collect.entrySet()) {
                if (entry.getValue() >= storage.get(entry.getKey()).getSaleQuantity()) {
                    totalCost += storage.get(entry.getKey()).getSalePrice();
                } else {
                    totalCost += storage.get(entry.getKey()).getPrice();
                }
            }
            return totalCost;
        }
        throw new RuntimeException("Set of Prducts or Storage is Empty");
    }


}
