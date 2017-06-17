package com.bjw.bloggit.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bjw.bloggit.domains.Post;
import com.bjw.bloggit.managers.IPostManager;

@RestController
@RequestMapping("/api/v1/post")
public class PostControllerV1 {

    @Autowired
    private IPostManager postManager;
    
    @RequestMapping(method = RequestMethod.GET)
    List<Post> getAllPosts() {
        return postManager.getAllPosts();
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    Post getPost(Long postId) {
        return postManager.getPostById(postId);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Post> getPostsByParams(
            @RequestParam(value = "startDate", required = false) Long startDate,
            @RequestParam(value = "endDate", required = false) Long endDate,
            @RequestParam(value = "author", required = false) String author) {
        if (startDate != null && endDate != null) {
            return Collections.emptyList();
        } else if (author != null) {
            return postManager.getPostsByAuthor(author);
        } else {
            return Collections.emptyList();
        }
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Post createPost(@RequestBody Post post) {
        return postManager.createPost(post);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
    Post updatePost(@PathVariable Long postId, @RequestBody Post post) {
        return postManager.updatePost(postId, post);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    Post deletePost(@PathVariable Long postId) {
        return postManager.deletePost(postId);
    }
    
}
