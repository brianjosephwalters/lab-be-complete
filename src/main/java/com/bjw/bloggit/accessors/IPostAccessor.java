package com.bjw.bloggit.accessors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjw.bloggit.domains.Post;

public interface IPostAccessor extends JpaRepository<Post, Long> {

    List<Post> findAllByAuthor(String author);
    
}
