package com.michaelfotiadis.samplearchitecture.chat.di;

import com.michaelfotiadis.samplearchitecture.chat.ChatService;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {ChatModule.class})
public interface ChatComponent extends AndroidInjector<ChatService> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ChatService> {

    }
}
