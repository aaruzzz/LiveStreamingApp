package com.research.livestreamingapp.notification;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static int notificationFlag;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);

        notificationFlag++;

        //Send a broadcast with notification flag value
        Intent intent = new Intent(NotificationBroadcastReceiver.ACTION_NOTIFICATION_RECEIVED);
        intent.putExtra(NotificationBroadcastReceiver.EXTRA_NOTIFICATION_FLAG, notificationFlag);
        sendBroadcast(intent);
    }

}
