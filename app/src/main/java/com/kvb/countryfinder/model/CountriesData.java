
package com.kvb.countryfinder.model;


import java.util.List;

@SuppressWarnings("unused")
public class CountriesData {
    List<CountryDataBean> countryDataBeanList;

    public void setCountryDataBeanList(List<CountryDataBean> countryDataBeanList) {
        this.countryDataBeanList = countryDataBeanList;
    }

    public List<CountryDataBean> getCountryDataBeanList() {
        return countryDataBeanList;
    }

}
