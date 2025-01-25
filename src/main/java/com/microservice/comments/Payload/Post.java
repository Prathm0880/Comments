package com.microservice.comments.Payload;

import jakarta.persistence.Id;

public class Post {
    @Id
    private String postId;
    private String title;
    private String description;
    private String content;

}
