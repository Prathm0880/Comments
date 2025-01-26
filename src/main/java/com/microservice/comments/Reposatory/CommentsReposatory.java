package com.microservice.comments.Reposatory;


import com.microservice.comments.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentsReposatory extends JpaRepository<Comments,String> {
    List<Comments> findByPostId(String postId);
}
