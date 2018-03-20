package com.michaelfotiadis.samplearchitecture.chat.di;

import android.app.Service;

import com.michaelfotiadis.samplearchitecture.chat.ChatService;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ServiceKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class ServiceBuilder {

    @Binds
    @IntoMap
    @ServiceKey(ChatService.class)
    abstract AndroidInjector.Factory<? extends Service> bindChatService(ChatComponent.Builder builder);


}