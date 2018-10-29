package com.kvb.countryfinder.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kvb.countryfinder.R;
import com.kvb.countryfinder.model.CountryDataBean;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<CountryDataBean> mAdapterData;


    public CountryListAdapter(Context context, List<CountryDataBean> countryDataBeanList) {
        mContext = context;
        mAdapterData = countryDataBeanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.country_list_item_main, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CountryViewHolder viewHolder = (CountryViewHolder) holder;
        if(mAdapterData != null) {
            CountryDataBean countryDataBean = mAdapterData.get(position);
            viewHolder.countryName.setText(countryDataBean.getName());
            // TODO: 6/9/18 svg loading is not simplistic from remote source. find better way use androidsvg lib possibly 
            Glide.with(mContext).load(countryDataBean.getFlag()).into(viewHolder.flag);
        }
    }

    @Override
    public int getItemCount() {
        return mAdapterData == null ? 0 : mAdapterData.size();
    }

    private class CountryViewHolder extends RecyclerView.ViewHolder {
        private ImageView flag;
        private TextView countryName;
        public CountryViewHolder(View view) {
            super(view);
            flag = view.findViewById(R.id.country_flag);
            countryName = view.findViewById(R.id.country_name);
        }
    }
}
