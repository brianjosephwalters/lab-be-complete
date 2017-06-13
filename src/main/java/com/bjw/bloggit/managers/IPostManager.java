package com.bjw.bloggit.managers;

import java.util.List;

import com.bjw.bloggit.domains.Post;

public interface IPostManager {

    List<Post> getAllPosts();
    
    Post getPostById(Long postId);
    
    List<Post> getPostsByAuthor(String author);
    
    Post createPost(Post post);
    
    Post updatePost(Long postId, Post post);
    
    Post deletePost(Long postId);
    
}
