package com.michaelfotiadis.samplearchitecture.net.model.posts;

import com.google.gson.annotations.SerializedName;
import com.michaelfotiadis.samplearchitecture.net.model.ApiModel;

public class Post implements ApiModel {

    @SerializedName("userId")
    private Integer userId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}