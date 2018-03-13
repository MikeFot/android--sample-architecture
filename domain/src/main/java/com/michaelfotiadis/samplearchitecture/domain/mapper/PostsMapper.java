package com.michaelfotiadis.samplearchitecture.domain.mapper;

import com.michaelfotiadis.samplearchitecture.db.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsMapper {

    public List<Post> apiToDb(final List<com.michaelfotiadis.samplearchitecture.net.model.posts.Post> netPosts) {

        final List<Post> dbPosts = new ArrayList<>();
        for (final com.michaelfotiadis.samplearchitecture.net.model.posts.Post netPost : netPosts) {
            Post dbPost = Post.newBuilder()
                    .withId(netPost.getId())
                    .withBody(netPost.getBody())
                    .withTitle(netPost.getTitle())
                    .withUserId(netPost.getUserId())
                    .build();
            dbPosts.add(dbPost);
        }
        return dbPosts;

    }

}
