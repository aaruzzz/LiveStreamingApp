package com.research.livestreamingapp;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.messaging.FirebaseMessaging;
import com.research.livestreamingapp.databinding.ActivityMainBinding;
import com.research.livestreamingapp.notification.NotificationBroadcastReceiver;


public class MainActivity extends AppCompatActivity implements NotificationBroadcastReceiver.NotificationListener{
    private NotificationBroadcastReceiver receiver;
    private int notificationFlag = 0;
    private TextView notificationBadge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.research.livestreamingapp.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        notificationBadge = findViewById(R.id.notification_badge);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");

        receiver = new NotificationBroadcastReceiver(this);
        IntentFilter filter = new IntentFilter(NotificationBroadcastReceiver.ACTION_NOTIFICATION_RECEIVED);
        registerReceiver(receiver, filter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }


    @Override
    public void onNotificationReceived(int notificationFlag) {
        this.notificationFlag = notificationFlag;
        updateNotificationBadge();
    }

    private void updateNotificationBadge() {
        notificationBadge = findViewById(R.id.notification_badge);

        if (notificationBadge != null) {
            if (notificationFlag > 0) {
                notificationBadge.setText(String.valueOf(notificationFlag));
                notificationBadge.setVisibility(View.VISIBLE);
            } else {
                notificationBadge.setVisibility(View.GONE);
            }
        }
    }


}