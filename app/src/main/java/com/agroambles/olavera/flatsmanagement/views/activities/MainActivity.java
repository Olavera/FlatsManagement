package com.agroambles.olavera.flatsmanagement.views.activities;

import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import com.agroambles.olavera.flatsmanagement.R;
import com.agroambles.olavera.flatsmanagement.views.Constants;
import com.agroambles.olavera.flatsmanagement.views.fragments.BuildingListFragment;
import com.agroambles.olavera.flatsmanagement.views.fragments.FlatListFragment;
import com.agroambles.olavera.flatsmanagement.views.fragments.FragmentCallbacks;
import com.agroambles.olavera.flatsmanagement.views.Sections;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity
        implements FragmentCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer, mDrawerLayout);
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSectionAttached(String title) {
        mTitle = title;
    }

    @Override
    public void switchFragment(Sections section, Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        switch(section){
            case BUILDING_LIST_FRAGMENT:
                fragment = BuildingListFragment.newInstance();
                break;
            case FLAT_LIST_FRAGMENT:
                long buildingId = bundle.getLong(Constants.BUILDING_ID, -1);
                if(buildingId!=-1) {
                    fragment = FlatListFragment.newInstance(buildingId);
                }
                break;
            default:
                break;
        }
        if(fragment!=null){
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
    }
}
