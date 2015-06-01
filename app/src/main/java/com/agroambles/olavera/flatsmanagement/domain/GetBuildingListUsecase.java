package com.agroambles.olavera.flatsmanagement.domain;

import com.agroambles.olavera.flatsmanagement.model.Repository;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Olavera
 */
public class GetBuildingListUsecase implements Usecase {

    private final Repository mRepository;

    @Inject
    public GetBuildingListUsecase(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Subscription execute(Subscriber subscriber) {
        Subscription subscription = mRepository.getBuildingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        return subscription;
    }
}
