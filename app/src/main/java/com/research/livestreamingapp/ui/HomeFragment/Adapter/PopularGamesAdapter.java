package com.research.livestreamingapp.ui.HomeFragment.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
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
        Glide.with(context)
                .load(popularGamesModels.get(position).getPopular_photo_url())
                .centerInside()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .apply(new RequestOptions()
                        .encodeQuality(50) // Decrease image quality to 50% (adjust as needed)
                        .override(720, 480) // Decrease image size to 720x480 pixels (adjust as needed)
                )
                .into(holder.PopularGamePhotoView);

        // Bottom Sheet Trial to display bottom sheet view of the pressed card

//        holder.PopularGamesCard.setOnClickListener(view -> {
//
//            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
//            bottomSheetDialog.setContentView(R.layout.bottom_sheet_pg);
//
////            Glide.with(context).load(popularGamesModels.get(position).getPopular_photo_url()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into((ImageView) bottomSheetDialog.findViewById(R.id.bs_image));
////            TextView bsGameName =  bottomSheetDialog.findViewById(R.id.bs_game_name);
////            bsGameName.setText(popularGamesModels.get(position).getPopular_game_name());
//
////            bottomSheetDialog.show();
//        });
    }

    @Override
    public int getItemCount() {
        return popularGamesModels.size();
    }

    public class PopularGamesViewHolder extends RecyclerView.ViewHolder {
        TextView PopularGameTitleView, PopularGameRatingView, PopularGameStreamingStatusView;
        RatingBar PopularGameRatingBarView;
        ImageView PopularGamePhotoView;
        MaterialCardView PopularGamesCard;

        public PopularGamesViewHolder(@NonNull View itemView) {
            super(itemView);
            PopularGameTitleView = itemView.findViewById(R.id.popular_game_name);
            PopularGameRatingView = itemView.findViewById(R.id.rating_percentage);
            PopularGameStreamingStatusView = itemView.findViewById(R.id.streaming_now_text);
            PopularGameRatingBarView = itemView.findViewById(R.id.popular_game_rating);
            PopularGamePhotoView = itemView.findViewById(R.id.popular_games_photo);
            PopularGamesCard = itemView.findViewById(R.id.popular_games_card);
        }
    }
}
