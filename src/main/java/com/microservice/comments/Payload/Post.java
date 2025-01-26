package com.microservice.comments.Payload;

import jakarta.persistence.Id;

public class Post {
    @Id
    private String postId;
    private String title;
    private String description;
    private String content;

    public String getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }
}
