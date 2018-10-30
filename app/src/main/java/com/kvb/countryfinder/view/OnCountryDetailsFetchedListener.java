package com.kvb.countryfinder.view;


import com.kvb.countryfinder.model.CountryDataBean;

public interface OnCountryDetailsFetchedListener {
    void countryDataFetched(CountryDataBean countryDataBeanList);
}
