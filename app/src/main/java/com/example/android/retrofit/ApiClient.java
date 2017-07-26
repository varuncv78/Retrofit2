package com.example.android.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {

    static final String BASE_URL = "https://earthquake.usgs.gov";
    private static Retrofit retrofit;

    static Retrofit getApiClient(){

        if(retrofit==null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
