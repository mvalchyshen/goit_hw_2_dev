package com.onlineshop.products.repository;

import com.onlineshop.products.model.Product;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ProductStorage implements BaseRepository<Product, String> {
    private final ConcurrentHashMap<String, Product> repository = new ConcurrentHashMap<>();


    @Override
    public Optional<Product> findById(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return repository.containsKey(id) ? Optional.of(repository.get(id)) : Optional.empty();
    }

    @Override
    public Product get(String id) {
        return findById(id).map(e -> e).orElseThrow(()-> new RuntimeException("Entity with id " + id + " not found"));
    }

    @Override
    public Product save(Product product) {
        if (product == null) throw new RuntimeException("It's impossible to save an entity with a value 'null'");
        else return repository.put(product.getId(), product);
    }

    @Override
    public boolean existsById(String id) {
        if (id==null) return false;
        return repository.containsKey(id);
    }
}
