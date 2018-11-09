package com.kvb.countryfinder.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kvb.countryfinder.R;
import com.kvb.countryfinder.model.CountryDataBean;
import com.kvb.countryfinder.utils.RegionConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegionFragment extends Fragment implements OnRegionDataFetchedListener{
    private static final String TAG = "RegionFragment";
    private RecyclerView mRecyclerView ;
    private TextView mRegionHeading;
    private TextView mNoContentView;

    public static RegionFragment newInstance() {
        Bundle args = new Bundle();
        RegionFragment fragment = new RegionFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<String> regionList = new ArrayList<>();
        regionList.add(RegionConstants.Africa.toString());
        regionList.add(RegionConstants.Americas.toString());
        regionList.add(RegionConstants.Asia.toString());
        regionList.add(RegionConstants.Europe.toString());
        regionList.add(RegionConstants.Oceania.toString());

        RegionGridAdapter regionGridAdapter = new RegionGridAdapter(getActivity(), regionList, this);
        mNoContentView = view.findViewById(R.id.no_content);
        mRegionHeading = getActivity().findViewById(R.id.region_heading);
        mRegionHeading.setText("Choose a Region");
        mRecyclerView = view.findViewById(R.id.region_rv);
        mRecyclerView.setLayoutManager( new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setAdapter(regionGridAdapter);
    }

    @Override
    public void regionDataFetched(List<CountryDataBean> countryDataBeanList) {
        Log.i(TAG, "regionDataFetched: show country list now. Better open another fragment");

        mNoContentView = getView().findViewById(R.id.no_content);
        mRegionHeading = getActivity().findViewById(R.id.region_heading);
        mRecyclerView = getView().findViewById(R.id.region_rv);

        if(countryDataBeanList != null) {
            /*regionHeading.text = "Select a country"
            val countryListAdapter = CountryListAdapter(this, countryDataBeanList)
            recyclerView.layoutManager = LinearLayoutManager(this)
            mRecyclerView.adapter = countryListAdapter*/
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            CountryListFragment countryListFragment = new CountryListFragment();
            Bundle args = new Bundle();
            args.putSerializable("country_data", (Serializable) countryDataBeanList);
            countryListFragment.setArguments(args);
            fragmentManager.beginTransaction().replace(R.id.fragment_container, countryListFragment, "Countries").addToBackStack(null).commit();
            mNoContentView.setVisibility(View.GONE);
            mRegionHeading.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }else{
            mNoContentView.setVisibility(View.VISIBLE);
            mRegionHeading.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.GONE);
        }
    }
}

