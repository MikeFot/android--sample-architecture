package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.email.di;

import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.email.EmailFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface EmailFragmentSubcomponent extends AndroidInjector<EmailFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<EmailFragment> {
    }
}