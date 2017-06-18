package com.bjw.bloggit.converters.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bjw.bloggit.converters.IPostConverter;
import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.views.ViewPost;

@Service
public class PostConverter implements IPostConverter {

    @Override
    public DomainPost viewToDomain(ViewPost viewPost) {
        DomainPost domainPost = new DomainPost();
        domainPost.setPostId(viewPost.getPostId());
        domainPost.setTitle(viewPost.getTitle());
        domainPost.setBody(viewPost.getBody());
        domainPost.setAuthor(viewPost.getAuthor());
        domainPost.setLastUpdated(LocalDateTime.now());
        return domainPost;
    }

    @Override
    public ViewPost domainToView(DomainPost domainPost) {
        ViewPost viewPost = new ViewPost();
        viewPost.setPostId(domainPost.getPostId());
        viewPost.setTitle(domainPost.getTitle());
        viewPost.setBody(domainPost.getBody());
        viewPost.setAuthor(domainPost.getAuthor());
        return viewPost;
    }

}
