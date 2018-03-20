package com.michaelfotiadis.samplearchitecture.chat;

import android.app.Service;
import android.arch.lifecycle.LifecycleService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.michaelfotiadis.samplearchitecture.domain.GenerateChatUseCase;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ChatService extends LifecycleService {

    private final IBinder binder = new ChatBinder();

    @Inject
    GenerateChatUseCase useCase;

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        useCase.generateChat();
    }

    @Override
    public IBinder onBind(Intent intent) {
        super.onBind(intent);
        return binder;
    }

    public class ChatBinder extends Binder {
        public ChatService getService() {
            return ChatService.this;
        }
    }

}
