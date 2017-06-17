package com.bjw.bloggit.managers;

import java.util.List;

import com.bjw.bloggit.domains.DomainPost;

public interface IPostManager {

    List<DomainPost> getAllPosts();
    
    DomainPost getPostById(Long postId);
    
    List<DomainPost> getPostsByAuthor(String author);
    
    DomainPost createPost(DomainPost post);
    
    DomainPost updatePost(Long postId, DomainPost post);
    
    DomainPost deletePost(Long postId);
    
}
