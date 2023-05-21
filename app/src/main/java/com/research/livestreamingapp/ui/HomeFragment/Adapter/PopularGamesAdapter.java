package com.research.livestreamingapp.ui.HomeFragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.research.livestreamingapp.R;
import com.research.livestreamingapp.ui.HomeFragment.Model.PopularGamesModel;

import java.util.List;

public class PopularGamesAdapter extends RecyclerView.Adapter<PopularGamesAdapter.PopularGamesViewHolder> {

    Context context;
    List<PopularGamesModel> popularGamesModels;

    public PopularGamesAdapter(Context context, List<PopularGamesModel> popularGamesModels){
        this.context = context;
        this.popularGamesModels = popularGamesModels;
    }

    @NonNull
    @Override
    public PopularGamesAdapter.PopularGamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PopularGamesViewHolder(LayoutInflater.from(context).inflate(R.layout.popular_games_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PopularGamesAdapter.PopularGamesViewHolder holder, int position) {
        holder.PopularGameTitleView.setText(popularGamesModels.get(position).getPopular_game_name());
        holder.PopularGameRatingView.setText(popularGamesModels.get(position).getPopular_game_rating().toString());
        holder.PopularGameRatingBarView.setRating(popularGamesModels.get(position).getPopular_game_rating());
        holder.PopularGameStreamingStatusView.setText(popularGamesModels.get(position).getPopular_game_stream_status());
        Glide.with(context).load(popularGamesModels.get(position).getPopular_photo_url()).into(holder.PopularGamePhotoView);
    }

    @Override
    public int getItemCount() {
        return popularGamesModels.size();
    }

    public class PopularGamesViewHolder extends RecyclerView.ViewHolder {
        TextView PopularGameTitleView, PopularGameRatingView, PopularGameStreamingStatusView;
        RatingBar PopularGameRatingBarView;
        ImageView PopularGamePhotoView;

        public PopularGamesViewHolder(@NonNull View itemView) {
            super(itemView);
            PopularGameTitleView = itemView.findViewById(R.id.popular_game_name);
            PopularGameRatingView = itemView.findViewById(R.id.rating_percentage);
            PopularGameStreamingStatusView = itemView.findViewById(R.id.streaming_now_text);
            PopularGameRatingBarView = itemView.findViewById(R.id.popular_game_rating);
            PopularGamePhotoView = itemView.findViewById(R.id.popular_games_photo);
        }
    }
}
