package com.agroambles.olavera.flatsmanagement.mvp.presenters;

import android.os.Bundle;

import com.agroambles.olavera.flatsmanagement.domain.GetBuildingListUsecase;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;
import com.agroambles.olavera.flatsmanagement.mvp.views.BuildingListView;
import com.agroambles.olavera.flatsmanagement.mvp.views.View;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

/**
 * @author Olavera
 */
public class BuildingListPresenter implements Presenter {

    private BuildingListView mBuildingListView;
    private final GetBuildingListUsecase mGetBuildingListUsecase;
    private Subscription mBuildingListSubscription;

    @Inject
    public BuildingListPresenter(GetBuildingListUsecase getBuildingListUsecase) {
        this.mGetBuildingListUsecase = getBuildingListUsecase;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (!mBuildingListSubscription.isUnsubscribed())
            mBuildingListSubscription.unsubscribe();
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
        mBuildingListSubscription = mGetBuildingListUsecase.execute().subscribe(
                // On Next
                (list) ->  { onNext(list); },
                // On Error
                (throwable) -> { onError(throwable); },
                // On Complete
                () -> { onComplete(); }
        );
    }

    private void onNext(List<Building> buildings) {
        mBuildingListView.showList(buildings);
    }

    private void onError(Throwable e) {

    }

    private void onComplete() {
        mBuildingListView.stopLoading();
    }


}
