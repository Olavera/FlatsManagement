package com.agroambles.olavera.flatsmanagement.views.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agroambles.olavera.flatsmanagement.FlatsManagementApplication;
import com.agroambles.olavera.flatsmanagement.R;
import com.agroambles.olavera.flatsmanagement.injector.components.DaggerBuildingListComponent;
import com.agroambles.olavera.flatsmanagement.injector.modules.ActivityModule;
import com.agroambles.olavera.flatsmanagement.injector.modules.BuildingListModule;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;
import com.agroambles.olavera.flatsmanagement.mvp.presenters.BuildingListPresenter;
import com.agroambles.olavera.flatsmanagement.mvp.views.BuildingListView;
import com.agroambles.olavera.flatsmanagement.views.Constants;
import com.agroambles.olavera.flatsmanagement.views.Sections;
import com.agroambles.olavera.flatsmanagement.views.adapters.BuildingListAdapter;
import com.agroambles.olavera.flatsmanagement.views.utils.DividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BuildingListFragment extends Fragment implements BuildingListView,
        BuildingListAdapter.BuildingListAdapterCallbacks {

    private FragmentCallbacks mListener;

    @Inject
    BuildingListPresenter mBuildingListPresenter;
    @InjectView(R.id.rv_building_list)
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
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_building_list, container, false);
        ButterKnife.inject(this, view);

        initializeDependencyInjector();
        initializeProgressDialog();
        initializeBuildingListRecyclerView();
        initializePresenter();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (FragmentCallbacks) activity;
            mListener.onSectionAttached(getString(R.string.str_section_building_list));
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

    private void initializeDependencyInjector() {
        FlatsManagementApplication avengersApplication =
                (FlatsManagementApplication) getActivity().getApplication();

        DaggerBuildingListComponent.builder()
                .appComponent(avengersApplication.getAppComponent())
                .activityModule(new ActivityModule(getActivity()))
                .buildingListModule(new BuildingListModule())
                .build().inject(this);
    }

    private void initializeProgressDialog(){
        mLoadingProgressDialog = new ProgressDialog(getActivity());
        mLoadingProgressDialog.setCancelable(false);
        mLoadingProgressDialog.setMessage(getString(R.string.str_loading));
    }

    private void initializeBuildingListRecyclerView () {
        //recyclerView.setHasFixedSize(true);

        // RecyclerView layout manager
        mBuildingListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mBuildingListRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

        // RecyclerView adapter
        mBuildingListAdapter = new BuildingListAdapter(this);
        mBuildingListRecyclerView.setAdapter(mBuildingListAdapter);
    }

    private void initializePresenter() {
        mBuildingListPresenter.attachView(this);
        mBuildingListPresenter.attachBundle(getArguments());
        mBuildingListPresenter.initializePresenter();
    }

    @Override
    public void OnItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putLong(Constants.BUILDING_ID, mBuildingListAdapter.getItemId(position));
        mListener.switchFragment(Sections.FLAT_LIST_FRAGMENT, bundle);
    }

    @Override
    public void startLoading() {
        mLoadingProgressDialog.show();
    }

    @Override
    public void stopLoading() {
        mLoadingProgressDialog.dismiss();
    }

    @Override
    public void showList(List<Building> buildings) {
        mBuildingListAdapter.appendList(buildings);
    }

}
