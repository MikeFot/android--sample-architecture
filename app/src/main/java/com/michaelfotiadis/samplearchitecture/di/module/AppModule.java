package com.michaelfotiadis.samplearchitecture.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.michaelfotiadis.samplearchitecture.analytics.Analytics;
import com.michaelfotiadis.samplearchitecture.analytics.MixPanelAnalytics;
import com.michaelfotiadis.samplearchitecture.db.AppDatabase;
import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.net.MainRepository;
import com.michaelfotiadis.samplearchitecture.net.RepositoryStore;
import com.michaelfotiadis.samplearchitecture.ui.main.MainComponent;
import com.michaelfotiadis.samplearchitecture.ui.posts.PostsComponent;

import java.lang.reflect.Modifier;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(subcomponents = {MainComponent.class, PostsComponent.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    AppDatabase providesAppDatabase(Context context) {
        return Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
    }

    @Provides
    PostDao providesPostModel(AppDatabase appDatabase) {
        return appDatabase.getPostModel();
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
                                            @Named("chat-endpoint") final String chatEndpoint,
                                            final Gson gson) {
        return new RepositoryStore(endpoint, chatEndpoint, gson);
    }

    @Provides
    MainRepository providesMainRepository(final RepositoryStore repositoryStore) {
        return repositoryStore.getMainRepository();
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