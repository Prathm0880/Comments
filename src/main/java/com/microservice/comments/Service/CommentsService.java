package com.microservice.comments.Service;

import com.microservice.comments.Configuration.RestTemplateConfig;
import com.microservice.comments.Entity.Comments;
import com.microservice.comments.Payload.Post;
import com.microservice.comments.Reposatory.CommentsReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class CommentsService {
    @Autowired
    private CommentsReposatory commentsReposatory;
    @Autowired
    private RestTemplateConfig restTemplateConfig;
    public Comments addComments(@RequestBody Comments comments){

        Post post = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8081/api/post/"+comments.getPostId(), Post.class);
        if(post!=null) {
            comments.setId(UUID.randomUUID().toString());
            Comments save = commentsReposatory.save(comments);
            return save;
        }
        throw new RuntimeException("Post not found.");
    }

}
