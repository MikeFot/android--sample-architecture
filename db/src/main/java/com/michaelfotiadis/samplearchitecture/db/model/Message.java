package com.michaelfotiadis.samplearchitecture.db.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Message {

    @PrimaryKey()
    private Long timeStamp;
    private String author;
    private String message;

    public Message() {

    }

    public Message(Long timeStamp, String author, String message) {
        this.timeStamp = timeStamp;
        this.author = author;
        this.message = message;
    }

    private Message(Builder builder) {
        timeStamp = builder.timeStamp;
        author = builder.author;
        message = builder.message;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static final class Builder {
        private Long timeStamp;
        private String author;
        private String message;

        private Builder() {
        }

        public Builder withTimeStamp(Long val) {
            timeStamp = val;
            return this;
        }

        public Builder withAuthor(String val) {
            author = val;
            return this;
        }

        public Builder withMessage(String val) {
            message = val;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}