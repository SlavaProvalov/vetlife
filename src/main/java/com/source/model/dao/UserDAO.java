package com.source.model.dao;

import com.source.model.entity.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {

    Optional<User> getByLoginAndPassword(String login, String password);


}
