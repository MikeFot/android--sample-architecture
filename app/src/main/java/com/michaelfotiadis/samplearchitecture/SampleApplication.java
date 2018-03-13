package com.michaelfotiadis.samplearchitecture;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.michaelfotiadis.samplearchitecture.injection.ComponentStore;
import com.michaelfotiadis.samplearchitecture.injection.Injector;
import com.michaelfotiadis.samplearchitecture.log.AppLog;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppLog.d("Starting application");

        Injector.setComponentStore(new ComponentStore(this, BuildConfig.DEBUG));

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

    }
}
