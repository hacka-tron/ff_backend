package com.basel.learn.ffbackend.service;

import com.basel.learn.ffbackend.api.model.Post;
import java.util.List;

public interface PostService {
    List<Post> getAllPostsByUser(Integer userId);

    void addPost(Integer userId, Post post);

    void updatePost(Integer id, Post post);

    void removePost(Post post);
}
