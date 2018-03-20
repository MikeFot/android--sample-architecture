package com.michaelfotiadis.samplearchitecture.domain;

import com.michaelfotiadis.samplearchitecture.db.dao.MessageDao;
import com.michaelfotiadis.samplearchitecture.db.model.Message;
import com.michaelfotiadis.samplearchitecture.domain.listener.Cancellable;
import com.michaelfotiadis.samplearchitecture.domain.listener.Canceller;

import net.moznion.random.string.RandomStringGenerator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Timed;

public class GenerateChatUseCase implements Cancellable {

    private static final String[] NAMES = new String[]{"Michael", "Alex", "George"};
    private final MessageDao messageModel;
    private Disposable disposable;
    RandomStringGenerator generator = new RandomStringGenerator();

    public GenerateChatUseCase(MessageDao messageModel, Canceller canceller) {
        this.messageModel = messageModel;
        canceller.register(this);
    }

    public void generateChat() {
        Observable.interval(2L, TimeUnit.SECONDS)
                .timeInterval()
                .doOnSubscribe(disposable1 -> disposable = disposable1)
                .subscribe(this::generateEntry);
    }

    private void generateEntry(Timed<Long> longTimed) {
        Message message = Message.newBuilder()
                .withTimeStamp(longTimed.time())
                .withAuthor(getRandomName())
                .withMessage(getRandomString())
                .build();
        messageModel.upsertMessage(message);
    }

    private String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    private String getRandomString() {
        return generator.generateByRegex("\\w+\\d*\\s[0-9]{0,3}X");
    }


    @Override
    public void cancel() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
