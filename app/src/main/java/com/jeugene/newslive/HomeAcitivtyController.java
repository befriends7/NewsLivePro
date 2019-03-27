package com.jeugene.newslive;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeAcitivtyController implements iNavigationController {

    Context context;
    iNavigationControllerCallback controllerCallback;
    String vald;
    JsonArray ary1;


    public HomeAcitivtyController(Context context,iNavigationControllerCallback controllerCallback,String vald) {

        this.context = context;
        this.controllerCallback = controllerCallback;
        this.vald = vald;

    }

    @Override
    public void navigationdrawer() {

        Retrofit retrofit = App.getClient();

        Api service = retrofit.create(Api.class);

        switch(vald) {

            case "book": {

                service.dataload().enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        JsonObject obj = response.body();
                        JsonObject finalobj = obj.getAsJsonObject("results");

                        JsonArray finalary = finalobj.getAsJsonArray("books");

                        ArrayList<datalist.Book> list = getGeneral(finalary.toString());



                        controllerCallback.NavigationSuccess(list);


                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                        Toast.makeText(context, "Activate Net Connection", Toast.LENGTH_SHORT).show();


                    }
                });

                break;
            }

            case "news":
            {

                service.dataload2().enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        JsonObject obj = response.body();

                        JsonObject finalobj = obj.getAsJsonObject("response");

                        try {
                            ary1 = finalobj.getAsJsonArray("docs");
                        } catch (Exception e) {
                            Toast.makeText(context, "Server Error", Toast.LENGTH_SHORT).show();
                        }

                        ArrayList<datalst2.Doc> datalst2 = getGeneral2(ary1.toString());



                        controllerCallback.NavigatioSuccess2(datalst2);

                    }


                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });

                break;
            }

        }

    }

    private ArrayList<datalist.Book> getGeneral(String s)
    {

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<datalist.Book>>() {
        }.getType();

        return gson.fromJson(s, listType);

    }

    private ArrayList<datalst2.Doc> getGeneral2(String s)
    {

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<datalst2.Doc>>() {
        }.getType();

        return gson.fromJson(s, listType);

    }


}
