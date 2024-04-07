package com.basel.learn.ffbackend.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.basel.learn.ffbackend.api.model.Post;
import com.basel.learn.ffbackend.api.model.User;
import com.basel.learn.ffbackend.repository.PostRepository;
import com.basel.learn.ffbackend.repository.UserRepository;
import com.basel.learn.ffbackend.service.PostService;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPostsByUser(Integer userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public void addPost(Integer userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + userId));
        post.setUser(user);
        postRepository.save(post);

    }

    @Override
    public void updatePost(Integer id, Post post) {
        postRepository.save(post);
    }

    @Override
    public void removePost(Post post) {
        postRepository.delete(post);
    }
}
