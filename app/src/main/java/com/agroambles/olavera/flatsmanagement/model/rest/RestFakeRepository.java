package com.agroambles.olavera.flatsmanagement.model.rest;

import com.agroambles.olavera.flatsmanagement.model.Repository;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

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
        list.add(new Building(1, "Mirasierra 1"));
        list.add(new Building(2, "Mirasierra 2"));
        list.add(new Building(3, "Plaza españa"));
        list.add(new Building(4, "Torre Kio"));
        list.add(new Building(5, "Torre de Benidorm"));
        list.add(new Building(6, "Babel"));
        list.add(new Building(7, "Escosura"));
        list.add(new Building(8, "Pinosalta"));
        list.add(new Building(9, "Romeria"));
        list.add(new Building(10, "Carranza"));
        return Observable.just(list);
    }
}
