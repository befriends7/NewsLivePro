package com.jeugene.newslive;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static final String BASE_URL = "https://api.nytimes.com/";

    static OkHttpClient.Builder httpclient = null;
    private static Retrofit retrofit = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private static OkHttpClient buildClient()
    {
        return new OkHttpClient.Builder().build();
    }

    public static Retrofit getClient()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().client(buildClient()).addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        }
        return retrofit;
    }


}
