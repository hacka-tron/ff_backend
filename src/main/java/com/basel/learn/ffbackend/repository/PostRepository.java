package com.basel.learn.ffbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basel.learn.ffbackend.api.model.Post;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);
}
