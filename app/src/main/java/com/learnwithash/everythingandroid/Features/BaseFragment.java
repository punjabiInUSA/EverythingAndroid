package com.learnwithash.everythingandroid.Features;

import android.app.Fragment;
import android.content.Intent;

/**
 * Created by Ash on 9/13/16.
 */
public class BaseFragment extends Fragment{


    protected final void launchActivity(Class activityClass, boolean finishActivity){
        Intent i = new Intent(getActivity(), activityClass);
        startActivity(i);
        if(finishActivity){
            getActivity().finish();
        }
    }

    protected final void replaceFragment(int containerId, Fragment fragmentName){
        getFragmentManager().beginTransaction().replace(containerId, fragmentName).commit();
    }

    protected final void replaceFragment(int containerId, Fragment fragmentName, String tag){
        getFragmentManager().beginTransaction().replace(containerId, fragmentName, tag).commit();
    }

}
