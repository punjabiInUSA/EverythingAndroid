package com.learnwithash.everythingandroid;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.learnwithash.everythingandroid.Features.PhoneBatteryActivity;
import com.learnwithash.everythingandroid.Features.SwipeToRefreshFragment;

/**
 *
 */
public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Fragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        initializeViews();
    }

    private void initializeViews(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_container);
        enableToolbar();
        enableUpButton();
        enabledHamBurgerIcon();
        navDrawerItemClickHandler();

    }

    private void navDrawerItemClickHandler() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView_container);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void enableToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    private void enableUpButton(){
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_item_swipeToRefresh:
                mFragment = new SwipeToRefreshFragment();
                Toast.makeText(NavigationDrawerActivity.this, item.getTitle().toString()
                        + " selected", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.frameLayout_container,
                        mFragment)
                .commit();
                break;

            case R.id.nav_fingerPrint_scanner:
                Toast.makeText(NavigationDrawerActivity.this, item.getTitle().toString()
                        +" selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_phone_battery:
                Intent launchActivity = new Intent(this,PhoneBatteryActivity.class);
                startActivity(launchActivity);
                Toast.makeText(NavigationDrawerActivity.this, item.getTitle().toString()
                        + " selected", Toast.LENGTH_SHORT).show();
                break;
        }
        mDrawerLayout.closeDrawers();
        return false;
    }

    }
