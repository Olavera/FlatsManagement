package com.agroambles.olavera.flatsmanagement.injector.components;

import com.agroambles.olavera.flatsmanagement.domain.GetBuildingListUsecase;
import com.agroambles.olavera.flatsmanagement.injector.annotations.Activity;
import com.agroambles.olavera.flatsmanagement.injector.modules.ActivityModule;
import com.agroambles.olavera.flatsmanagement.injector.modules.BuildingListModule;
import com.agroambles.olavera.flatsmanagement.views.fragments.BuildingListFragment;

import dagger.Component;

/**
 * @author Olavera
 */
@Activity
@Component(dependencies = AppComponent.class, modules = {BuildingListModule.class, ActivityModule.class})
public interface BuildingListComponent extends ActivityComponent {

    void inject (BuildingListFragment buildingListFragment);

    GetBuildingListUsecase getCharacerInformationUsecase();
}