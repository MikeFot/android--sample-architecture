package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.complete.di;


import android.support.v4.app.Fragment;

import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.complete.SignUpCompleteFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = SignUpCompleteFragmentSubComponent.class)
public abstract class SignUpCompleteFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(SignUpCompleteFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindPassWordFragmentInjectorFactory(SignUpCompleteFragmentSubComponent.Builder builder);
}