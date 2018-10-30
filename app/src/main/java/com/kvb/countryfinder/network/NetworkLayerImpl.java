package com.kvb.countryfinder.network;

import android.util.Log;

import com.kvb.countryfinder.model.CountryDataBean;
import com.kvb.countryfinder.view.OnCountryDetailsFetchedListener;
import com.kvb.countryfinder.view.OnRegionDataFetchedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkLayerImpl implements NetworkLayer {
    private RetrofitAPI retrofitAPI;
    private static final String TAG = "NetworkLayerImpl";

    @Override
    public void fetchCountrySpecificData(String countryName, final OnCountryDetailsFetchedListener onCountryDetailsFetchedListener) {
        if(retrofitAPI == null) {
            retrofitAPI = RetrofitClient.getInstance().getRetrofitApi();
        }
        String url = "name/"+countryName;
        Call<List<CountryDataBean>> countryDataCall = retrofitAPI.getCountryByName(url, "true");
        countryDataCall.enqueue(new Callback<List<CountryDataBean>>() {
            @Override
            public void onResponse(Call<List<CountryDataBean>> call, Response<List<CountryDataBean>> response) {
                if(response.isSuccessful()){
                    CountryDataBean countryDataBean = response.body().get(0);
                    Log.i(TAG, "onResponse: data received "+countryDataBean.getCapital());
                    onCountryDetailsFetchedListener.countryDataFetched(countryDataBean);
                }
            }

            @Override
            public void onFailure(Call<List<CountryDataBean>> call, Throwable t) {
                Log.i(TAG, "onFailure: data not received. Try later. "+t.getMessage());
                onCountryDetailsFetchedListener.countryDataFetched(null);
            }
        });

    }

    //enable caching todo
    @Override
    public void fetchCountriesByRegion(final String regionName, final OnRegionDataFetchedListener onRegionDataFetchedListener) {
        if(retrofitAPI == null) {
            retrofitAPI = RetrofitClient.getInstance().getRetrofitApi();
        }
        String url = "region/"+regionName;
        Call<List<CountryDataBean>> regionWiseCountryCall = retrofitAPI.getCountriesByRegion(url);
        regionWiseCountryCall.enqueue(new Callback<List<CountryDataBean>>() {
            @Override
            public void onResponse(Call<List<CountryDataBean>> call, Response<List<CountryDataBean>> response) {
                if(response.isSuccessful()){
                    List<CountryDataBean> regionWiseCountryList = response.body();
                    onRegionDataFetchedListener.regionDataFetched(regionWiseCountryList);
                    //send data to presenter
                    Log.i(TAG, "onResponse: regionWiseCountryList "+regionWiseCountryList.size());
                    // TODO: 4/9/18 add to db possibly
                }
            }

            @Override
            public void onFailure(Call<List<CountryDataBean>> call, Throwable t) {
                    onRegionDataFetchedListener.regionDataFetched(null);
            }
        });
    }
}
