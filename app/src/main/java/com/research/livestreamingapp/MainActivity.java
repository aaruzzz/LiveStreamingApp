package com.research.livestreamingapp;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.research.livestreamingapp.databinding.ActivityMainBinding;
import com.research.livestreamingapp.notification.NotificationBroadcastReceiver;
import com.research.livestreamingapp.ui.HomeFragment.HomeFragment;
import com.research.livestreamingapp.ui.NotificationFragment;
import com.research.livestreamingapp.ui.StreamFragment.StreamFragment;

public class MainActivity extends AppCompatActivity implements NotificationBroadcastReceiver.NotificationListener{
    private NotificationBroadcastReceiver receiver;
    private int notificationFlag = 0;
    private TextView notificationBadge;
    BottomNavigationView bottomNavigationView;
    ImageView notificationIcon;
    HomeFragment homeFragment = new HomeFragment();
    StreamFragment streamFragment = new StreamFragment();
    NotificationFragment notificationFragment = new NotificationFragment();

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


//        bottomNavigationView = findViewById(R.id.nav_view);
//        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch ( item.getItemId()){
//                case R.id.navigation_home:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, homeFragment).commit();
//                    return true;
//                case R.id.navigation_notifications:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, streamFragment).commit();
//                    return true;
//            }
//            return true;
//        });

//        notificationIcon = findViewById(R.id.notification_bell_icon);
//        notificationIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.whole, notificationFragment).commit();
//            }
//        });


//        replaceFragment(new HomeFragment());
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
//        bottomNavigationView.setBackground(null);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()){
//                case R.id.navigation_home:
////                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.navigation_notifications:
//                    replaceFragment(new StreamFragment());
//                    break;
//            }
//            return true;
//        });

    }




//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
//        if (currentFragment != null) {
//            fragmentTransaction.remove(currentFragment);
//        }
//        fragmentTransaction.addToBackStack(null);
//
//
//        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment).setPrimaryNavigationFragment(fragment).commit();
//    }

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