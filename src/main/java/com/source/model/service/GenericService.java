package com.source.model.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    void saveOrUpdate(T item);

    void delete(T item);

    Optional<T> get(Class<T> item, int id);

    List<T> getAll();
}
