
package com.kvb.countryfinder.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class CountryDataBean implements Serializable {

    @SerializedName("alpha2Code")
    private String mAlpha2Code;
    @SerializedName("alpha3Code")
    private String mAlpha3Code;
    @SerializedName("altSpellings")
    private List<String> mAltSpellings;
    @SerializedName("area")
    private Double mArea;
    @SerializedName("borders")
    private List<String> mBorders;
    @SerializedName("callingCodes")
    private List<String> mCallingCodes;
    @SerializedName("capital")
    private String mCapital;
    @SerializedName("cioc")
    private String mCioc;
    @SerializedName("currencies")
    private List<Currency> mCurrencies;
    @SerializedName("demonym")
    private String mDemonym;
    @SerializedName("flag")
    private String mFlag;
    @SerializedName("gini")
    private Double mGini;
    @SerializedName("languages")
    private List<Language> mLanguages;
    @SerializedName("latlng")
    private List<Double> mLatlng;
    @SerializedName("name")
    private String mName;
    @SerializedName("nativeName")
    private String mNativeName;
    @SerializedName("numericCode")
    private String mNumericCode;
    @SerializedName("population")
    private Long mPopulation;
    @SerializedName("region")
    private String mRegion;
    @SerializedName("regionalBlocs")
    private List<RegionalBloc> mRegionalBlocs;
    @SerializedName("subregion")
    private String mSubregion;
    @SerializedName("timezones")
    private List<String> mTimezones;
    @SerializedName("topLevelDomain")
    private List<String> mTopLevelDomain;
    @SerializedName("translations")
    private Translations mTranslations;

    public String getAlpha2Code() {
        return mAlpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        mAlpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return mAlpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        mAlpha3Code = alpha3Code;
    }

    public List<String> getAltSpellings() {
        return mAltSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        mAltSpellings = altSpellings;
    }

    public Double getArea() {
        return mArea;
    }

    public void setArea(Double area) {
        mArea = area;
    }

    public List<String> getBorders() {
        return mBorders;
    }

    public void setBorders(List<String> borders) {
        mBorders = borders;
    }

    public List<String> getCallingCodes() {
        return mCallingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        mCallingCodes = callingCodes;
    }

    public String getCapital() {
        return mCapital;
    }

    public void setCapital(String capital) {
        mCapital = capital;
    }

    public String getCioc() {
        return mCioc;
    }

    public void setCioc(String cioc) {
        mCioc = cioc;
    }

    public List<Currency> getCurrencies() {
        return mCurrencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        mCurrencies = currencies;
    }

    public String getDemonym() {
        return mDemonym;
    }

    public void setDemonym(String demonym) {
        mDemonym = demonym;
    }

    public String getFlag() {
        return mFlag;
    }

    public void setFlag(String flag) {
        mFlag = flag;
    }

    public Double getGini() {
        return mGini;
    }

    public void setGini(Double gini) {
        mGini = gini;
    }

    public List<Language> getLanguages() {
        return mLanguages;
    }

    public void setLanguages(List<Language> languages) {
        mLanguages = languages;
    }

    public List<Double> getLatlng() {
        return mLatlng;
    }

    public void setLatlng(List<Double> latlng) {
        mLatlng = latlng;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getNativeName() {
        return mNativeName;
    }

    public void setNativeName(String nativeName) {
        mNativeName = nativeName;
    }

    public String getNumericCode() {
        return mNumericCode;
    }

    public void setNumericCode(String numericCode) {
        mNumericCode = numericCode;
    }

    public Long getPopulation() {
        return mPopulation;
    }

    public void setPopulation(Long population) {
        mPopulation = population;
    }

    public String getRegion() {
        return mRegion;
    }

    public void setRegion(String region) {
        mRegion = region;
    }

    public List<RegionalBloc> getRegionalBlocs() {
        return mRegionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
        mRegionalBlocs = regionalBlocs;
    }

    public String getSubregion() {
        return mSubregion;
    }

    public void setSubregion(String subregion) {
        mSubregion = subregion;
    }

    public List<String> getTimezones() {
        return mTimezones;
    }

    public void setTimezones(List<String> timezones) {
        mTimezones = timezones;
    }

    public List<String> getTopLevelDomain() {
        return mTopLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        mTopLevelDomain = topLevelDomain;
    }

    public Translations getTranslations() {
        return mTranslations;
    }

    public void setTranslations(Translations translations) {
        mTranslations = translations;
    }

}
