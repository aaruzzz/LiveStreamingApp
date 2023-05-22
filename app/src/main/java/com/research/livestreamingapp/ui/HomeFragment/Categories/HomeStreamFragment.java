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


public class HomeStreamFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_stream, container, false);

//        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_pg, null);
//        View pgCardView = getLayoutInflater().inflate(R.layout.popular_games_card, null);


        //RecyclerView for Live Tournament

        RecyclerView recyclerView = rootView.findViewById(R.id.live_tournament_rv);

        List<LiveTournamentModel> items = new ArrayList<>();

        items.add(new LiveTournamentModel("Capitulo 2 Fortnite", "Weekly tournament", "data:image/jpeg;base64,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"));
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

        float ratingCyberPunk = (float) 3.5;
        float ratingResidentEvil = (float) 3;
        float ratingDeadSpace = (float) 2.5;
        float ratingHifiRush = (float) 4;
        float ratingDiablo = (float) 4.5;
        float ratingFifa = (float) 5;


        items1.add(new PopularGamesModel("Cyberpunk: Ultimate Edition", ratingCyberPunk, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9f/Cyberpunk_2077_box_art.jpg/220px-Cyberpunk_2077_box_art.jpg"));
        items1.add(new PopularGamesModel("Resident Evil 4", ratingResidentEvil, "Streaming Now", "https://m.media-amazon.com/images/M/MV5BOGVkNjEyN2EtMjRiYi00ZWY1LThkOWItZTNkNjA0MTE4YmRhXkEyXkFqcGdeQXVyNjUxNDQwMzA@._V1_.jpg"));
        items1.add(new PopularGamesModel("Fire Emblem Engage", ratingCyberPunk, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/f/f6/Fire_Emblem_Engage.jpg"));
//        items1.add(new PopularGamesModel("Dead Space", ratingDeadSpace, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/3/36/Dead_Space_2022_Teaser_Art.jpg"));
//        items1.add(new PopularGamesModel("Hi-Fi Rush", ratingHifiRush, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/thumb/f/fc/Hi-Fi_Rush_cover_art.jpg/220px-Hi-Fi_Rush_cover_art.jpg"));
//        items1.add(new PopularGamesModel("Diablo IV", ratingDiablo, "Streaming Now", "https://upload.wikimedia.org/wikipedia/en/thumb/1/1c/Diablo_IV_cover_art.png/220px-Diablo_IV_cover_art.png"));
//        items1.add(new PopularGamesModel("FIFA 23 EA Sports", ratingFifa, "Streaming Now", "https://cdn1.epicgames.com/offer/f5deacee017b4b109476933f7dd2edbd/EGS_EASPORTSFIFA23StandardEdition_EACanada_S2_1200x1600-c806355d9cc8b35ebe392f2a7db03075"));




//        MaterialCardView PGCard;
//        PGCard = pgCardView.findViewById(R.id.popular_games_card);
//        PGCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
//                bottomSheetDialog.setContentView(bottomSheetView);
//                bottomSheetDialog.show();
//            }
//        });


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
                        recyclerView.setAdapter(new LiveTournamentAdapter(requireContext().getApplicationContext(), items));

                        popularGamesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
                        PopularGamesAdapter PGAdapter = new PopularGamesAdapter(requireContext().getApplicationContext(), items1);
                        popularGamesRecyclerView.setAdapter(PGAdapter);
                    }
                });
            }
        }, 200);


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