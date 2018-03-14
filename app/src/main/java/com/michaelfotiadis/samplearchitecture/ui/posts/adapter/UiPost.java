package com.michaelfotiadis.samplearchitecture.ui.posts.adapter;

public class UiPost {

    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;

    private UiPost(Builder builder) {
        userId = builder.userId;
        id = builder.id;
        title = builder.title;
        body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
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

        public UiPost build() {
            return new UiPost(this);
        }
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
}
