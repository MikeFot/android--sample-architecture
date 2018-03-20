package com.michaelfotiadis.samplearchitecture.net.model.users;

import com.google.gson.annotations.SerializedName;
import com.michaelfotiadis.samplearchitecture.net.model.ApiModel;

public class Geo implements ApiModel {

    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}