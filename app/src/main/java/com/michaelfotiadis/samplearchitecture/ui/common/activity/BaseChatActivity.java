package com.michaelfotiadis.samplearchitecture.ui.common.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.michaelfotiadis.samplearchitecture.chat.ChatService;
import com.michaelfotiadis.samplearchitecture.log.AppLog;

public abstract class BaseChatActivity extends BaseActivity implements ServiceConnection {

    private ChatService chatService;

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, ChatService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    protected ChatService getChatService() {
        return chatService;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        AppLog.d("Service connected");
        ChatService.ChatBinder b = (ChatService.ChatBinder) service;
        chatService = b.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        AppLog.d("Service Disconnected");
    }

}
