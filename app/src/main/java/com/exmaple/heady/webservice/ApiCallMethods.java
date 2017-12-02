package com.exmaple.heady.webservice;

import com.exmaple.heady.model.Response;

import retrofit2.http.GET;
import rx.Single;

public interface ApiCallMethods {

    @GET("json")
    Single<Response> getData();
}
