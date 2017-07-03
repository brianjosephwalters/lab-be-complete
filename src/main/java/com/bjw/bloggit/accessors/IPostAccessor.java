package com.bjw.bloggit.accessors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjw.bloggit.domains.DomainPost;

public interface IPostAccessor extends JpaRepository<DomainPost, Long> {

    List<DomainPost> findAllByAuthor(String author);
    
}
