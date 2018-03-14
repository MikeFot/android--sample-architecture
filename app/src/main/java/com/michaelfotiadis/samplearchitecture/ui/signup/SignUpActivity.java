package com.michaelfotiadis.samplearchitecture.ui.signup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.michaelfotiadis.samplearchitecture.R;
import com.michaelfotiadis.samplearchitecture.ui.common.activity.BaseActivity;
import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.complete.SignUpCompleteFragment;
import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.email.EmailFragment;
import com.michaelfotiadis.samplearchitecture.ui.signup.fragment.password.PassWordFragment;
import com.michaelfotiadis.samplearchitecture.ui.signup.viewmodel.SignUpViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class SignUpActivity extends BaseActivity implements HasSupportFragmentInjector {

    private static final int CONTENT_ID = R.id.content_frame;
    private static final String FRAGMENT_TAG = "fragment_tag";
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    SignUpViewModel viewModel;
    private EmailFragment emailFragment;
    private PassWordFragment passWordFragment;
    private SignUpCompleteFragment signUpCompleteFragment;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");

        viewModel.getCurrentState().observe(this, this::onStateChanged);

        viewModel.init();


    }

    @Override
    public void onBackPressed() {
        viewModel.onBackPressed();
    }

    private void onStateChanged(SignUpViewModel.State state) {

        switch (state) {
            case EMAIL:
                showEmailFragment();
                break;
            case PASSWORD:
                showPassWordFragment();
                break;
            case COMPLETE:
                showCompleteFragment();
                break;
            case FINISH:
                finish();
                break;
        }
    }

    private void showEmailFragment() {
        if (emailFragment == null) {
            emailFragment = new EmailFragment();
        }
        addOrReplaceFragment(emailFragment);
    }

    private void showPassWordFragment() {
        if (passWordFragment == null) {
            passWordFragment = new PassWordFragment();
        }
        addOrReplaceFragment(passWordFragment);
    }

    private void showCompleteFragment() {
        if (signUpCompleteFragment == null) {
            signUpCompleteFragment = new SignUpCompleteFragment();
        }
        addOrReplaceFragment(signUpCompleteFragment);
    }

    private void addOrReplaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment existingFragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (existingFragment == null) {
            transaction.add(CONTENT_ID, fragment, FRAGMENT_TAG);
        } else {
            transaction.replace(CONTENT_ID, fragment, FRAGMENT_TAG);
        }
        transaction.commit();
    }
}
