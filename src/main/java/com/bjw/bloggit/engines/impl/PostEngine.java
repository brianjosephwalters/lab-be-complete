package com.bjw.bloggit.engines.impl;

import org.springframework.stereotype.Service;

import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.engines.IPostEngine;
import com.bjw.bloggit.views.ViewPost;

@Service
public class PostEngine implements IPostEngine {
    
    private static final Integer SUMMARY_LENGTH = 256;

    @Override
    public boolean isPostInDateRange(ViewPost post, Long startDate, Long endDate) {
        if (post != null && post.getCreatedOn() > startDate && post.getCreatedOn() < endDate) {
            return true;
        }
        return false;
    }

    @Override
    public String getSummaryText(String text) {
        if (text != null && text.length() > SUMMARY_LENGTH) {
            return text.substring(0, SUMMARY_LENGTH);
        }
        return text;
    }

}
