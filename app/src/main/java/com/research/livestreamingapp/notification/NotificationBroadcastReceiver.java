package com.research.livestreamingapp.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_NOTIFICATION_RECEIVED = "com.research.livestreamingapp.ACTION_NOTIFICATION_RECEIVED";
    public static final String EXTRA_NOTIFICATION_FLAG = "com.research.livestreamingapp.EXTRA_NOTIFICATION_FLAG";
    private NotificationListener notificationListener;

    public NotificationBroadcastReceiver(NotificationListener notificationListener) {
        this.notificationListener = notificationListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            int notificationFlag = intent.getIntExtra(EXTRA_NOTIFICATION_FLAG, 0);
            notificationListener.onNotificationReceived(notificationFlag);
        }
    }

    public interface NotificationListener {
        void onNotificationReceived(int notificationFlag);
    }
}
