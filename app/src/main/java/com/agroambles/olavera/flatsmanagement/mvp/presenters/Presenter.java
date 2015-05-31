package com.agroambles.olavera.flatsmanagement.mvp.presenters;

import android.content.Intent;

import com.agroambles.olavera.flatsmanagement.mvp.views.View;

/**
 * @author Olavera
 */
public interface Presenter {

    void onStart ();

    void onStop ();

    void attachView (View v);

    void attachIncomingIntent (Intent intent);
}
