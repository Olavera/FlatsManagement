package com.agroambles.olavera.flatsmanagement.mvp.presenters;

import android.content.Intent;
import android.os.Bundle;

import com.agroambles.olavera.flatsmanagement.domain.GetBuildingListUsecase;
import com.agroambles.olavera.flatsmanagement.mvp.views.BuildingListView;
import com.agroambles.olavera.flatsmanagement.mvp.views.View;

import javax.inject.Inject;

/**
 * @author Olavera
 */
public class BuildingListPresenter implements Presenter {

    private BuildingListView mBuildingListView;
    private final GetBuildingListUsecase mGetBuildingListUsecase;

    @Inject
    public BuildingListPresenter(GetBuildingListUsecase getBuildingListUsecase) {
        this.mGetBuildingListUsecase = getBuildingListUsecase;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void attachView(View view) {
        mBuildingListView = (BuildingListView) view;
    }

    @Override
    public void attachIncomingIntent(Bundle bundle) {

    }

    @Override
    public void initializePresenter() {

        //mBuildingListView.startLoading();

        //mGetBuildingListUsecase.execute(this);
    }
}
