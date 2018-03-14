package com.michaelfotiadis.samplearchitecture.ui.chat;

import android.os.Bundle;
import android.widget.Toast;

import com.michaelfotiadis.samplearchitecture.R;
import com.michaelfotiadis.samplearchitecture.ui.common.activity.BaseChatActivity;

public class ChatActivity extends BaseChatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        setTitle("Chat");
        Toast.makeText(this, "TODO!", Toast.LENGTH_SHORT).show();
    }
}
