package com.michaelfotiadis.samplearchitecture.ui.posts.mapper;

import com.michaelfotiadis.samplearchitecture.db.model.Post;
import com.michaelfotiadis.samplearchitecture.ui.posts.adapter.UiPost;

import java.util.ArrayList;
import java.util.List;

public class PostsUiMapper {

    public List<UiPost> dbToUi(final List<Post> dbPosts) {

        final List<UiPost> uiPosts = new ArrayList<>();
        if (dbPosts != null) {
            for (final Post dbPost : dbPosts) {
                if (dbPost != null) {
                    UiPost uiPost = UiPost.newBuilder()
                            .withId(dbPost.getId())
                            .withBody(dbPost.getBody())
                            .withTitle(dbPost.getTitle())
                            .withUserId(dbPost.getUserId())
                            .build();
                    uiPosts.add(uiPost);
                }
            }
        }
        return uiPosts;

    }

}
