package com.agroambles.olavera.flatsmanagement.views.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agroambles.olavera.flatsmanagement.FlatsManagementApplication;
import com.agroambles.olavera.flatsmanagement.R;
import com.agroambles.olavera.flatsmanagement.injector.modules.ActivityModule;

public class BuildingListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public static BuildingListFragment newInstance() {
        BuildingListFragment fragment = new BuildingListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public BuildingListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_building_list, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initializePresenter() {
        mBuildingListPresenter.attachView(this);
    }

    private void initializeDependencyInjector() {

        FlatsManagementApplication avengersApplication =
                (FlatsManagementApplication) getActivity().getApplication();

        DaggerBuildingListComponent.builder()
                .appComponent(avengersApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .buildingListModule(new BuildingListModule())
                .build().inject(this);
    }

    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }

}
