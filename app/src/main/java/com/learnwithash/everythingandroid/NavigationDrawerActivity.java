package com.learnwithash.everythingandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/**
 *
 */
public class NavigationDrawerActivity extends AppCompatActivity{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        initializeViews();
    }

    private void initializeViews(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_container);
        //TODO: Enable navigation view once, drawer item(s) have been implemented
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_container);
//        navigationView.setNavigationItemSelectedListener(this);
        enableToolbar();
        enabledHomeButton();
        enabledHamBurgerIcon();

    }

    private void enableToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    private void enabledHomeButton(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    private void enabledHamBurgerIcon(){

    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open_drawer_tag,
                R.string.close_drawer_tag) {

        @Override
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            invalidateOptionsMenu();
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            invalidateOptionsMenu();
        }
    };

        //Enables actual icon visibility for drawer navigation
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        //Enables listener functionality for open and close nav drawer
        // Useful if you want to set action bar title so something else when drawer is closed
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        //Also required to visually display hamburger icon
        mDrawerToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            default:
                //Required to sync click on actionbar to open and close drawer
                mDrawerToggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
