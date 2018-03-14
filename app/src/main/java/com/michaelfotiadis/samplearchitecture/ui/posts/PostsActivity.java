package com.michaelfotiadis.samplearchitecture.ui.posts;

import android.os.Bundle;

import com.michaelfotiadis.samplearchitecture.R;
import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.ui.common.activity.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class PostsActivity extends BaseActivity {

    @Inject
    GetAllPostsUseCase getAllPostsUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_posts);
    }
}
