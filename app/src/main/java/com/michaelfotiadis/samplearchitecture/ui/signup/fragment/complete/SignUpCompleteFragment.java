package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.complete;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.michaelfotiadis.samplearchitecture.R;
import com.michaelfotiadis.samplearchitecture.ui.common.fragment.BaseFragment;
import com.michaelfotiadis.samplearchitecture.ui.signup.viewmodel.SignUpViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SignUpCompleteFragment extends BaseFragment {

    @Inject
    SignUpViewModel viewModel;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up_complete, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageView imageView = view.findViewById(R.id.image);

        imageView.setOnClickListener(this::onImageClicked);
    }

    private void onImageClicked(View view) {
        viewModel.moveToNext();
    }
}
