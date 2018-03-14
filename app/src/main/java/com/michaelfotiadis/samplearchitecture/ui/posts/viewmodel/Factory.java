package com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.ui.posts.mapper.PostsUiMapper;

public class Factory implements ViewModelProvider.Factory {
    private final GetAllPostsUseCase useCase;
    private final PostsUiMapper mapper;

    public Factory(GetAllPostsUseCase useCase, PostsUiMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PostListViewModel create(@NonNull Class modelClass) {
        return new PostListViewModel(useCase, mapper);
    }
}
