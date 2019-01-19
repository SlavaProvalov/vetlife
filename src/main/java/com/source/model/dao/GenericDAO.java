package com.source.model.dao;


import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {

    void saveOrUpdate(T item);

    void save(T item);

    void delete(T item);

    Optional<T> get(Class<T> item, int id);

    List<T> getAll();

    default void saveOrUpdate(SessionFactory sessionFactory, T item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    default void delete(SessionFactory sessionFactory, T item) {
        sessionFactory.getCurrentSession().delete(item);
    }

    default Optional<T> get(SessionFactory sessionFactory, Class<T> item, int id) {
        return Optional.of(sessionFactory.getCurrentSession().get(item, id));
    }

    default void save(SessionFactory sessionFactory, T item) {
        sessionFactory.getCurrentSession().save(item);
    }

}