
package com.kvb.countryfinder.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Currency {

    @SerializedName("code")
    private String mCode;
    @SerializedName("name")
    private String mName;
    @SerializedName("symbol")
    private String mSymbol;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
    }

}
