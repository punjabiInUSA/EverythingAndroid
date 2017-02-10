package com.learnwithash.everythingandroid.Features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 2/9/17.
 */
public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mNumber,mSubtext1, mSubText2;
    private Button mButton;
    private Animation mFadeInAnimation, mSubFadeIn;


    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.button1:
                mNumber.setVisibility(View.VISIBLE);
                mNumber.startAnimation(mFadeInAnimation);
                int temp = Integer.parseInt(mNumber.getText().toString());
                int result = temp + 1;
                String abc = String.valueOf(result);
                mNumber.setText(abc);
                mSubText2.startAnimation(mFadeInAnimation);
                mSubtext1.startAnimation(mFadeInAnimation);
                break;
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mNumber = (TextView) findViewById(R.id.numberText);
        mSubtext1 = (TextView) findViewById(R.id.subText1);
        mSubText2 = (TextView) findViewById(R.id.subText2);
        mButton = (Button) findViewById(R.id.button1);
        mFadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        mSubFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_subtext);
        mButton.setOnClickListener(this);
    }
}
