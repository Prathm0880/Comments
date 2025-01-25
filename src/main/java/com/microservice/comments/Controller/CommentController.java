package com.microservice.comments.Controller;

import com.microservice.comments.Entity.Comments;
import com.microservice.comments.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping()
    public ResponseEntity<Comments> addCommenet(@RequestBody Comments comments){
        Comments comments1 = commentsService.addComments(comments);
        return new ResponseEntity<>(comments1, HttpStatus.OK);
    }
}
