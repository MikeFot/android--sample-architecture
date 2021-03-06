package com.michaelfotiadis.samplearchitecture.ui.posts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.michaelfotiadis.samplearchitecture.R;
import com.michaelfotiadis.samplearchitecture.domain.model.LoadingState;
import com.michaelfotiadis.samplearchitecture.log.AppLog;
import com.michaelfotiadis.samplearchitecture.ui.common.activity.BaseActivity;
import com.michaelfotiadis.samplearchitecture.ui.posts.adapter.PostListAdapter;
import com.michaelfotiadis.samplearchitecture.ui.posts.adapter.UiPost;
import com.michaelfotiadis.samplearchitecture.ui.posts.viewmodel.PostListViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class PostListActivity extends BaseActivity {

    private static final int INDEX_PROGRESS = 0;
    private static final int INDEX_CONTENT = 1;

    private ViewFlipper viewFlipper;
    private PostListAdapter adapter;
    @Inject
    PostListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        setTitle("Posts");

        viewFlipper = findViewById(R.id.view_flipper);
        setUpRecyclerView();

        viewModel.getPostUiData().observe(this, this::onPostsChanged);
        viewModel.getLoadingStateLiveData().observe(this, this::onNetworkStateChanged);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.refresh();
    }

    private void setUpRecyclerView() {
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PostListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void onNetworkStateChanged(LoadingState loadingState) {
        if (loadingState != null) {
            AppLog.i("NetworkState: " + loadingState.getStatus());
            switch (loadingState.getStatus()) {
                case RUNNING:
                    viewFlipper.setDisplayedChild(INDEX_PROGRESS);
                    break;
                case SUCCESS:
                    viewFlipper.setDisplayedChild(INDEX_CONTENT);
                    break;
                case FAILED:
                    Toast.makeText(this, loadingState.getMsg(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private void onPostsChanged(@Nullable List<UiPost> posts) {
        if (posts != null) {
            AppLog.d("Got UI Posts: " + posts.size());
            adapter.setItems(posts);
        } else {
            AppLog.d("Got no Posts");
        }
    }
}
