package com.michaelfotiadis.samplearchitecture.ui.posts.di;

import com.michaelfotiadis.samplearchitecture.di.scope.ActivityScope;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostListActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {PostListModule.class})
public interface PostListComponent extends AndroidInjector<PostListActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PostListActivity> {

    }
}
