package com.kvb.countryfinder.network;

import com.kvb.countryfinder.view.OnRegionDataFetchedListener;

public interface NetworkLayer {
    void fetchCountrySpecificData(String countryName);

    void fetchCountriesByRegion(String regionName, OnRegionDataFetchedListener onRegionDataFetchedListener);
}
