package com.bjw.bloggit.converters;

import com.bjw.bloggit.domains.DomainPost;
import com.bjw.bloggit.views.ViewPost;

public interface IPostConverter {

    DomainPost viewToDomain(ViewPost viewPost);
    
    ViewPost domainToView(DomainPost domainPost);
    
}
