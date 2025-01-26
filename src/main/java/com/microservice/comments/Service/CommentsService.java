package com.microservice.comments.Service;

import com.microservice.comments.Configuration.RestTemplateConfig;
import com.microservice.comments.Entity.Comments;
import com.microservice.comments.Payload.Post;
import com.microservice.comments.Reposatory.CommentsReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class CommentsService {
    @Autowired
    private CommentsReposatory commentsReposatory;
    @Autowired
    private RestTemplateConfig restTemplateConfig;
    public Comments addComments(Comments comments){

        Post post = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8081/api/post/"+comments.getPostId(), Post.class);
        comments.setId(UUID.randomUUID().toString());
        Comments save = commentsReposatory.save(comments);
        return save;
    }
    //get all comments via postId
    public List<Comments> getComments(String postId){
        List<Comments> comments = commentsReposatory.findByPostId(postId);
        return comments;
    }
}
