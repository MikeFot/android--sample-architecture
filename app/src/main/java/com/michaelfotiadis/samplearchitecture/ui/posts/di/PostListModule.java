package com.michaelfotiadis.samplearchitecture.ui.posts.di;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.di.scope.ActivityScope;
import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.domain.RefreshAndGetPostsUseCase;
import com.michaelfotiadis.samplearchitecture.domain.RefreshPostsUseCaseV2;
import com.michaelfotiadis.samplearchitecture.domain.mapper.PostsMapper;
import com.michaelfotiadis.samplearchitecture.net.RestRepository;
import com.michaelfotiadis.samplearchitecture.ui.common.intent.IntentDispatcher;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostListActivity;
import com.michaelfotiadis.samplearchitecture.ui.posts.mapper.PostsUiMapper;
import com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel.Factory;
import com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel.PostListCanceller;
import com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel.PostListViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class PostListModule {

    @Provides
    @ActivityScope
    IntentDispatcher providesIntentDispatcher(PostListActivity activity) {
        return new IntentDispatcher(activity);
    }

    @Provides
    @ActivityScope
    PostsMapper providesPostsMapper() {
        return new PostsMapper();
    }

    @Provides
    @ActivityScope
    RefreshAndGetPostsUseCase providesRefreshPostsUseCase(RestRepository mainRepository,
                                                          PostDao postModel,
                                                          PostsMapper mapper) {
        return new RefreshAndGetPostsUseCase(mainRepository, postModel, mapper);
    }

    @Provides
    @ActivityScope
    PostListCanceller providesPostListCanceller(PostListActivity activity) {
        return new PostListCanceller(activity.getLifecycle());
    }

    @Provides
    @ActivityScope
    RefreshPostsUseCaseV2 providesRefreshPostsUseCaseV2(RestRepository mainRepository,
                                                        PostDao postModel,
                                                        PostsMapper mapper,
                                                        PostListCanceller canceller) {
        return new RefreshPostsUseCaseV2(mainRepository, postModel, mapper, canceller);
    }

    @Provides
    @ActivityScope
    GetAllPostsUseCase providesGetAllPostsUseCase(PostDao postModel) {
        return new GetAllPostsUseCase(postModel);
    }

    @Provides
    @ActivityScope
    PostsUiMapper providesMapper() {
        return new PostsUiMapper();
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesViewModelFactory(RefreshPostsUseCaseV2 refreshPostsUseCaseV2,
                                                       GetAllPostsUseCase getAllPostsUseCase,
                                                       PostsUiMapper mapper) {
        return new Factory(refreshPostsUseCaseV2, getAllPostsUseCase, mapper);
    }

    @Provides
    @ActivityScope
    PostListViewModel providesViewModel(PostListActivity activity, ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(activity, factory).get(PostListViewModel.class);
    }

}
