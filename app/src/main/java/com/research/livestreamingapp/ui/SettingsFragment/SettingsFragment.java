package com.research.livestreamingapp.ui.SettingsFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.research.livestreamingapp.R;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeStreamFragment;

public class SettingsFragment extends Fragment {

    HomeStreamFragment homeStreamFragment = new HomeStreamFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
    }
}