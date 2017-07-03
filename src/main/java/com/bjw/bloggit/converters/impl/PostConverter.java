package com.bjw.bloggit.converters.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.stereotype.Service;

import com.bjw.bloggit.converters.IDateConverter;
import com.bjw.bloggit.converters.IPostConverter;
import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.engines.IPostEngine;
import com.bjw.bloggit.views.ViewPost;

@Service
public class PostConverter implements IPostConverter {

    @Autowired
    IDateConverter dateConverter;
    
    @Autowired
    IPostEngine postEngine;
    
    @Override
    public DomainPost viewToDomain(ViewPost viewPost) {
        LocalDateTime now = LocalDateTime.now();
        DomainPost domainPost = new DomainPost();
        domainPost.setPostId(viewPost.getPostId());
        domainPost.setTitle(viewPost.getTitle());
        domainPost.setBody(viewPost.getBody());
        domainPost.setAuthor(viewPost.getAuthor());
        domainPost.setLastUpdated(now);
        if (viewPost.getPostId() == null) {
            domainPost.setCreatedOn(now);
        } else {
            domainPost.setCreatedOn(dateConverter
                    .convertLongToLocalDateTime(viewPost.getCreatedOn()));
        }
        return domainPost;
    }

    @Override
    public ViewPost domainToView(DomainPost domainPost) {
        ViewPost viewPost = new ViewPost();
        viewPost.setPostId(domainPost.getPostId());
        viewPost.setTitle(domainPost.getTitle());
        viewPost.setBody(domainPost.getBody());
        viewPost.setAuthor(domainPost.getAuthor());
        viewPost.setLastUpdated(dateConverter
                .convertLocalDateTimeToLong(domainPost.getLastUpdated()));
        viewPost.setCreatedOn(dateConverter
                .convertLocalDateTimeToLong(domainPost.getCreatedOn()));
        viewPost.setSummary(postEngine
                .getSummaryText(domainPost.getBody()));
        return viewPost;
    }

}
