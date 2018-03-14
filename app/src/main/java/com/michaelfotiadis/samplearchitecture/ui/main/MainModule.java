package com.michaelfotiadis.samplearchitecture.ui.main;

import com.michaelfotiadis.samplearchitecture.ui.common.intent.IntentDispatcher;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    IntentDispatcher providesIntentDispatcher(MainActivity activity) {
        return new IntentDispatcher(activity);
    }
}