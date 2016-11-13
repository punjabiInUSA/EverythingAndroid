package com.learnwithash.everythingandroid.Features;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 11/12/16.
 */
public class NotificationResultActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_result);

        //Notification icon on status bar won't go away unless the code below
        //and code in main notification Activity is added
        Intent intent = getIntent();
        int notifyID = intent.getIntExtra("notifyID", 0);

        NotificationManager mgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mgr.cancel(notifyID);
    }
}
