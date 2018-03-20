package com.michaelfotiadis.samplearchitecture.net.model.users;

import com.google.gson.annotations.SerializedName;
import com.michaelfotiadis.samplearchitecture.net.model.ApiModel;

public class Company implements ApiModel {

    @SerializedName("name")
    private String name;
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @SerializedName("bs")
    private String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}