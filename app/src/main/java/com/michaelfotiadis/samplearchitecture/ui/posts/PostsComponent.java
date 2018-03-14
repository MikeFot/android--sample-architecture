package com.michaelfotiadis.samplearchitecture.ui.posts;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {PostsModule.class})
public interface PostsComponent extends AndroidInjector<PostsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PostsActivity> {

    }
}
