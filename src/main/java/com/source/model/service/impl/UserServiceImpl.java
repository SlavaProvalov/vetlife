package com.source.model.service.impl;

import com.source.model.dao.UserDAO;
import com.source.model.entity.User;
import com.source.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveOrUpdate(User item) {
        userDAO.saveOrUpdate(item);
    }

    @Override
    @Transactional
    public void delete(User item) {
        userDAO.delete(item);
    }

    @Override
    @Transactional
    public Optional<User> get(Class<User> item, int id) {
        return userDAO.get(item, id);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public Optional<User> getByLoginAndPassword(String login, String password) {
        return userDAO.getByLoginAndPassword(login, password);
    }
}
