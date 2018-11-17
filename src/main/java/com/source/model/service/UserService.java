package com.source.model.service;

import com.source.model.entity.User;

import java.util.Optional;

public interface UserService extends GenericService<User> {

    Optional<User> getByLoginAndPassword(String login, String password);
}
