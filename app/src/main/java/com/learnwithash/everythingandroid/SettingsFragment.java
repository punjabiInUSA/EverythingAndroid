package com.learnwithash.everythingandroid;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.learnwithash.everythingandroid.Features.NotificationsActivity;
import com.learnwithash.everythingandroid.Features.PhoneBatteryActivity;
import com.learnwithash.everythingandroid.Features.ToastAndSnackFragment;

/**
 * Created by Ash on 3/29/17.
 */
public class SettingsFragment extends PreferenceFragment {

    private Intent i;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
//        setEnglishPreference();
//        setHindiPreference();
//        setTeluguPreference();



    }

    public void setEnglishPreference() {
        Preference myPref = findPreference("key_english");
        myPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                replaceFragment(new ToastAndSnackFragment());
                return false;
            }
        });
    }

    public void setHindiPreference() {
        Preference myPref = findPreference("key_hindi");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                launchActivity(NotificationsActivity.class);
                return false;
            }
        });
    }

    public void setTeluguPreference() {
        Preference myPref = findPreference("key_telugu");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                launchActivity(PhoneBatteryActivity.class);
                return false;
            }
        });
    }
    public void replaceFragment(Fragment navigateToFragment) {
        getFragmentManager().beginTransaction().replace(R.id.frameLayout_container,
                navigateToFragment).commit();
    }

    public void launchActivity(Class className){
        i = new Intent(getActivity(),className);
        startActivity(i);
    }

}
