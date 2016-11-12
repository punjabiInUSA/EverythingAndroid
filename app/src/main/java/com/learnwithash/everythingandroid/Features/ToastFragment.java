package com.learnwithash.everythingandroid.Features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 11/11/16.
 */
public class ToastFragment extends BaseFragment {

    private View mView;
    private RadioButton mRadioBtnOne, mRadioButtonTwo, mRadioButtonThree;
    private Toast mToast;
    private RelativeLayout mLayout;
    private int mDuration;
    private Button mRepeatBtn, mCancelBtn, mNextBtn;
    private RadioGroup mRadioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.frag_toast_messages, container, false);
        init();
        return mView;
    }

    private void init() {
        mRadioBtnOne = (RadioButton) mView.findViewById(R.id.rb_one);
        mRadioButtonTwo = (RadioButton) mView.findViewById(R.id.rb_two);
        mRadioButtonThree = (RadioButton) mView.findViewById(R.id.rb_three);
        mRepeatBtn = (Button) mView.findViewById(R.id.btn_repeat);
        mRadioGroup = (RadioGroup) mView.findViewById(R.id.rg_container);
        mCancelBtn = (Button) mView.findViewById(R.id.nav_secondary_btn);
        mNextBtn = (Button) mView.findViewById(R.id.nav_primary_btn);
        mLayout = (RelativeLayout) mView.findViewById(R.id.toast_frag_container);
        checkSettings();
        attachListeners();

    }

    private void checkSettings() {

            if(mRadioBtnOne.isChecked()){
                mDuration = Toast.LENGTH_SHORT;
                regularToast();
            } else if (mRadioButtonTwo.isChecked()) {
                mDuration = Toast.LENGTH_LONG;
                regularToast();
            } else if (mRadioButtonThree.isChecked()){
                customToast();
            }

    }

    private void regularToast() {
        mToast = Toast.makeText(getActivity(), "Hello from here", mDuration);
        mToast.setGravity(Gravity.CENTER | Gravity.START, 100, 100);
        mToast.show();
    }

    private void customToast() {
        //Creating Custom View Object
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, (ViewGroup)
                mView.findViewById(R.id.customToastLayoutContainer));

        //Setting text in custom toast layout
        TextView tv = (TextView)layout.findViewById(R.id.custom_toast_tv);
        tv.setText("Custom Toast Message");

        Toast t = new Toast(getActivity().getApplicationContext());
        t.setDuration(mDuration);
        t.setGravity(Gravity.TOP | Gravity.END, 50, 50);
        t.setView(layout);
        t.show();
    }

    private void attachListeners() {
        mRadioBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRadioButtonTwo.isChecked()) {
                    unCheckRadioButton(mRadioButtonTwo, false);
                }
            }
        });

        mRadioButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRadioBtnOne.isChecked()) {
                    unCheckRadioButton(mRadioBtnOne, false);
                }
            }
        });

        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRadioGroup.clearCheck();
            }
        });

        mRepeatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSettings();
            }
        });

    }

    private void unCheckRadioButton(RadioButton rb, boolean value) {
        rb.setChecked(value);
    }




}
