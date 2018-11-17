package com.source.model.dao.impl;

import com.source.model.dao.UserDAO;
import com.source.model.entity.User;
import org.hibernate.SessionFactory;
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
    public Optional<User> getByLoginAndPassword(String login, String password) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from User u where lower(u.login)=:log and u.password =:pass", User.class)
                .setParameter("log", login.toLowerCase())
                .setParameter("pass", password)
                .getResultList().stream().findFirst().orElse(null));
    }
}
