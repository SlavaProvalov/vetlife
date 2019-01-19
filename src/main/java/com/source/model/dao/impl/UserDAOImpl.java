package com.source.model.dao.impl;

import com.source.model.dao.UserDAO;
import com.source.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(User item) {
        saveOrUpdate(sessionFactory, item);
    }

    @Override
    public void save(User item) {
        save(sessionFactory, item);
    }


    @Override
    public void delete(User item) {
        delete(sessionFactory, item);
    }

    @Override
    public Optional<User> get(Class<User> item, int id) {

        return (get(sessionFactory, item, id));
    }

    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from User ", User.class).getResultList();
    }

    @Override
    public User findByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User where login=:uName", User.class);
        query.setParameter("uName", userName);
        User user;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }
}
