package com.michaelfotiadis.samplearchitecture.chat

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

import com.michaelfotiadis.samplearchitecture.domain.listener.Canceller

class ChatCanceller(private val lifecycle: Lifecycle) : Canceller(), LifecycleObserver {

    init {
        this.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    internal fun onStop() {
        cancel()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    internal fun onDestroy() {
        unRegister()
        lifecycle.removeObserver(this)
    }

}
