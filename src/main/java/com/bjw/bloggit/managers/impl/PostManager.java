package com.bjw.bloggit.managers.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bjw.bloggit.domains.Post;
import com.bjw.bloggit.managers.IPostManager;

@Component
public class PostManager implements IPostManager {

    @Override
    public List<Post> getAllPosts() {
        return Collections.emptyList();
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByAuthor(String author) {
        return Collections.emptyList();
    }

    @Override
    public Post createPost(Post post) {
        return null;
    }

    @Override
    public Post updatePost(Long postId, Post post) {
        return null;
    }

    @Override
    public Post deletePost(Long postId) {
        return null;
    }

}
