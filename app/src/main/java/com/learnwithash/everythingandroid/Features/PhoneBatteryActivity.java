package com.learnwithash.everythingandroid.Features;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 10/25/16.
 */
public class PhoneBatteryActivity extends AppCompatActivity {

    private View mView;
    private TextView mBatteryText;
    private ImageView mBatteryIcon;

    private Runnable mRunnable;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_phone_battery);
        mBatteryText = (TextView) findViewById(R.id.tv_battery);
        mBatteryIcon = (ImageView) findViewById(R.id.iv_battery);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                updateBatteryInfo();
                mHandler.postDelayed(mRunnable, 5000);

            }
        };


        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 0);
    }

    public float batteryLevel(){

        Intent batteryIntent =
                registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        if(level == -1 || scale == -1) {
            return 50.0f;
        }

        return ((float)level / (float) scale ) * 100.0f;

    }

    public void updateBatteryInfo(){
        int level = (int) batteryLevel();
        mBatteryText.setText("Battery: " + level + "%");

        if(level == 100){
            mBatteryIcon.setImageResource(R.drawable.battery);
        } else if(level < 100 && level >=90){
            mBatteryIcon.setImageResource(R.drawable.battery_90);
        } else if(level <=50){
            mBatteryIcon.setImageResource(R.drawable.battery_50);
        }
    }
}
