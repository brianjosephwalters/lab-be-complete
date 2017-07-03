package com.bjw.bloggit.engines.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bjw.bloggit.engines.IPostEngine;
import com.bjw.bloggit.views.ViewPost;

public class PostEngineTest {
    
    IPostEngine postEngine = new PostEngine();
    
    private ViewPost defaultPost;

    @Before
    public void setUp() {        
        defaultPost = new ViewPost();
        defaultPost.setPostId(1L);
        defaultPost.setTitle("A sample post");
        defaultPost.setBody("This is a sample post.");
        defaultPost.setSummary("This is a default post.");
        defaultPost.setAuthor("Brian J. Walters");
        defaultPost.setCreatedOn(1483596000000L);       // 01/05/2017
        defaultPost.setLastUpdated(1483596000000L);     // 01/05/2017
    }
    
    @Test
    public void testIsPostInDateRange_IsTrue() {
        Long startDate = 1483509600000L;  // 01/04/2017
        Long endDate = 1483682400000L;    // 01/06/2017
        boolean result = postEngine.isPostInDateRange(defaultPost, startDate, endDate);
        assertThat(result, is(equalTo(true)));
    }
    
    @Test
    public void testIsPostInDateRange_IsFalse() {
        Long startDate = 1483423200000L;  // 01/03/2017
        Long endDate = 1483509600000L;    // 01/04/2017
        boolean result = postEngine.isPostInDateRange(defaultPost, startDate, endDate);
        assertThat(result, is(equalTo(false)));
    }

    @Test
    public void testGetSummaryText() {
        String result = postEngine.getSummaryText(defaultPost.getBody());
        assertThat(result.length(), is(defaultPost.getBody().length()));
    }
    
    @Test
    public void testGetSummaryText_Truncating() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum "
                + "gravida aliquam tellus sed eleifend. Donec fermentum ligula dapibus "
                + "felis interdum molestie. Nam tempor ex odio, a dignissim nunc ornare "
                + "sit amet. Vestibulum scelerisque, ligula ac blandit maximus, velit dui "
                + "lobortis tellus posuere.";
        
        String result = postEngine.getSummaryText(text);
        assertThat(result.length(), is(256));
    }

}
