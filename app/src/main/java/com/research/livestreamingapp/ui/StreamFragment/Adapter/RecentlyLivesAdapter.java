package com.research.livestreamingapp.ui.StreamFragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.card.MaterialCardView;
import com.research.livestreamingapp.R;
import com.research.livestreamingapp.ui.StreamFragment.Model.RecentlyLivesModel;

import java.util.List;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecentlyLivesAdapter extends RecyclerView.Adapter<RecentlyLivesAdapter.RecentlyLivesViewHolder> {
    Context context;
    List<RecentlyLivesModel> recentlyLivesModels;

    public RecentlyLivesAdapter(Context context, List<RecentlyLivesModel> recentlyLivesModels) {
        this.context = context;
        this.recentlyLivesModels = recentlyLivesModels;
    }

    @NonNull
    @Override
    public RecentlyLivesAdapter.RecentlyLivesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentlyLivesViewHolder(LayoutInflater.from(context).inflate(R.layout.recently_lives_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyLivesAdapter.RecentlyLivesViewHolder holder, int position) {
        holder.GameName.setText(recentlyLivesModels.get(position).getGame_name());
        holder.Address.setText(recentlyLivesModels.get(position).getAddress());
        holder.Viewers.setText(recentlyLivesModels.get(position).getViewers());
        if(Objects.equals(recentlyLivesModels.get(position).getUser_status(), "online")){
            holder.ProfilePicBorder.setStrokeColor(ContextCompat.getColor(context,R.color.user_border_status_online));
            holder.ProfilePicBorder.invalidate();
        } else {
            holder.ProfilePicBorder.setStrokeColor(ContextCompat.getColor(context,R.color.user_border_status_offline));
            holder.ProfilePicBorder.invalidate();
        }
        Glide.with(context).load(recentlyLivesModels.get(position).getProfile_photo_url()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(holder.ProfilePhoto);
        Glide.with(context).load(recentlyLivesModels.get(position).getGame_photo_url()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(holder.GamePhoto);
    }

    @Override
    public int getItemCount() {
        return recentlyLivesModels.size();
    }

    public class RecentlyLivesViewHolder extends RecyclerView.ViewHolder{
        TextView GameName, Address,Viewers;
        MaterialCardView ProfilePicBorder;
        CircleImageView ProfilePhoto;
        ImageView GamePhoto;
        public RecentlyLivesViewHolder(@NonNull View itemView) {
            super(itemView);
            GameName = itemView.findViewById(R.id.live_game_name);
            Address = itemView.findViewById(R.id.live_from_address);
            Viewers = itemView.findViewById(R.id.viewers);
            ProfilePhoto = itemView.findViewById(R.id.recently_lives_profile_photo);
            GamePhoto = itemView.findViewById(R.id.game_photo);
            ProfilePicBorder = itemView.findViewById(R.id.recently_lives_profile_photo_card_view);
        }
    }
}
