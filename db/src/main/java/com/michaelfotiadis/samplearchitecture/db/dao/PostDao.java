package com.michaelfotiadis.samplearchitecture.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.michaelfotiadis.samplearchitecture.db.model.Post;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PostDao {

    @Query("select * from post")
    LiveData<List<Post>> getAllPostsLive();

    @Query("select * from post")
    List<Post> getAllPosts();

    @Query("select * from post where id = :id")
    Post getPostById(String id);

    @Query("select * from post where id = :id")
    LiveData<Post> getPostByIdLive(String id);

    @Insert(onConflict = REPLACE)
    void upsertPost(Post post);

    @Insert(onConflict = REPLACE)
    void upsertPosts(List<Post> posts);

    @Delete
    void deletePost(Post post);

}
