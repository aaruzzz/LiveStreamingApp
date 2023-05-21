package com.research.livestreamingapp.ui.StreamFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.research.livestreamingapp.databinding.FragmentStreamBinding;
import com.research.livestreamingapp.ui.HomeFragment.Categories.HomeStreamFragment;
import com.research.livestreamingapp.ui.StreamFragment.Adapter.RecentlyLivesAdapter;
import com.research.livestreamingapp.ui.StreamFragment.Adapter.UserStatusAdapter;
import com.research.livestreamingapp.ui.StreamFragment.Model.RecentlyLivesModel;

import java.util.ArrayList;
import java.util.List;


public class StreamFragment extends Fragment {

    private FragmentStreamBinding binding;
    HomeStreamFragment homeStreamFragment = new HomeStreamFragment();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentStreamBinding.inflate(inflater, container, false);

        //RecyclerView for Recently Lives
        RecyclerView recentlyLivesRV = binding.liveTournamentRv;

        List<RecentlyLivesModel> items = new ArrayList<>();

        items.add(new RecentlyLivesModel("Mobile Legends", "Live From Las Vegas", "6.8k", "https://i.insider.com/5d8cdb0e2e22af5cab52258d?width=700", "https://www.talkesport.com/wp-content/uploads/mobile-legends-bang-bang-ios-android-logo_JPG_820.jpg", "offline", "Samuel"));


        recentlyLivesRV.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        recentlyLivesRV.setAdapter(new RecentlyLivesAdapter(requireContext().getApplicationContext(), items));


        //RecyclerView for User Status
        RecyclerView userStatusRV = binding.userStatusRv;
        List<RecentlyLivesModel> items1 = new ArrayList<>();

        items1.add(new RecentlyLivesModel("", "", "", "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg?q=10&h=200", "-", "streaming", "Samuel"));
        items1.add(new RecentlyLivesModel("", "", "", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fHww&w=1000&q=80", "", "streaming", "Jack"));
        items1.add(new RecentlyLivesModel("", "", "", "https://static.wikia.nocookie.net/vampirediaries/images/7/74/Katherine-S8.jpg/revision/latest?cb=20170313214107", "-", "online", "Katherine"));
        items1.add(new RecentlyLivesModel("", "", "", "https://storage.pixteller.com/designs/designs-images/2018-07-27/07/profile-phote-avatar-hair-portrait-person-human-1-5b5b4d2479b24.png", "", "online", "Queen"));
        items1.add(new RecentlyLivesModel("", "", "", "https://media.istockphoto.com/id/120713767/photo/beautiful-girl-profile-at-the-river.jpg?s=170667a&w=0&k=20&c=LKohLEN39HTnouht1HnOxkTjPHtNuVkEIbRi2NW6Rc8=", "", "offline", "Gunjan"));
        items1.add(new RecentlyLivesModel("", "", "", "https://media.istockphoto.com/id/1300512215/photo/headshot-portrait-of-smiling-ethnic-businessman-in-office.jpg?s=612x612&w=0&k=20&c=QjebAlXBgee05B3rcLDAtOaMtmdLjtZ5Yg9IJoiy-VY=", "", "offline", "Aarush"));

        userStatusRV.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        userStatusRV.setAdapter(new UserStatusAdapter(requireContext().getApplicationContext(), items1));

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.buttonStream.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(StreamFragment.this)
//                        .navigate(R.id.action_StreamFragment_to_FirstFragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        getParentFragmentManager().beginTransaction().replace(R.id.content, homeStreamFragment).commit();
        binding = null;
    }

}