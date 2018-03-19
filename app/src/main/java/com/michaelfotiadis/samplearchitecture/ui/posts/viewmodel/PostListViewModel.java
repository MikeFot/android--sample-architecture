package com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;

import com.michaelfotiadis.samplearchitecture.db.model.Post;
import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.domain.RefreshPostsUseCaseV2;
import com.michaelfotiadis.samplearchitecture.domain.listener.LoadingCallbacks;
import com.michaelfotiadis.samplearchitecture.domain.model.LoadingState;
import com.michaelfotiadis.samplearchitecture.ui.posts.adapter.UiPost;
import com.michaelfotiadis.samplearchitecture.ui.posts.mapper.PostsUiMapper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PostListViewModel extends ViewModel {

    private final RefreshPostsUseCaseV2 refreshUseCase;
    private final LiveData<List<Post>> postLiveData;
    private final PostsUiMapper mapper;
    private final MutableLiveData<LoadingState> loadingStateLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<UiPost>> postUiData = new MutableLiveData<>();
    private final Observer<List<Post>> observer = PostListViewModel.this::mapToUi;

    PostListViewModel(final RefreshPostsUseCaseV2 refreshUseCase,
                      final GetAllPostsUseCase getAllPostsUseCase,
                      final PostsUiMapper mapper) {
        this.refreshUseCase = refreshUseCase;
        this.mapper = mapper;

        this.postLiveData = getAllPostsUseCase.getPostsData();
        this.postLiveData.observeForever(observer);
    }

    private void mapToUi(List<Post> posts) {
        final List<UiPost> uiPosts = mapper.dbToUi(posts);
        postUiData.postValue(uiPosts);
    }

    public MutableLiveData<LoadingState> getLoadingStateLiveData() {
        return loadingStateLiveData;
    }

    public void refresh() {
        refreshUseCase.refreshPosts(new LoadingCallbacks() {
            @Override
            public void onStateChanged(@NotNull LoadingState state) {
                loadingStateLiveData.postValue(state);
            }
        });
    }

    public LiveData<List<UiPost>> getPostUiLiveData() {
        return postUiData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        refreshUseCase.cancel();
        postLiveData.removeObserver(observer);
    }
}
