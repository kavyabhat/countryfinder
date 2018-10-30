package com.kvb.countryfinder.network;

import com.kvb.countryfinder.view.OnCountryDetailsFetchedListener;
import com.kvb.countryfinder.view.OnRegionDataFetchedListener;

public interface NetworkLayer {
    void fetchCountrySpecificData(String countryName, OnCountryDetailsFetchedListener onCountryDetailsFetchedListener);

    void fetchCountriesByRegion(String regionName, OnRegionDataFetchedListener onRegionDataFetchedListener);
}
