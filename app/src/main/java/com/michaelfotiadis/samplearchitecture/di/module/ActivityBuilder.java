package com.michaelfotiadis.samplearchitecture.di.module;

import android.app.Activity;

import com.michaelfotiadis.samplearchitecture.ui.main.MainActivity;
import com.michaelfotiadis.samplearchitecture.ui.main.MainComponent;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostsActivity;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostsComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(PostsActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindPostsActivity(PostsComponent.Builder builder);


}