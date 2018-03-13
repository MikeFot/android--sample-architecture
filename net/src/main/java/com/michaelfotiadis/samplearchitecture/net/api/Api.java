package com.michaelfotiadis.samplearchitecture.net.api;

import com.michaelfotiadis.samplearchitecture.net.model.posts.Post;
import com.michaelfotiadis.samplearchitecture.net.model.users.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("/posts")
    Single<List<Post>> getPosts();

    @GET("/users")
    Single<List<User>> getUsers();

}
