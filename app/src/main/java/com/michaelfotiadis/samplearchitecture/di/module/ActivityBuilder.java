package com.michaelfotiadis.samplearchitecture.di.module;

import android.app.Activity;

import com.michaelfotiadis.samplearchitecture.ui.main.MainActivity;
import com.michaelfotiadis.samplearchitecture.ui.main.di.MainComponent;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostListActivity;
import com.michaelfotiadis.samplearchitecture.ui.posts.di.PostListComponent;
import com.michaelfotiadis.samplearchitecture.ui.signup.SignUpActivity;
import com.michaelfotiadis.samplearchitecture.ui.signup.di.SignUpComponent;

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
    @ActivityKey(PostListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindPostsActivity(PostListComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(SignUpActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindSignUpActivity(SignUpComponent.Builder builder);


}