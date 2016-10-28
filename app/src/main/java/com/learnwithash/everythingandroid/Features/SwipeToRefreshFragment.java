package com.learnwithash.everythingandroid.Features;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 9/13/16.
 */
public class SwipeToRefreshFragment extends BaseFragment implements
        SwipeRefreshLayout.OnRefreshListener{

    private View mView;
    private SwipeRefreshLayout mSwipeLayout;
    private TextView mText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.frag_swipe_to_refresh,container,false);
        initializeViews();
        return mView;
    }

    private void initializeViews(){
        mSwipeLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipe_to_refresh_container);
        mText = (TextView) mView.findViewById(R.id.tv_swipe_to_refresh);
        updateSwipetoRefreshColors();
        mSwipeLayout.setOnRefreshListener(this);
    }

    private void updateSwipetoRefreshColors () {
        mSwipeLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright
                ,getActivity().getTheme()),
                getResources().getColor(android.R.color.holo_green_light,getActivity().getTheme()
                ),getResources().getColor(android.R.color.holo_orange_light,getActivity().getTheme()),
                getResources().getColor(android.R.color.holo_red_light,getActivity().getTheme()));
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeLayout.setRefreshing(false);
                mView.setBackground(getResources().getDrawable(R.drawable.background_white,
                        getActivity().getTheme()));
            }
        },5000);
    }
}
