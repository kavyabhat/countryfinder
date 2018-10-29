
package com.kvb.countryfinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class RegionalBloc {

    @SerializedName("acronym")
    private String mAcronym;
    @SerializedName("name")
    private String mName;
    @SerializedName("otherAcronyms")
    private List<Object> mOtherAcronyms;
    @SerializedName("otherNames")
    private List<Object> mOtherNames;

    public String getAcronym() {
        return mAcronym;
    }

    public void setAcronym(String acronym) {
        mAcronym = acronym;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<Object> getOtherAcronyms() {
        return mOtherAcronyms;
    }

    public void setOtherAcronyms(List<Object> otherAcronyms) {
        mOtherAcronyms = otherAcronyms;
    }

    public List<Object> getOtherNames() {
        return mOtherNames;
    }

    public void setOtherNames(List<Object> otherNames) {
        mOtherNames = otherNames;
    }

}
