package com.research.livestreamingapp.ui.HomeFragment.Categories;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.research.livestreamingapp.R;
import com.research.livestreamingapp.ui.HomeFragment.Adapter.LiveTournamentAdapter;
import com.research.livestreamingapp.ui.HomeFragment.Adapter.PopularGamesAdapter;
import com.research.livestreamingapp.ui.HomeFragment.Model.LiveTournamentModel;
import com.research.livestreamingapp.ui.HomeFragment.Model.PopularGamesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.widget.Toast;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;


public class HomeStreamFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_stream, container, false);



        //RecyclerView for Live Tournament

        RecyclerView recyclerView = rootView.findViewById(R.id.live_tournament_rv);

        List<LiveTournamentModel> items = new ArrayList<>();

        items.add(new LiveTournamentModel("Capitulo 2 Fortnite", "Weekly tournament", "https://wallpaper.dog/large/564320.jpg"));
        items.add(new LiveTournamentModel("Mid-Season Invitational 2023", "Daily tournament", "https://cdn.gfinityesports.com/images/ncavvykf/gfinityesports/62a1e81e80eb149330d328e9ba1f2512f73d606a-7680x4320.jpg?rect=2,0,7675,4320&w=700&h=394&dpr=2"));
        items.add(new LiveTournamentModel("Fortnite", "Weekly tournament", "https://www.gamespot.com/a/uploads/original/1632/16320660/4037367-still010.jpg"));
//        items.add(new LiveTournamentModel("ESL One Berlin Major 2023", "3 week tournament", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmqCfQZCzS_DTdtT-ZDZO3IVdLhAzkPyep3w&usqp=CAU"));
//        items.add(new LiveTournamentModel("2022 World Championship [Worlds 2022]", "Weekly tournament", "https://cdn.esportsdriven.com/media/guides/images/Fortnite-took-part-in-the-No-Build-operation.main.jpg"));
//        items.add(new LiveTournamentModel("PUBG", "Weekly tournament", "https://img.buzzfeed.com/buzzfeed-static/static/2021-08/12/22/asset/88c059783e44/sub-buzz-4471-1628807246-1.jpg"));
//        items.add(new LiveTournamentModel("IEM Rio Major 2022", "Monthly tournament", "https://www.esports.net/wp-content/uploads/2023/04/jonsey.jpeg"));
//        items.add(new LiveTournamentModel("Asia Championship 2021", "Weekly tournament", "https://imageio.forbes.com/specials-images/imageserve/61113ca96c9c31992829e63e/Fortnite/960x0.jpg?format=jpg&width=960"));
//        items.add(new LiveTournamentModel("World eSports & Gaming Summit", "Daily tournament", "https://cdn.vox-cdn.com/thumbor/vMaWAOKdoOl6HTRcL9hZRxJvcco=/0x0:1920x1080/1200x800/filters:focal(782x89:1088x395)/cdn.vox-cdn.com/uploads/chorus_image/image/71768069/11br_evergreens_red_newsheader_1920x1080_4bf3be9721b5.0.jpg"));




        //RecyclerView for Popular Games

        RecyclerView popularGamesRecyclerView = rootView.findViewById(R.id.popular_games_rv);

        List<PopularGamesModel> items1 = new ArrayList<>();

        items1.add(new PopularGamesModel("Cyberpunk: Ultimate Edition", (float)4.5, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9f/Cyberpunk_2077_box_art.jpg/220px-Cyberpunk_2077_box_art.jpg"));
        items1.add(new PopularGamesModel("Resident Evil 4", (float)3, "Streaming Now", "https://m.media-amazon.com/images/M/MV5BOGVkNjEyN2EtMjRiYi00ZWY1LThkOWItZTNkNjA0MTE4YmRhXkEyXkFqcGdeQXVyNjUxNDQwMzA@._V1_.jpg"));
        items1.add(new PopularGamesModel("Fire Emblem Engage", (float)2.5, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/f/f6/Fire_Emblem_Engage.jpg"));
//        items1.add(new PopularGamesModel("Dead Space", (float) 2.5, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/3/36/Dead_Space_2022_Teaser_Art.jpg"));
//        items1.add(new PopularGamesModel("Hi-Fi Rush", (float) 4, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/thumb/f/fc/Hi-Fi_Rush_cover_art.jpg/220px-Hi-Fi_Rush_cover_art.jpg"));
//        items1.add(new PopularGamesModel("Diablo IV",  (float) 4.5, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/thumb/1/1c/Diablo_IV_cover_art.png/220px-Diablo_IV_cover_art.png"));
//        items1.add(new PopularGamesModel("FIFA 23 EA Sports", (float) 5, "Streaming Now", "https://cdn1.epicgames.com/offer/f5deacee017b4b109476933f7dd2edbd/EGS_EASPORTSFIFA23StandardEdition_EACanada_S2_1200x1600-c806355d9cc8b35ebe392f2a7db03075"));


        //Set Timer of 0.2 seconds to unfreeze the bottom navigation due to heavy load usage
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
                        recyclerView.setAdapter(new LiveTournamentAdapter(requireContext().getApplicationContext(), items));
                        OverScrollDecoratorHelper.setUpOverScroll(recyclerView, OverScrollDecoratorHelper.ORIENTATION_HORIZONTAL);

                        popularGamesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
                        PopularGamesAdapter PGAdapter = new PopularGamesAdapter(requireContext().getApplicationContext(), items1);
                        popularGamesRecyclerView.setAdapter(PGAdapter);
                        OverScrollDecoratorHelper.setUpOverScroll(popularGamesRecyclerView, OverScrollDecoratorHelper.ORIENTATION_HORIZONTAL);
                    }
                });
            }
        }, 200);


        //Set timer of 2 seconds to display shimmer placeholder while data are loaded in background with invisible view
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        ShimmerFrameLayout shimmerFrameLayoutLT, shimmerFrameLayoutPG;
                        shimmerFrameLayoutLT = rootView.findViewById(R.id.live_tournament_rv_shimmer);
                        shimmerFrameLayoutPG = rootView.findViewById(R.id.popular_games_rv_shimmer);
                        shimmerFrameLayoutLT.setVisibility(View.INVISIBLE);
                        shimmerFrameLayoutPG.setVisibility(View.INVISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        popularGamesRecyclerView.setVisibility(View.VISIBLE);
                    }
                });
            }
        }, 2000);


        return rootView;
    }

}