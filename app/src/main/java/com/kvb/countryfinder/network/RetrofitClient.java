package com.kvb.countryfinder.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String TAG = "RetrofitClient";
    private static final String BASE_URL = "https://restcountries.eu/rest/v2/";
    private static final Object mutex = new Object();
    private static RetrofitClient mInstance = null;

    public static RetrofitClient getInstance(){
        if(mInstance == null){
            synchronized (mutex){
                if(mInstance == null){
                    mInstance = new RetrofitClient();
                }
            }
        }
        return mInstance;
    }

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RetrofitAPI getRetrofitApi(){
        return getRetrofitInstance().create(RetrofitAPI.class);
    }
}
