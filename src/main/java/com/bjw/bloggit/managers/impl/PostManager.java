package com.bjw.bloggit.managers.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjw.bloggit.accessors.IPostAccessor;
import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.managers.IPostManager;

@Component
public class PostManager implements IPostManager {

    @Autowired
    private IPostAccessor postAccessor;
    
    @Override
    public List<DomainPost> getAllPosts() {
        return postAccessor.findAll();
    }

    @Override
    public DomainPost getPostById(Long postId) {
        return postAccessor.findOne(postId);
    }

    @Override
    public List<DomainPost> getPostsByAuthor(String author) {
        return postAccessor.findAllByAuthor(author);
    }

    @Override
    public DomainPost createPost(DomainPost post) {
        return postAccessor.save(post);
    }

    @Override
    public DomainPost updatePost(Long postId, DomainPost post) {
        DomainPost currentPost = postAccessor.findOne(postId);
        if (currentPost == null || post.getPostId() != postId) {
            return null;
        }
        return postAccessor.save(post);
    }

    @Override
    public DomainPost deletePost(Long postId) {
        DomainPost post = postAccessor.findOne(postId);
        if (post == null) {
            return null;
        }
        postAccessor.delete(postId);
        return post;
    }

}
