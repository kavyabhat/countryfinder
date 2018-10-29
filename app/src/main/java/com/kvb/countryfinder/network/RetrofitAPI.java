package com.kvb.countryfinder.network;

import com.kvb.countryfinder.model.CountryDataBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<List<CountryDataBean>> getCountryByName(@Url String url, @Query("fullText") String fullText);

    @GET
    Call<List<CountryDataBean>> getCountriesByRegion(@Url String url);
}
