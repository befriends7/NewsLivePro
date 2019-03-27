package com.jeugene.newslive;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("svc/books/v3/lists/current/hardcover-fiction.json?api-key=API_KEY")
    Call<JsonObject> dataload();

    @GET("svc/search/v2/articlesearch.json?q=&api-key=API_KEY")
    Call<JsonObject> dataload2();

}
