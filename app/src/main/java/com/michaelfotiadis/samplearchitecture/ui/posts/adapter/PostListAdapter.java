package com.michaelfotiadis.samplearchitecture.ui.posts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.michaelfotiadis.samplearchitecture.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostsViewHolder> {

    private List<UiPost> posts = Collections.synchronizedList(new ArrayList<>());

    class PostsViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView subTitle;

        public PostsViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.subtitle);
        }
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_post, parent, false);

        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {

        UiPost item = posts.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getBody());

    }

    public void setItems(List<UiPost> uiPosts) {
        posts.clear();
        posts.addAll(uiPosts);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
