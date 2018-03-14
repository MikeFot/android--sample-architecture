package com.michaelfotiadis.samplearchitecture.ui.signup.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class Factory implements ViewModelProvider.Factory {

    public Factory() {

    }

    @SuppressWarnings("unchecked")
    @Override
    public SignUpViewModel create(@NonNull Class modelClass) {
        return new SignUpViewModel();
    }
}
