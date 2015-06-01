package com.agroambles.olavera.flatsmanagement.domain;

import com.agroambles.olavera.flatsmanagement.model.Repository;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Olavera
 */
public class GetBuildingListUsecase implements Usecase<List<Building>> {

    private final Repository mRepository;

    @Inject
    public GetBuildingListUsecase(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<List<Building>> execute() {

        return mRepository.getBuildingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
