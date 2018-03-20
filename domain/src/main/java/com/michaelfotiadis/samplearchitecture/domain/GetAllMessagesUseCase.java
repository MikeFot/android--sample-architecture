package com.michaelfotiadis.samplearchitecture.domain;

import android.arch.lifecycle.LiveData;

import com.michaelfotiadis.samplearchitecture.db.dao.MessageDao;
import com.michaelfotiadis.samplearchitecture.db.model.Message;

import java.util.List;

public class GetAllMessagesUseCase {

    private final MessageDao messageModel;

    public GetAllMessagesUseCase(MessageDao messageModel) {
        this.messageModel = messageModel;
    }

    public LiveData<List<Message>> getMessagesData() {
        return messageModel.getAllMessagesLive();
    }

}
