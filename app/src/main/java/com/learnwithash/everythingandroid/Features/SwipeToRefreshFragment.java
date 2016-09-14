package com.learnwithash.everythingandroid.Features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 9/13/16.
 */
public class SwipeToRefreshFragment extends BaseFragment {

    private View mView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.frag_swipe_to_refresh,container,false);
        return mView;
    }
}
