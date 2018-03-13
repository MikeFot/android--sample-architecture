package com.michaelfotiadis.samplearchitecture.injection;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.michaelfotiadis.samplearchitecture.analytics.Analytics;
import com.michaelfotiadis.samplearchitecture.analytics.MixPanelAnalytics;
import com.michaelfotiadis.samplearchitecture.db.AppDatabase;
import com.michaelfotiadis.samplearchitecture.net.RepositoryStore;

import java.lang.reflect.Modifier;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@SuppressWarnings("MethodMayBeStatic")
@Module
public class ApplicationModule {

    private final Context context;
    private final boolean isDebugEnabled;

    public ApplicationModule(final Application application,
                             final boolean isDebugEnabled) {
        context = application;
        this.isDebugEnabled = isDebugEnabled;

    }

    @Provides
    @Singleton
    AppDatabase providesAppDatabase() {
        return Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
    }

    @Provides
    @Named("endpoint")
    String providesEndpoint() {
        return "https://jsonplaceholder.typicode.com";
    }

    @Provides
    @Named("chat-endpoint")
    String providesChatEndpoint() {
        return "https://jsonplaceholder.typicode.com";
    }

    @Provides
    RepositoryStore providesRepositoryStore(@Named("endpoint") final String endpoint,
                                            @Named("chat- endpoint") final String chatEndpoint,
                                            final Gson gson) {
        return new RepositoryStore(endpoint, chatEndpoint, gson);
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .enableComplexMapKeySerialization()
                .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE)
                .create();
    }

    @Provides
    @Singleton
    Analytics providesAnalytics() {
        return new MixPanelAnalytics();
    }

}