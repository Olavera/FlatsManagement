package com.agroambles.olavera.flatsmanagement.injector.components;

import android.content.Context;

import com.agroambles.olavera.flatsmanagement.injector.annotations.Activity;
import com.agroambles.olavera.flatsmanagement.injector.modules.ActivityModule;

import dagger.Component;

/**
 * @author Olavera
 */
@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Context context();

}
