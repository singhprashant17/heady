package com.exmaple.heady.webservice;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {

    /**
     * basic retrofit instance generator
     */
    @NonNull
    private static Retrofit getRetrofitInstance(String endpoint, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    /**
     * rest adapter with Header
     */
    public static <T> T createService(final Class<T> clazz, final String endpoint) {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        final OkHttpClient client = httpClient.build();
        final Retrofit restAdapter = getRetrofitInstance(endpoint, client);
        return restAdapter.create(clazz);
    }

    public static <T> T createService(final Class<T> clazz) throws NoInternetException {
        return createService(clazz, ApiCallMethods.SERVICE_ENDPOINT);
    }
}
