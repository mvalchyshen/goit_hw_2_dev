package com.onlineshop.products.repository;

import com.onlineshop.products.model.BaseEntity;

import java.util.*;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {
    public E get(ID id);

    public List<E> saveAll(Iterable<E> itrbl);

    public Collection<E> findAll();

    public void deleteAll();

    public void deleteById(ID id);

    public long count();

    public boolean existsById(ID id);

    public Optional<E> findById(ID id);

    public E save(E e);
}
