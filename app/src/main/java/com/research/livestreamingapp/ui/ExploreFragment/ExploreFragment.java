package com.research.livestreamingapp.ui.ExploreFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.research.livestreamingapp.R;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeStreamFragment;

public class ExploreFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        HomeStreamFragment homeStreamFragment = new HomeStreamFragment();
//        getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
    }
}