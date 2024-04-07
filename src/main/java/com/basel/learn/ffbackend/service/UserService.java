package com.basel.learn.ffbackend.service;

import java.util.List;

import com.basel.learn.ffbackend.api.model.User;

public interface UserService {
    User addUser(User user);

    List<User> getAllUsers();

    void removeUser(Integer id);

    void updateUser(Integer id, User user);
}
