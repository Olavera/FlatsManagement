package com.agroambles.olavera.flatsmanagement.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agroambles.olavera.flatsmanagement.R;
import com.agroambles.olavera.flatsmanagement.views.Constants;

public class FlatListFragment extends Fragment {

    private long mBuildingId;

    public static FlatListFragment newInstance(long buildingId) {
        FlatListFragment fragment = new FlatListFragment();
        Bundle args = new Bundle();
        args.putLong(Constants.BUILDING_ID, buildingId);
        fragment.setArguments(args);
        return fragment;
    }

    public FlatListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBuildingId = getArguments().getLong(Constants.BUILDING_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flat_list, container, false);
    }


}
