package com.michaelfotiadis.samplearchitecture.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.michaelfotiadis.samplearchitecture.db.model.Message;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MessageDao {

    @Query("select * from message")
    LiveData<List<Message>> getAllMessagesLive();

    @Query("select * from message")
    List<Message> getAllMessages();

    @Insert(onConflict = REPLACE)
    void upsertMessage(Message message);

    @Insert(onConflict = REPLACE)
    void upsertMessages(List<Message> messages);

    @Delete
    void deleteMessage(Message message);

}
