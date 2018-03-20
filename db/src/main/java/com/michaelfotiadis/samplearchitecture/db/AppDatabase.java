package com.michaelfotiadis.samplearchitecture.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.michaelfotiadis.samplearchitecture.db.dao.MessageDao;
import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.db.model.Message;
import com.michaelfotiadis.samplearchitecture.db.model.Post;

@Database(entities = {Post.class, Message.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PostDao getPostModel();

    public abstract MessageDao getMessageModel();

}