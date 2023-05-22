package com.research.livestreamingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.research.livestreamingapp.ui.ExploreFragment.ExploreFragment;
import com.research.livestreamingapp.ui.HomeFragment.HomeFragment;
import com.research.livestreamingapp.ui.SettingsFragment.SettingsFragment;
import com.research.livestreamingapp.ui.StreamFragment.StreamFragment;

import java.util.ArrayList;
import java.util.Objects;


public class MainFragment extends Fragment {
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    ExploreFragment exploreFragment = new ExploreFragment();
    StreamFragment streamFragment = new StreamFragment();
    SettingsFragment settingsFragment = new SettingsFragment();


    ImageView imageView;

    ViewPager2 pager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();


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



/*
        pager = rootView.findViewById(R.id.pager);
        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new ExploreFragment());
        fragmentArrayList.add(new StreamFragment());
        fragmentArrayList.add(new SettingsFragment());


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(requireActivity(), fragmentArrayList);
        pager.setAdapter(viewPagerAdapter);
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.navigation_notifications);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);
                        break;
                }
                super.onPageSelected(position);
            }
        });
*/


        bottomNavigationView.setOnItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, new HomeFragment()).commit();
//                        pager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_dashboard:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, exploreFragment).commit();
//                        pager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_notifications:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, streamFragment).commit();
//                        pager.setCurrentItem(2);
                        return true;
                    case R.id.navigation_settings:
                        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, settingsFragment).commit();
//                        pager.setCurrentItem(3);
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