package com.agroambles.olavera.flatsmanagement.mvp.presenters;

import android.os.Bundle;

import com.agroambles.olavera.flatsmanagement.mvp.views.View;

/**
 * @author Olavera
 */
public interface Presenter {

    void onStart ();

    void onStop ();

    void attachView (View v);

    void attachIncomingIntent (Bundle bundle);

    void initializePresenter();
}
