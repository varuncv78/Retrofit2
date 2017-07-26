package com.example.android.retrofit;

import com.example.android.retrofit.pojo.EventMain;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-12-01&minmagnitude=7")
    Call<EventMain> getData();
}
