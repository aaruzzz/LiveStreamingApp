package com.research.livestreamingapp.ui.HomeFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.research.livestreamingapp.R;
import com.research.livestreamingapp.databinding.FragmentHomeBinding;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeEsportsFragment;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeMultiplayerFragment;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeOtherFragment;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeStreamFragment;

import nl.bryanderidder.themedtogglebuttongroup.ThemedButton;
import nl.bryanderidder.themedtogglebuttongroup.ThemedToggleButtonGroup;

public class HomeFragment extends Fragment {
    ThemedToggleButtonGroup themedToggleButtonGroup;
//    ThemedButton streamButton;
//    ThemedButton multiplayerButton;
//    ThemedButton esportsButton;
//    ThemedButton otherButton;

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
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        themedToggleButtonGroup = requireView().findViewById(R.id.buttons);
        themedToggleButtonGroup.selectButton(R.id.streamBTN);
        getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();


//        streamButton = getView().findViewById(R.id.streamBTN);
//        streamButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
//            }
//        });

//        multiplayerButton = getView().findViewById(R.id.multiplayerBTN);
//        multiplayerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getParentFragmentManager().beginTransaction().replace(R.id.content, homeMultiplayerFragment).commit();
//            }
//        });
//
//        esportsButton = getView().findViewById(R.id.esportsBTN);
//        esportsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getParentFragmentManager().beginTransaction().replace(R.id.content, homeEsportsFragment).commit();
//            }
//        });
//
//        otherButton = getView().findViewById(R.id.otherBTN);
//        otherButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getParentFragmentManager().beginTransaction().replace(R.id.content, homeOtherFragment).commit();
//            }
//        });

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
                    Toast.makeText(getContext(), "Error! This option is under construction!", Toast.LENGTH_SHORT).show();
                    break;
            }
//            Toast.makeText(getContext(), selectedBTN, Toast.LENGTH_SHORT).show();
            return null;
        });

//        List<ThemedButton> selectedButtons = themedToggleButtonGroup.getSelectedButtons();
//        Toast.makeText(getContext(), selectedButtons.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}