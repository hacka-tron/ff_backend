package com.basel.learn.ffbackend.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.basel.learn.ffbackend.api.model.Post;
import com.basel.learn.ffbackend.api.model.User;
import com.basel.learn.ffbackend.service.PostService;
import com.basel.learn.ffbackend.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public String postMethodName(@RequestBody User user) {
        userService.addUser(user);

        return "Successfully added user!";
    }


    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getUserPosts(@PathVariable Integer userId) {
        return postService.getAllPostsByUser(userId);
    }

    @PostMapping("/{userId}/posts/add")
    public String addPost(@PathVariable Integer userId, @RequestBody Post post) {
        postService.addPost(userId, post);
        return "Successfully added Post!";
    }

}
