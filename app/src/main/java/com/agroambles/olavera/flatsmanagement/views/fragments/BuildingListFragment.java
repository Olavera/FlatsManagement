package com.agroambles.olavera.flatsmanagement.views.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;

import com.agroambles.olavera.flatsmanagement.FlatsManagementApplication;
import com.agroambles.olavera.flatsmanagement.R;
import com.agroambles.olavera.flatsmanagement.injector.components.DaggerBuildingListComponent;
import com.agroambles.olavera.flatsmanagement.injector.modules.ActivityModule;
import com.agroambles.olavera.flatsmanagement.injector.modules.BuildingListModule;
import com.agroambles.olavera.flatsmanagement.mvp.presenters.BuildingListPresenter;
import com.agroambles.olavera.flatsmanagement.mvp.views.BuildingListView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BuildingListFragment extends Fragment implements BuildingListView {

    private OnBuildingListFragmentListener mListener;

    @Inject
    BuildingListPresenter mBuildingListPresenter;
    @InjectView(R.id.blacklist_rlv)
    RecyclerView mBuildingListRecyclerView;
    private BuildingListAdapter mBuildingListAdapter;
    private ProgressDialog mLoadingProgressDialog;

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
        View view = inflater.inflate(R.layout.fragment_building_list, container, false);
        ButterKnife.inject(this, view);

        initializeDependencyInjector();
        initializePresenter();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnBuildingListFragmentListener) activity;
            mListener.onSectionAttached(getString(R.string.section_buildinglist));
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mBuildingListPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBuildingListPresenter.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initializePresenter() {
        mBuildingListPresenter.attachView(this);
        mBuildingListPresenter.attachBundle(getArguments());
        mBuildingListPresenter.initializePresenter();
    }

    private void initializeDependencyInjector() {

        FlatsManagementApplication avengersApplication =
                (FlatsManagementApplication) getActivity().getApplication();

        DaggerBuildingListComponent.builder()
                .appComponent(avengersApplication.getAppComponent())
                .activityModule(new ActivityModule(getActivity()))
                .buildingListModule(new BuildingListModule())
                .build().inject(this);
    }

    public interface OnBuildingListFragmentListener {

        void onSectionAttached(String title);
    }

}
