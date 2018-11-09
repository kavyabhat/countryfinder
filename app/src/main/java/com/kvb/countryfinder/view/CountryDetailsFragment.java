package com.kvb.countryfinder.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kvb.countryfinder.R;
import com.kvb.countryfinder.model.CountryDataBean;

public class CountryDetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.country_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        CountryDataBean countryDataBean = (CountryDataBean) bundle.getSerializable("country_detail");
        TextView noContentFound = view.findViewById(R.id.no_content);

        if(countryDataBean != null){

        }else{
            noContentFound.setVisibility(View.VISIBLE);
        }

    }
}
