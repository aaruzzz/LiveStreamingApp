package com.research.livestreamingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.research.livestreamingapp.ui.ExploreFragment.ExploreFragment;
import com.research.livestreamingapp.ui.HomeFragment.HomeFragment;
import com.research.livestreamingapp.ui.SettingsFragment.SettingsFragment;
import com.research.livestreamingapp.ui.StreamFragment.StreamFragment;


public class MainFragment extends Fragment {
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    ExploreFragment exploreFragment = new ExploreFragment();
    StreamFragment streamFragment = new StreamFragment();
    SettingsFragment settingsFragment = new SettingsFragment();


    ImageView imageView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        bottomNavigationView = rootView.findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, homeFragment).commit();
                        return true;
                    case R.id.navigation_dashboard:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, exploreFragment).commit();
                        return true;
                    case R.id.navigation_notifications:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, streamFragment).commit();
                        return true;
                    case R.id.navigation_settings:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, settingsFragment).commit();
                        return true;
                }
            return false;
        });

        imageView = rootView.findViewById(R.id.notification_bell_icon);
        imageView.setOnClickListener(view -> NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_MainFragment_to_NotificationFragment));


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }
}