package com.research.livestreamingapp.ui.StreamFragment.Model;

public class RecentlyLivesModel {
    String game_name;
    String address;
    String viewers;
    String profile_photo_url;
    String game_photo_url;
    String user_status;
    String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getViewers() {
        return viewers;
    }

    public void setViewers(String viewers) {
        this.viewers = viewers;
    }

    public String getProfile_photo_url() {
        return profile_photo_url;
    }

    public void setProfile_photo_url(String profile_photo_url) {
        this.profile_photo_url = profile_photo_url;
    }

    public String getGame_photo_url() {
        return game_photo_url;
    }

    public void setGame_photo_url(String game_photo_url) {
        this.game_photo_url = game_photo_url;
    }

    public RecentlyLivesModel(String game_name, String address, String viewers, String profile_photo_url, String game_photo_url, String user_status, String user_name) {
        this.game_name = game_name;
        this.address = address;
        this.viewers = viewers;
        this.profile_photo_url = profile_photo_url;
        this.game_photo_url = game_photo_url;
        this.user_status = user_status;
        this.user_name = user_name;
    }
}
