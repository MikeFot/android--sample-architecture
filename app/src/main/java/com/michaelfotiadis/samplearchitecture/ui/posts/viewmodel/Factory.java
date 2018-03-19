package com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.domain.RefreshPostsUseCaseV2;
import com.michaelfotiadis.samplearchitecture.ui.posts.mapper.PostsUiMapper;

public class Factory implements ViewModelProvider.Factory {
    private final RefreshPostsUseCaseV2 refreshPostsUseCaseV2;
    private final GetAllPostsUseCase getAllPostsUseCase;
    private final PostsUiMapper mapper;

    public Factory(RefreshPostsUseCaseV2 refreshPostsUseCaseV2, GetAllPostsUseCase getAllPostsUseCase, PostsUiMapper mapper) {
        this.refreshPostsUseCaseV2 = refreshPostsUseCaseV2;
        this.getAllPostsUseCase = getAllPostsUseCase;
        this.mapper = mapper;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public PostListViewModel create(@NonNull Class modelClass) {
        return new PostListViewModel(refreshPostsUseCaseV2, getAllPostsUseCase, mapper);
    }
}
