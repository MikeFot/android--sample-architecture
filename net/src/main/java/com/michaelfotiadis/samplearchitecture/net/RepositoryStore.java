package com.michaelfotiadis.samplearchitecture.net;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 *
 */
public class RepositoryStore {

    private final String serverEndpoint;
    private final String chatEndpoint;
    private final RestRepository mainRepository;

    public RepositoryStore(final String baseUrl,
                           final String baseChatUrl,
                           final Gson gson) {

        serverEndpoint = baseUrl;
        chatEndpoint = baseChatUrl;

        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build();
        final Retrofit adapter = RestAdapterFactory.create(baseUrl, okHttpClient, gson);

        mainRepository = new RestRepository(adapter);

    }

    public RestRepository getMainRepository() {
        return mainRepository;
    }

    public String getServerEndpoint() {
        return serverEndpoint;
    }

    public String getChatEndpoint() {
        return chatEndpoint;
    }
}
