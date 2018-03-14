package com.michaelfotiadis.samplearchitecture.di.component;

import android.app.Application;

import com.michaelfotiadis.samplearchitecture.SampleApplication;
import com.michaelfotiadis.samplearchitecture.di.module.ActivityBuilder;
import com.michaelfotiadis.samplearchitecture.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


    void inject(SampleApplication app);

}