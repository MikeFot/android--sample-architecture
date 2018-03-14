package com.michaelfotiadis.samplearchitecture.ui.signup.di;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.michaelfotiadis.samplearchitecture.di.scope.ActivityScope;
import com.michaelfotiadis.samplearchitecture.ui.common.intent.IntentDispatcher;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostListActivity;
import com.michaelfotiadis.samplearchitecture.ui.signup.SignUpActivity;
import com.michaelfotiadis.samplearchitecture.ui.signup.viewmodel.Factory;
import com.michaelfotiadis.samplearchitecture.ui.signup.viewmodel.SignUpViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpModule {

    @Provides
    @ActivityScope
    IntentDispatcher providesIntentDispatcher(PostListActivity activity) {
        return new IntentDispatcher(activity);
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesViewModelFactory() {
        return new Factory();
    }

    @Provides
    @ActivityScope
    SignUpViewModel providesViewModel(SignUpActivity activity, ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(activity, factory).get(SignUpViewModel.class);
    }

}
