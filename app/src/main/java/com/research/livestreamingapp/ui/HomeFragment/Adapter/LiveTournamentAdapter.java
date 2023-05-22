package com.research.livestreamingapp.ui.HomeFragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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
        Glide.with(context).load(liveTournamentModels.get(position).getPhoto_url()).centerInside().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(holder.PhotoView);

        holder.PopupMenu.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.PopupMenu);
            popupMenu.inflate(R.menu.popup_menu_lt);
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                switch (menuItem.getItemId()){
                    case R.id.watch_live:
                        Toast.makeText(context, "Live Streaming: "+ liveTournamentModels.get(position).getGame_name()+" now.", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.like:
                        Toast.makeText(context, liveTournamentModels.get(position).getGame_name()+" Liked!", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.dislike:
                        Toast.makeText(context, liveTournamentModels.get(position).getGame_name()+" Disliked!", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return  false;
                }
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return liveTournamentModels.size();
    }

    public static class LiveTournamentViewHolder extends RecyclerView.ViewHolder {
        TextView TitleView, SubtitleView;
        ImageView PhotoView;
        ImageButton PopupMenu;
        public LiveTournamentViewHolder(@NonNull View itemView) {
            super(itemView);
            TitleView = itemView.findViewById(R.id.game_name);
            SubtitleView = itemView.findViewById(R.id.tournament_time);
            PhotoView = itemView.findViewById(R.id.live_tournament_image);
            PopupMenu = itemView.findViewById(R.id.live_tournament_popup_menu);
        }
    }
}
