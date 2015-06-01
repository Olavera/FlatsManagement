package com.agroambles.olavera.flatsmanagement.mvp.views;

import com.agroambles.olavera.flatsmanagement.model.entities.Building;

import java.util.List;

/**
 * @author Olavera
 */
public interface BuildingListView extends View {

    void startLoading();

    void stopLoading();

    void showList(List<Building> buildings);
}
