package com.research.livestreamingapp.ui.StreamFragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class UserStatusAdapter extends RecyclerView.Adapter<UserStatusAdapter.UserStatusViewHolder> {

    Context context;
    List<RecentlyLivesModel> recentlyLivesModels;

    public UserStatusAdapter(Context context, List<RecentlyLivesModel> recentlyLivesModels) {
        this.context = context;
        this.recentlyLivesModels = recentlyLivesModels;
    }

    @NonNull
    @Override
    public UserStatusAdapter.UserStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserStatusViewHolder(LayoutInflater.from(context).inflate(R.layout.user_status_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserStatusAdapter.UserStatusViewHolder holder, int position) {
        if(Objects.equals(recentlyLivesModels.get(position).getUser_status(), "streaming")){
            holder.LiveText.setVisibility(View.VISIBLE);
            holder.UserStatusPicBorder.setStrokeColor(ContextCompat.getColor(context,R.color.user_border_status_online));
            holder.UserStatusPicBorder.invalidate();
        } else if (Objects.equals(recentlyLivesModels.get(position).getUser_status(), "online")){
            holder.LiveText.setVisibility(View.INVISIBLE);
            holder.UserStatusPicBorder.setStrokeColor(ContextCompat.getColor(context,R.color.user_border_status_online));
            holder.UserStatusPicBorder.invalidate();
        } else {
            holder.LiveText.setVisibility(View.INVISIBLE);
            holder.UserStatusPicBorder.setStrokeColor(ContextCompat.getColor(context,R.color.user_border_status_offline));
            holder.UserStatusPicBorder.invalidate();
        }

        holder.UserName.setText(recentlyLivesModels.get(position).getUser_name());
        Glide.with(context).load(recentlyLivesModels.get(position).getProfile_photo_url()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(holder.UserStatusProfilePic);

    }

    @Override
    public int getItemCount() {
        return recentlyLivesModels.size();
    }

    public class UserStatusViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView UserStatusPicBorder;
        CircleImageView UserStatusProfilePic;
        TextView LiveText, UserName;
        public UserStatusViewHolder(@NonNull View itemView) {
            super(itemView);
            UserStatusPicBorder = itemView.findViewById(R.id.user_status_material_card_view);
            UserStatusProfilePic = itemView.findViewById(R.id.user_status_profile_photo);
            LiveText = itemView.findViewById(R.id.user_status_live_text);
            UserName = itemView.findViewById(R.id.user_status_name);
        }
    }
}
