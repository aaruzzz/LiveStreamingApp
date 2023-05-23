package com.research.livestreamingapp.ui.HomeFragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.research.livestreamingapp.R;
import com.research.livestreamingapp.databinding.FragmentHomeBinding;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeEsportsFragment;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeMultiplayerFragment;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeOtherFragment;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeStreamFragment;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import nl.bryanderidder.themedtogglebuttongroup.ThemedButton;
import nl.bryanderidder.themedtogglebuttongroup.ThemedToggleButtonGroup;

public class HomeFragment extends Fragment {
    ThemedToggleButtonGroup themedToggleButtonGroup;
    HorizontalScrollView buttonContainer;


    HomeStreamFragment homeStreamFragment = new HomeStreamFragment();
    HomeMultiplayerFragment homeMultiplayerFragment = new HomeMultiplayerFragment();
    HomeEsportsFragment homeEsportsFragment = new HomeEsportsFragment();
    HomeOtherFragment homeOtherFragment = new HomeOtherFragment();


    private FragmentHomeBinding binding;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        themedToggleButtonGroup = requireView().findViewById(R.id.buttons);
        themedToggleButtonGroup.selectButton(R.id.streamBTN);

        buttonContainer = requireView().findViewById(R.id.button_container);
        OverScrollDecoratorHelper.setUpOverScroll(buttonContainer);

        themedToggleButtonGroup.setOnSelectListener((ThemedButton btn) -> {
            String selectedBTN = btn.getText();
            switch (selectedBTN) {
                case "Stream":
                    getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
                    break;
                case "Multiplayer":
                    getParentFragmentManager().beginTransaction().replace(R.id.content, homeMultiplayerFragment).commit();
                    break;
                case "Esports":
                    getParentFragmentManager().beginTransaction().replace(R.id.content, homeEsportsFragment).commit();
                    break;
                case "Other item":
                    getParentFragmentManager().beginTransaction().replace(R.id.content, homeOtherFragment).commit();
                    break;
                default:
                    getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
                    Toast.makeText(getContext(), "Error! This option is under construction!", Toast.LENGTH_SHORT).show();
                    break;
            }
//            Toast.makeText(getContext(), selectedBTN, Toast.LENGTH_SHORT).show();
            return null;
        });

//        getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}