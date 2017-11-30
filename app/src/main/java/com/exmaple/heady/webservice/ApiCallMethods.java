package com.exmaple.heady.webservice;

import com.exmaple.heady.BuildConfig;
import com.exmaple.heady.model.Response;

import retrofit2.http.GET;
import rx.Single;

public interface ApiCallMethods {
    String SERVICE_ENDPOINT = BuildConfig.BASE_URL;

    @GET("json")
    Single<Response> getData();
}
