package com.learnwithash.everythingandroid.Features;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 11/12/16.
 */
public class NotificationsActivity extends AppCompatActivity implements View.OnClickListener {

    private View mView;
    private static final int NOTIFY_ID = 3176;
    private Button mNotifyButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mNotifyButton = (Button) findViewById(R.id.btn_notification);
        mNotifyButton.setOnClickListener(this);

    }

    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        Intent intent = new Intent(this, NotificationResultActivity.class);
        //Notification icon stays when open through action button. It would go away with putExtra
        //Line below.
        intent.putExtra("notifyID", NOTIFY_ID);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFY_ID, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        //Three Items that are required by all notifications
        //Small icon, title and description text

        builder.setSmallIcon(R.drawable.repeat_btn_icon);
        builder.setContentTitle("New Message Received");
        builder.setContentText("Hey, I was wondering...");

        // When user taps, the notification should auto cancel with the line below
        builder.setAutoCancel(true);

        //Adding a larger icon
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        //Adding a subtext that appears below the content message
        builder.setSubText("Tap to View");

        //Adding a content intent
        builder.setContentIntent(pendingIntent);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("This is a big notification");
        bigTextStyle.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        builder.setStyle(bigTextStyle);


        //Adding action button on the notification
        builder.addAction(R.mipmap.ic_launcher,"Action 1", pendingIntent);
        builder.addAction(R.mipmap.ic_launcher,"Action 2", pendingIntent);


        //Finally display notification
        Notification notify = builder.build();
        NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mgr.notify(NOTIFY_ID, notify);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_notification:
                createNotification();
                break;
        }
    }
}
