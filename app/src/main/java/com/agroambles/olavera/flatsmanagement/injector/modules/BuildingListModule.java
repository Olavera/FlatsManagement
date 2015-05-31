package com.agroambles.olavera.flatsmanagement.injector.modules;

import com.agroambles.olavera.flatsmanagement.domain.GetBuildingListUsecase;
import com.agroambles.olavera.flatsmanagement.injector.annotations.Activity;
import com.agroambles.olavera.flatsmanagement.model.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * @author Olavera
 */
@Module
public class BuildingListModule {

    public BuildingListModule() {
    }

    @Provides
    @Activity
    GetBuildingListUsecase provideGetBuildingListUsecase (Repository repository) {
        return new GetBuildingListUsecase(repository);
    }

}