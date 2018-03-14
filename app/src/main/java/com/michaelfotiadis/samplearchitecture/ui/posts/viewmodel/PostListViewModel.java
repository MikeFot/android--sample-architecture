package com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;

import com.michaelfotiadis.samplearchitecture.db.model.Post;
import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.domain.model.LoadingState;
import com.michaelfotiadis.samplearchitecture.ui.posts.adapter.UiPost;
import com.michaelfotiadis.samplearchitecture.ui.posts.mapper.PostsUiMapper;

import java.util.List;

public class PostListViewModel extends ViewModel {

    private final GetAllPostsUseCase useCase;
    private final LiveData<List<Post>> postLiveData;
    private final PostsUiMapper mapper;
    private final MutableLiveData<List<UiPost>> postUiData = new MutableLiveData<>();
    private final LiveData<LoadingState> networkStateLiveData;
    private final Observer<List<Post>> observer = PostListViewModel.this::mapToUi;

    PostListViewModel(final GetAllPostsUseCase useCase, final PostsUiMapper mapper) {
        this.useCase = useCase;
        this.postLiveData = useCase.getPosts();
        this.mapper = mapper;
        this.postLiveData.observeForever(observer);
        this.networkStateLiveData = useCase.getNetworkState();
    }

    private void mapToUi(List<Post> posts) {
        final List<UiPost> uiPosts = mapper.dbToUi(posts);
        postUiData.postValue(uiPosts);
    }

    public void refresh() {
        useCase.refreshPosts();
    }

    public LiveData<List<UiPost>> getPostUiData() {
        return postUiData;
    }

    public LiveData<LoadingState> getNetworkStateLiveData() {
        return networkStateLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        postLiveData.removeObserver(observer);
    }
}
