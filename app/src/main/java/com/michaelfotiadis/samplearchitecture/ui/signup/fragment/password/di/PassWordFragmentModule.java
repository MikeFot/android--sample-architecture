package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.password.di;


import android.support.v4.app.Fragment;

import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.password.PassWordFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = PassWordFragmentSubComponent.class)
public abstract class PassWordFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(PassWordFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindPassWordFragmentInjectorFactory(PassWordFragmentSubComponent.Builder builder);
}