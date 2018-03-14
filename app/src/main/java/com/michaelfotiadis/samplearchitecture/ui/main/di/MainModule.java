package com.michaelfotiadis.samplearchitecture.ui.main.di;

import com.michaelfotiadis.samplearchitecture.ui.common.intent.IntentDispatcher;
import com.michaelfotiadis.samplearchitecture.ui.main.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    IntentDispatcher providesIntentDispatcher(MainActivity activity) {
        return new IntentDispatcher(activity);
    }
}