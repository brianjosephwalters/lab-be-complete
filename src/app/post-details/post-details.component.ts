import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { PostService } from '../post-service/post.service';
import { Post } from '../post-service/post';

@Component({
    selector: 'post-details',
    templateUrl: './post-details.component.html',
    styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent {

    private postId: number;
    private post: Post;

    constructor(route: ActivatedRoute, postService: PostService) {
        route.params.subscribe(params => this.postId = params['postId'])
        this.post = postService.getPostById(this.postId);
    }

}