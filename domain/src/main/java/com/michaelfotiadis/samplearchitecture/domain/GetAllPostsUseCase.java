package com.michaelfotiadis.samplearchitecture.domain;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.db.model.Post;
import com.michaelfotiadis.samplearchitecture.domain.mapper.PostsMapper;
import com.michaelfotiadis.samplearchitecture.domain.model.NetworkState;
import com.michaelfotiadis.samplearchitecture.net.MainRepository;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetAllPostsUseCase {

    private final MainRepository mainRepository;
    private final PostDao postModel;
    private MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private final PostsMapper mapper;
    private Disposable disposable;

    public GetAllPostsUseCase(MainRepository mainRepository,
                              PostDao postModel,
                              PostsMapper mapper) {
        this.mainRepository = mainRepository;
        this.postModel = postModel;
        this.mapper = mapper;
    }

    public LiveData<List<Post>> getPosts() {
        return postModel.getAllPostsLive();
    }

    public MutableLiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public void refreshPosts() {
        mainRepository.getPosts()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(this::onLoading)
                .map(mapper::apiToDb)
                .subscribe(this::onLoaded, this::onError);
    }

    private void onLoading(Disposable disposable1) {
        disposable = disposable1;
        networkState.postValue(NetworkState.Companion.getLOADING());
    }

    private void onLoaded(List<Post> posts) {
        networkState.postValue(NetworkState.Companion.getLOADED());
        postModel.upsertPosts(posts);
    }

    private void onError(Throwable throwable) {
        networkState.postValue(NetworkState.Companion.error(throwable));
    }

    public void onCancel() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.isDisposed();
        }
    }

}
