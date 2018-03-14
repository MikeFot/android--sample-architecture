package com.michaelfotiadis.samplearchitecture.ui.signup.fragment.password;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.samplearchitecture.R;
import com.michaelfotiadis.samplearchitecture.ui.common.fragment.BaseFragment;
import com.michaelfotiadis.samplearchitecture.ui.fontviews.FontEditText;
import com.michaelfotiadis.samplearchitecture.ui.signup.viewmodel.SignUpViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PassWordFragment extends BaseFragment {

    @Inject
    SignUpViewModel viewModel;

    private TextInputLayout inputLayout;
    private FontEditText editText;
    private FloatingActionButton fab;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputLayout = view.findViewById(R.id.input_layout);
        editText = view.findViewById(R.id.input_field);
        fab = view.findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(v -> viewModel.moveToNext());

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.setPassword(s.toString());
            }
        });

        viewModel.getPassWordState().observe(this, this::onPassWordStateChanged);
    }

    private void onPassWordStateChanged(Boolean isValid) {
        if (isValid != null) {
            fab.setEnabled(isValid);
            if (isValid) {
                fab.setVisibility(View.VISIBLE);
                inputLayout.setError(null);
            } else {
                fab.setVisibility(View.INVISIBLE);
                inputLayout.setError("Must be at least 6 characters long");
            }
        }
    }
}
