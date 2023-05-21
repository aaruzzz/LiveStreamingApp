package com.research.livestreamingapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.research.livestreamingapp.R;
import com.research.livestreamingapp.ui.HomeFragment.HomeFragment;


public class NotificationFragment extends Fragment {
    HomeFragment homeFragment = new HomeFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);

        ImageView backButton = rootView.findViewById(R.id.back_arrow);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(NotificationFragment.this).navigate(R.id.action_NotificationFragment_to_HomeFragment);
//            }
//        });


        // Inflate the layout for this fragment
        return rootView;

    }

    public void onDestroyView() {
        super.onDestroyView();
        getParentFragmentManager().beginTransaction().replace(R.id.middle_content_fragment, homeFragment).commit();
    }


}