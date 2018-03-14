package com.michaelfotiadis.samplearchitecture.ui.signup.di;

import com.michaelfotiadis.samplearchitecture.di.scope.ActivityScope;
import com.michaelfotiadis.samplearchitecture.ui.signup.SignUpActivity;
import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.complete.di.SignUpCompleteFragmentModule;
import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.email.di.EmailFragmentModule;
import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.password.di.PassWordFragmentModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        SignUpModule.class,
        EmailFragmentModule.class,
        PassWordFragmentModule.class,
        SignUpCompleteFragmentModule.class})
public interface SignUpComponent extends AndroidInjector<SignUpActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SignUpActivity> {

    }
}
