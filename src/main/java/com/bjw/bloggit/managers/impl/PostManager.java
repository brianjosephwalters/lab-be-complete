package com.bjw.bloggit.managers.impl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjw.bloggit.accessors.IPostAccessor;
import com.bjw.bloggit.converters.IPostConverter;
import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.engines.IPostEngine;
import com.bjw.bloggit.managers.IPostManager;
import com.bjw.bloggit.views.ViewPost;

@Component
public class PostManager implements IPostManager {

    @Autowired
    private IPostAccessor postAccessor;
    
    @Autowired
    private IPostConverter postConverter;
    
    @Autowired
    private IPostEngine postEngine;
    
    @Override
    public List<ViewPost> getAllPosts() {
        return postAccessor.findAll().stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPost getPostById(Long postId) {
        DomainPost domainPost = postAccessor.findOne(postId);
        if (domainPost == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + postId.toString());
        }
        return postConverter.domainToView(domainPost);
    }

    @Override
    public List<ViewPost> getPostsByAuthor(String author) {
        return postAccessor.findAllByAuthor(author).stream()
                .map(postConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewPost createPost(ViewPost post) {
        return postConverter.domainToView(
                  postAccessor.save(
                      postConverter.viewToDomain(post)));
    }

    @Override
    public ViewPost updatePost(Long postId, ViewPost post) {
        DomainPost currentPost = postAccessor.findOne(postId);
        if (currentPost == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + postId.toString());
        } else if (post.getPostId() != postId) {
            throw new InvalidParameterException("Provided post id: " + postId + " does not match provided post: " + post);
        }
        return  postConverter.domainToView(
                    postAccessor.save(
                        postConverter.viewToDomain(post)));
    }

    @Override
    public ViewPost deletePost(Long postId) {
        DomainPost post = postAccessor.findOne(postId);
        if (post == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + postId.toString());
        }
        postAccessor.delete(postId);
        return postConverter.domainToView(post);
    }

    @Override
    public List<ViewPost> getPostsInDateRange(Long startDate, Long endDate) {
        return postAccessor.findAll().stream()
                .map(postConverter::domainToView)
                .filter(post -> {
                    return postEngine.isPostInDateRange(post, startDate, endDate);
                })
                .collect(Collectors.toList());
    }

}
