package com.source.model.dao;

import com.source.model.entity.User;

public interface UserDAO extends GenericDAO<User> {

//    Optional<User> getByLoginAndPassword(String login, String password);

    User findByUserName(String userName);


}
