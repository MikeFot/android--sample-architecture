package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.email.di;


import android.support.v4.app.Fragment;

import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.email.EmailFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = EmailFragmentSubcomponent.class)
public abstract class EmailFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(EmailFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindEmailFragmentInjectorFactory(EmailFragmentSubcomponent.Builder builder);
}