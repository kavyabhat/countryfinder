package com.kvb.countryfinder.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kvb.countryfinder.R;
import com.kvb.countryfinder.model.CountryDataBean;

import java.util.List;

public class CountryListFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private TextView mRegionHeading;
    private List<CountryDataBean> mCountryList;

    public CountryListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        mCountryList = (List<CountryDataBean>) bundle.getSerializable("country_data");

        CountryListAdapter countryListAdapter = new CountryListAdapter(getActivity(), mCountryList);
        mRegionHeading = getActivity().findViewById(R.id.region_heading);
        mRegionHeading.setText("Select a country");
        mRecyclerView = view.findViewById(R.id.region_rv);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(countryListAdapter);
    }
}
