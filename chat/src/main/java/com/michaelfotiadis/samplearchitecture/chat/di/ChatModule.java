package com.michaelfotiadis.samplearchitecture.chat.di;

import com.michaelfotiadis.samplearchitecture.chat.ChatCanceller;
import com.michaelfotiadis.samplearchitecture.chat.ChatService;
import com.michaelfotiadis.samplearchitecture.db.dao.MessageDao;
import com.michaelfotiadis.samplearchitecture.domain.GenerateChatUseCase;
import com.michaelfotiadis.samplearchitecture.domain.GetAllMessagesUseCase;
import com.michaelfotiadis.samplearchitecture.domain.listener.Canceller;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatModule {

    @Provides
    GetAllMessagesUseCase providesGetAllMessagesUseCase(MessageDao messagesModel) {
        return new GetAllMessagesUseCase(messagesModel);
    }

    @Provides
    ChatCanceller providesChatCanceller(ChatService chatService) {
        return new ChatCanceller(chatService.getLifecycle());
    }

    @Provides
    GenerateChatUseCase providesGenerateChatUseCase(MessageDao messageModel, Canceller canceller) {
        return new GenerateChatUseCase(messageModel, canceller);
    }

}
