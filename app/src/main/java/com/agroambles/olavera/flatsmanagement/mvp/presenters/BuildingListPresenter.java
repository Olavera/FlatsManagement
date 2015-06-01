package com.agroambles.olavera.flatsmanagement.mvp.presenters;

import android.content.Intent;
import android.os.Bundle;

import com.agroambles.olavera.flatsmanagement.domain.GetBuildingListUsecase;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;
import com.agroambles.olavera.flatsmanagement.mvp.views.BuildingListView;
import com.agroambles.olavera.flatsmanagement.mvp.views.View;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * @author Olavera
 */
public class BuildingListPresenter extends Subscriber<List<Building>> implements Presenter {

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
    public void attachBundle(Bundle bundle) {

    }

    @Override
    public void initializePresenter() {
        mBuildingListView.startLoading();
        mGetBuildingListUsecase.execute(this);
    }

    @Override
    public void onCompleted() {
        mBuildingListView.stopLoading();
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<Building> buildings) {
        mBuildingListView.showList(buildings);
    }
}
