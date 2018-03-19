package com.michaelfotiadis.samplearchitecture.domain;

import android.arch.lifecycle.LiveData;

import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.db.model.Post;

import java.util.List;

public class GetAllPostsUseCase {

    private final PostDao postModel;

    public GetAllPostsUseCase(PostDao postModel) {
        this.postModel = postModel;
    }

    public LiveData<List<Post>> getPostsData() {
        return postModel.getAllPostsLive();
    }

}
