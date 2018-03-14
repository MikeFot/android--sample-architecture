package com.michaelfotiadis.samplearchitecture.ui.signup;

import android.os.Bundle;
import android.widget.Toast;

import com.michaelfotiadis.samplearchitecture.R;
import com.michaelfotiadis.samplearchitecture.ui.common.activity.BaseActivity;

public class SignUpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("SignUp");
        Toast.makeText(this, "TODO!", Toast.LENGTH_SHORT).show();
    }
}
