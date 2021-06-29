package com.onlineshop.products.repository;

import com.onlineshop.products.model.BaseEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BaseRepositoryImpl<E extends BaseEntity<ID>, ID> implements BaseRepository<E, ID>{
    private final Map<ID, E> repository = new ConcurrentHashMap<>();

    @Override
    public E get(ID id) {
        return findById(id).map(e -> e)
                .orElseThrow(() -> new RuntimeException("Entity with " + id + " not exists"));
    }

    @Override
    public List<E> saveAll(Iterable<E> itrbl) {
        final List<E> result = new ArrayList<>();
        if (itrbl == null) return result;
        for (E e: itrbl) {
            result.add(this.save(e));
        }
        return result;
    }

    @Override
    public Collection<E> findAll() {
        return repository.values();
    }

    @Override
    public void deleteAll() {
        repository.clear();
    }

    @Override
    public void deleteById(ID id) {
        if (id != null) {
            repository.remove(id);
        }
    }

    @Override
    public long count() {
        return repository.size();
    }

    @Override
    public boolean existsById(ID id) {
        if (id == null) return false;
        return repository.containsKey(id);
    }

    @Override
    public Optional<E> findById(ID id) {
        if (id == null) return Optional.empty();
        return repository.containsKey(id) ?Optional.of(repository.get(id)) : Optional.empty();
    }

    @Override
    public E save(E e) {
        if (e == null) throw new RuntimeException("Value is null");
        else return repository.put(e.getId(), e);
    }
}
