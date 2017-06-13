package com.bjw.bloggit.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bjw.bloggit.domains.Post;

@RestController
@RequestMapping("/api/v1/post")
public class PostControllerV1 {

    @RequestMapping(method = RequestMethod.GET)
    List<Post> getAllPosts() {
        return Collections.emptyList();
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    Post getPost(Long postId) {
        return null;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Post> getPostsByDate(@RequestParam("startDate") Long startDate, 
            @RequestParam("endDate") Long endDate) {
            return Collections.emptyList();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Post createPost(@RequestBody Post post) {
        return null;
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
    Post updatePost(@PathVariable Long postId, @RequestBody Post post) {
        return null;
    }
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    Post deletePost(@PathVariable Long postId) {
        return null;
    }
    
}
