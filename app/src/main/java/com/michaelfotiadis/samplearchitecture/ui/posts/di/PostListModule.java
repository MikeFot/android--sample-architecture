package com.michaelfotiadis.samplearchitecture.ui.posts.di;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.di.scope.ActivityScope;
import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.domain.mapper.PostsMapper;
import com.michaelfotiadis.samplearchitecture.net.MainRepository;
import com.michaelfotiadis.samplearchitecture.ui.common.intent.IntentDispatcher;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostListActivity;
import com.michaelfotiadis.samplearchitecture.ui.posts.mapper.PostsUiMapper;
import com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel.Factory;
import com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel.PostListViewModel;
import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.email.di.EmailFragmentSubcomponent;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = EmailFragmentSubcomponent.class)
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
    GetAllPostsUseCase providesPostsUseCase(MainRepository mainRepository,
                                            PostDao postModel,
                                            PostsMapper mapper) {
        return new GetAllPostsUseCase(mainRepository, postModel, mapper);
    }

    @Provides
    @ActivityScope
    PostsUiMapper providesMapper() {
        return new PostsUiMapper();
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesViewModelFactory(GetAllPostsUseCase useCase, PostsUiMapper mapper) {
        return new Factory(useCase, mapper);
    }

    @Provides
    @ActivityScope
    PostListViewModel providesViewModel(PostListActivity activity, ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(activity, factory).get(PostListViewModel.class);
    }

}
