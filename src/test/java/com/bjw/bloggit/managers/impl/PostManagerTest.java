package com.bjw.bloggit.managers.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjw.bloggit.accessors.IPostAccessor;
import com.bjw.bloggit.converters.IPostConverter;
import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.views.ViewPost;

@RunWith(MockitoJUnitRunner.class)
public class PostManagerTest {

    @InjectMocks
    private PostManager postManager;

    @Mock
    private IPostAccessor postAccessor;
    
    @Mock
    private IPostConverter postConverter;
    
    @Test
    public void testGetPostById() {
        DomainPost mockDomainPost = new DomainPost();
        ViewPost mockViewPost = new ViewPost();
        when(postAccessor.findOne(anyLong())).thenReturn(mockDomainPost);
        when(postConverter.domainToView(any(DomainPost.class))).thenReturn(mockViewPost);
        ViewPost response = postManager.getPostById(1L);
        assertThat(response, is(response));
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void testGetPostById_EntityNotFound() {
        when(postAccessor.findOne(anyLong())).thenReturn(null);
        postManager.getPostById(1L);
    }

}
