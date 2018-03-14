package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.password.di;

import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.password.PassWordFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface PassWordFragmentSubComponent extends AndroidInjector<PassWordFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PassWordFragment> {
    }
}