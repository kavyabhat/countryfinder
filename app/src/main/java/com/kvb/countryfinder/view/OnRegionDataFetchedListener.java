package com.kvb.countryfinder.view;

import com.kvb.countryfinder.model.CountryDataBean;

import java.util.List;

public interface OnRegionDataFetchedListener {
    void regionDataFetched(List<CountryDataBean> countryDataBeanList);
}
