package com.learnwithash.everythingandroid.Features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 11/11/16.
 */
public class ToastFragment extends BaseFragment {

    private View mView;
    private RadioButton mButtonOne, mButtonTwo;
    private Toast mToast;
    private int mDuration;
    private RelativeLayout mLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.frag_toast_messages, container, false);
        init();
        return mView;
    }

    private void init() {
        mButtonOne = (RadioButton) mView.findViewById(R.id.rb_one);
        mButtonTwo = (RadioButton) mView.findViewById(R.id.rb_two);
        mLayout = (RelativeLayout) mView.findViewById(R.id.toast_frag_container);
        if (mToast == null) {
            mToast = Toast.makeText(getActivity(), "Hello from here", Toast.LENGTH_LONG);
            mToast.show();
            mToast.setGravity(Gravity.CENTER | Gravity.START, 100, 100);
        }
        attachListeners();

    }

    private void attachListeners() {
        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonTwo.isChecked()) {
                    unCheckRadioButton(mButtonTwo, false);
                }
            }
        });

        mButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonOne.isChecked()) {
                    unCheckRadioButton(mButtonOne, false);
                }
            }
        });

        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unCheckRadioButton(mButtonOne, false);
                unCheckRadioButton(mButtonTwo, false);
            }
        });
    }

    private void unCheckRadioButton(RadioButton rb, boolean value) {
        rb.setChecked(value);
    }




}
