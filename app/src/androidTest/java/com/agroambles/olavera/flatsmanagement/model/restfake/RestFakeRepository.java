package com.agroambles.olavera.flatsmanagement.model.restfake;

import com.agroambles.olavera.flatsmanagement.model.Repository;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * @author Olavera
 */
public class RestFakeRepository implements Repository{

    @Inject
    public RestFakeRepository() {
    }

    @Override
    public Observable<List<Building>> getBuildingList() {
        List<Building> list = new ArrayList<>();
        list.add(new Building("Mirasierra 1"));
        list.add(new Building("Mirasierra 2"));
        list.add(new Building("Plaza españa"));
        list.add(new Building("Torre Kio"));
        list.add(new Building("Torre de Benidorm"));
        list.add(new Building("Babel"));
        list.add(new Building("Escosura"));
        list.add(new Building("Pinosalta"));
        list.add(new Building("Romeria"));
        list.add(new Building("Carranza"));
        PublishSubject<List<Building>> ob = PublishSubject.create();
        ob.onNext(list);
        return ob;
    }
}
