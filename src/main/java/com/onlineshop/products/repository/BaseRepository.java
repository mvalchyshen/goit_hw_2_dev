package com.onlineshop.products.repository;

import com.onlineshop.products.model.BaseEntity;

import java.util.*;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    public Optional<E> findById(ID id);
    public E get(ID id);
    public E save(E e);
    public boolean existsById(ID id);
}
