package com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.michaelfotiadis.samplearchitecture.domain.listener.Canceller;

public class PostListCanceller extends Canceller implements LifecycleObserver {

    private final Lifecycle lifecycle;

    public PostListCanceller(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        this.lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        cancel();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        unRegister();
        lifecycle.removeObserver(this);
    }

}
