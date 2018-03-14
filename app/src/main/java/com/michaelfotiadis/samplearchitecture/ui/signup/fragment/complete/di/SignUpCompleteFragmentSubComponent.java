package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.complete.di;

import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.complete.SignUpCompleteFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface SignUpCompleteFragmentSubComponent extends AndroidInjector<SignUpCompleteFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SignUpCompleteFragment> {
    }
}