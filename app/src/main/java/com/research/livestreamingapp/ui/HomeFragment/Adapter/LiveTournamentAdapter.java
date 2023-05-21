package com.research.livestreamingapp.ui.HomeFragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.research.livestreamingapp.R;
import com.research.livestreamingapp.ui.HomeFragment.Model.LiveTournamentModel;

import java.util.List;

public class LiveTournamentAdapter extends RecyclerView.Adapter<LiveTournamentAdapter.LiveTournamentViewHolder> {

    Context context;
    List<LiveTournamentModel> liveTournamentModels;

    public LiveTournamentAdapter(Context context, List<LiveTournamentModel> liveTournamentModels) {
        this.context = context;
        this.liveTournamentModels = liveTournamentModels;
    }

    @NonNull
    @Override
    public LiveTournamentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LiveTournamentViewHolder(LayoutInflater.from(context).inflate(R.layout.live_tournament_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LiveTournamentViewHolder holder, int position) {
        holder.TitleView.setText(liveTournamentModels.get(position).getGame_name());
        holder.SubtitleView.setText(liveTournamentModels.get(position).getTournament_time());
        Glide.with(context).load(liveTournamentModels.get(position).getPhoto_url()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(holder.PhotoView);
    }

    @Override
    public int getItemCount() {
        return liveTournamentModels.size();
    }

    public static class LiveTournamentViewHolder extends RecyclerView.ViewHolder {
        TextView TitleView, SubtitleView;
        ImageView PhotoView;
        public LiveTournamentViewHolder(@NonNull View itemView) {
            super(itemView);
            TitleView = itemView.findViewById(R.id.game_name);
            SubtitleView = itemView.findViewById(R.id.tournament_time);
            PhotoView = itemView.findViewById(R.id.live_tournament_image);
        }
    }
}
