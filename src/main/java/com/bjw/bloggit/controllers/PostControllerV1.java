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

import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.managers.IPostManager;
import com.bjw.bloggit.views.ViewPost;

@RestController
@RequestMapping("/api/v1/post")
public class PostControllerV1 {

    @Autowired
    private IPostManager postManager;
    
    @RequestMapping(method = RequestMethod.GET)
    List<ViewPost> getAllPosts() {
        return postManager.getAllPosts();
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    ViewPost getPost(Long postId) {
        return postManager.getPostById(postId);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ViewPost> getPostsByParams(
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
    ViewPost createPost(@RequestBody ViewPost post) {
        return postManager.createPost(post);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
    ViewPost updatePost(@PathVariable Long postId, @RequestBody ViewPost post) {
        return postManager.updatePost(postId, post);
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    ViewPost deletePost(@PathVariable Long postId) {
        return postManager.deletePost(postId);
    }
    
}
