package com.agroambles.olavera.flatsmanagement.domain;

import com.agroambles.olavera.flatsmanagement.model.Repository;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;

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
        return null;
    }
}
