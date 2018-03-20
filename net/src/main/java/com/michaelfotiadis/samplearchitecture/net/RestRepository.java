package com.michaelfotiadis.samplearchitecture.net;

import com.michaelfotiadis.samplearchitecture.net.api.Api;
import com.michaelfotiadis.samplearchitecture.net.model.posts.Post;
import com.michaelfotiadis.samplearchitecture.net.model.users.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class RestRepository {


    private final Api api;

    public RestRepository(Retrofit retrofit) {
        this.api = retrofit.create(Api.class);
    }

    public Single<List<Post>> getPosts() {
        return api.getPosts();
    }

    public Single<List<User>> getUsers() {
        return api.getUsers();
    }

}
