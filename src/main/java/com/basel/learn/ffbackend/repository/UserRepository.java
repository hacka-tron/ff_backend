package com.basel.learn.ffbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basel.learn.ffbackend.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
