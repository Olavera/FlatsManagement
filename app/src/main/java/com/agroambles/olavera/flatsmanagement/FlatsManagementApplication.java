package com.agroambles.olavera.flatsmanagement;

import android.app.Application;

import com.agroambles.olavera.flatsmanagement.injector.components.AppComponent;
import com.agroambles.olavera.flatsmanagement.injector.components.DaggerAppComponent;
import com.agroambles.olavera.flatsmanagement.injector.modules.AppModule;

/**
 * @author Olavera
 */
public class FlatsManagementApplication extends Application{

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependencyInjector();
    }

    private void initializeDependencyInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
