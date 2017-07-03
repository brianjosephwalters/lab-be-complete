package com.bjw.bloggit.engines;

import com.bjw.bloggit.views.ViewPost;

public interface IPostEngine {

    boolean isPostInDateRange(ViewPost post, Long startDate, Long endDate);
    
    String getSummaryText(String text);
    
}
