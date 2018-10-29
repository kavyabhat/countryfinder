package com.kvb.countryfinder.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kvb.countryfinder.R;
import com.kvb.countryfinder.network.NetworkLayer;
import com.kvb.countryfinder.network.NetworkLayerImpl;

import java.util.List;

public class RegionGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<String> mAdapterData;
    private OnRegionDataFetchedListener listener;
    NetworkLayer networkLayer;


    public RegionGridAdapter(Context context, List<String> regionList, OnRegionDataFetchedListener listener) {
        mContext = context;
        mAdapterData = regionList;
        this.listener = listener;
        networkLayer = new NetworkLayerImpl();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.region_list_item_main, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CountryViewHolder viewHolder = (CountryViewHolder) holder;
        if(mAdapterData != null) {
            String region = mAdapterData.get(position);
            viewHolder.regionName.setText(region);
        }
    }

    @Override
    public int getItemCount() {
        return mAdapterData == null ? 0 : mAdapterData.size();
    }

    private class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView regionName;
        public CountryViewHolder(View view) {
            super(view);
            regionName = view.findViewById(R.id.region_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//        networkLayer.fetchCountrySpecificData("india");
            TextView region = view.findViewById(R.id.region_name);
            networkLayer.fetchCountriesByRegion(region.getText().toString(), listener);
        }
    }
}
