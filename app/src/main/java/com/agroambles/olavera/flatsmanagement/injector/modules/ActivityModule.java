package com.agroambles.olavera.flatsmanagement.injector.modules;

import android.content.Context;

import com.agroambles.olavera.flatsmanagement.injector.annotations.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Olavera
 */
@Module
public class ActivityModule {

    private final Context mContext;

    public ActivityModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Activity
    Context provideActivityContext() {
        return mContext;
    }
}
