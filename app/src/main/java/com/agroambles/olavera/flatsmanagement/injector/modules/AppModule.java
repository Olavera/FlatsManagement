package com.agroambles.olavera.flatsmanagement.injector.modules;

import com.agroambles.olavera.flatsmanagement.FlatsManagementApplication;
import com.agroambles.olavera.flatsmanagement.model.Repository;
import com.agroambles.olavera.flatsmanagement.model.rest.RestFakeRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Olavera
 */
@Module
public class AppModule {

    private final FlatsManagementApplication mFlatsManagementsApplication;

    public AppModule (FlatsManagementApplication flatsManagementApplication) {
        this.mFlatsManagementsApplication = flatsManagementApplication;
    }

    @Provides
    @Singleton
    FlatsManagementApplication provideFlatsManagementApplication () {
        return mFlatsManagementsApplication;
    }

    @Provides
    @Singleton
    Repository provideDataRepository (RestFakeRepository restRepository) {
        return restRepository;
    }
}
