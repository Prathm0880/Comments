package com.microservice.comments.Controller;

import com.microservice.comments.Entity.Comments;
import com.microservice.comments.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping()
    public ResponseEntity<Comments> addComment(@RequestBody Comments comments){
        Comments comments1 = commentsService.addComments(comments);
        return new ResponseEntity<>(comments1, HttpStatus.OK);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<List<Comments>>allComments(@PathVariable String postId){
        List<Comments> comments = commentsService.getComments(postId);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }
}
