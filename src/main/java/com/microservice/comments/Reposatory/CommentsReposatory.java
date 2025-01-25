package com.microservice.comments.Reposatory;


import com.microservice.comments.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentsReposatory extends JpaRepository<Comments,String> {
}
