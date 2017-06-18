package com.bjw.bloggit.managers;

import java.util.List;

import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.views.ViewPost;

public interface IPostManager {

    List<ViewPost> getAllPosts();
    
    ViewPost getPostById(Long postId);
    
    List<ViewPost> getPostsByAuthor(String author);
    
    ViewPost createPost(ViewPost post);
    
    ViewPost updatePost(Long postId, ViewPost post);
    
    ViewPost deletePost(Long postId);
    
}
