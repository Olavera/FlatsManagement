package com.agroambles.olavera.flatsmanagement.views.fragments;

import android.os.Bundle;

import com.agroambles.olavera.flatsmanagement.views.Sections;

/**
 * @author Olavera
 */
public interface FragmentCallbacks {

    void onSectionAttached(String title);

    void switchFragment(Sections section, Bundle bundle);
}
