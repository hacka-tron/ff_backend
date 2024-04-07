package com.basel.learn.ffbackend.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.basel.learn.ffbackend.api.model.User;
import com.basel.learn.ffbackend.repository.UserRepository;
import com.basel.learn.ffbackend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Cacheable(value  = "users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(Integer id) {
        userRepository
                .findById(id).map(user -> userRepository.save(user))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository
                .findById(id).map(u -> {
                    user.setId(id);
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
    }
}
