package com.agroambles.olavera.flatsmanagement.injector.components;

import com.agroambles.olavera.flatsmanagement.FlatsManagementApplication;
import com.agroambles.olavera.flatsmanagement.injector.modules.AppModule;
import com.agroambles.olavera.flatsmanagement.model.Repository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Olavera
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    FlatsManagementApplication app();
    Repository dataRepository();
}
