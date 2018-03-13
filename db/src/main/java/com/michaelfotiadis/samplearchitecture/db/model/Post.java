package com.michaelfotiadis.samplearchitecture.db.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Post {

    @PrimaryKey()
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Post() {
    }

    private Post(Builder builder) {
        setUserId(builder.userId);
        setId(builder.id);
        setTitle(builder.title);
        setBody(builder.body);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public static final class Builder {
        private Integer userId;
        private Integer id;
        private String title;
        private String body;

        private Builder() {
        }

        public Builder withUserId(Integer val) {
            userId = val;
            return this;
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withBody(String val) {
            body = val;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}