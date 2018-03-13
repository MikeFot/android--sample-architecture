package com.michaelfotiadis.samplearchitecture.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.db.model.Post;

@Database(entities = {Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PostDao getPostModel();

}