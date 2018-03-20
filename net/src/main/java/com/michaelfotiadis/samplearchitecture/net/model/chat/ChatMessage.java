package com.michaelfotiadis.samplearchitecture.net.model.chat;

import com.michaelfotiadis.samplearchitecture.net.model.ApiModel;

public class ChatMessage implements ApiModel {

    private final String user;
    private final String message;

    public ChatMessage(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
