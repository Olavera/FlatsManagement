package com.agroambles.olavera.flatsmanagement.model;

import com.agroambles.olavera.flatsmanagement.model.entities.Building;

import java.util.List;

import rx.Observable;

/**
 * @author Olavera
 */
public interface Repository {

    public Observable<List<Building>> getBuildingList();
}
