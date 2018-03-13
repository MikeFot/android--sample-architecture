package com.michaelfotiadis.samplearchitecture.analytics;

public interface Analytics {

    void onApplicationStarted();

    void identifyUser(String id);

}
