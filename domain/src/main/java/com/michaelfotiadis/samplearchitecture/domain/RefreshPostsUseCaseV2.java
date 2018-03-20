package com.michaelfotiadis.samplearchitecture.domain;

import android.arch.lifecycle.LiveData;

import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.db.model.Post;
import com.michaelfotiadis.samplearchitecture.domain.listener.Cancellable;
import com.michaelfotiadis.samplearchitecture.domain.listener.Canceller;
import com.michaelfotiadis.samplearchitecture.domain.listener.LoadingCallbacks;
import com.michaelfotiadis.samplearchitecture.domain.mapper.PostsMapper;
import com.michaelfotiadis.samplearchitecture.domain.model.LoadingState;
import com.michaelfotiadis.samplearchitecture.net.RestRepository;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RefreshPostsUseCaseV2 implements Cancellable {

    private final RestRepository mainRepository;
    private final PostDao postModel;
    private final PostsMapper mapper;
    private Disposable disposable;

    public RefreshPostsUseCaseV2(RestRepository mainRepository,
                                 PostDao postModel,
                                 PostsMapper mapper,
                                 Canceller canceller) {
        this.mainRepository = mainRepository;
        this.postModel = postModel;
        this.mapper = mapper;

        canceller.register(this);
    }

    public LiveData<List<Post>> getPosts() {
        return postModel.getAllPostsLive();
    }

    public void refreshPosts(final LoadingCallbacks loadingCallbacks) {
        mainRepository.getPosts()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable1 -> onLoading(disposable1, loadingCallbacks))
                .map(mapper::apiToDb)
                .subscribe(posts -> onLoaded(posts, loadingCallbacks), throwable -> onError(throwable, loadingCallbacks));
    }

    private void onLoading(Disposable disposable1, LoadingCallbacks loadingCallbacks) {
        disposable = disposable1;
        loadingCallbacks.onStateChanged(LoadingState.Companion.getLOADING());
    }

    private void onLoaded(List<Post> posts, LoadingCallbacks loadingCallbacks) {
        postModel.upsertPosts(posts);
        loadingCallbacks.onStateChanged(LoadingState.Companion.getLOADED());
    }

    private void onError(Throwable throwable, LoadingCallbacks loadingCallbacks) {
        loadingCallbacks.onStateChanged(LoadingState.Companion.error(throwable));
    }

    @Override
    public void cancel() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
