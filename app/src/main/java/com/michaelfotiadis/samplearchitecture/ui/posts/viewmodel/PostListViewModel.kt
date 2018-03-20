package com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel

import com.michaelfotiadis.samplearchitecture.db.model.Post
import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase
import com.michaelfotiadis.samplearchitecture.domain.RefreshPostsUseCaseV2
import com.michaelfotiadis.samplearchitecture.domain.listener.LoadingCallbacks
import com.michaelfotiadis.samplearchitecture.domain.model.LoadingState
import com.michaelfotiadis.samplearchitecture.ui.posts.adapter.UiPost
import com.michaelfotiadis.samplearchitecture.ui.posts.mapper.PostsUiMapper

class PostListViewModel internal constructor(private val refreshUseCase: RefreshPostsUseCaseV2,
                                             getAllPostsUseCase: GetAllPostsUseCase,
                                             private val mapper: PostsUiMapper) : ViewModel() {

    private val postLiveData: LiveData<List<Post>> = getAllPostsUseCase.postsData
    private val observer = Observer<List<Post>> { this@PostListViewModel.mapToUi(it) }
    val loadingStateLiveData = MutableLiveData<LoadingState>()
    val postUiData = MutableLiveData<List<UiPost>>()

    init {
        postLiveData.observeForever(observer)
    }

    private fun mapToUi(posts: List<Post>?) {
        val uiPosts = mapper.dbToUi(posts)
        postUiData.postValue(uiPosts)
    }

    fun refresh() {
        refreshUseCase.refreshPosts(object : LoadingCallbacks {
            override fun onStateChanged(state: LoadingState) {
                loadingStateLiveData.postValue(state)
            }
        })
    }

    override fun onCleared() {
        postLiveData.removeObserver(observer)
        super.onCleared()
    }
}
