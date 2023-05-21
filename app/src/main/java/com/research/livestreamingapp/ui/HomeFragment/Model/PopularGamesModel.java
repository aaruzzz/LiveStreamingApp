package com.research.livestreamingapp.ui.HomeFragment.Model;

public class PopularGamesModel {
    String popular_game_name;
    Float popular_game_rating;
    String popular_game_stream_status;

    public String getPopular_game_name() {
        return popular_game_name;
    }

    public void setPopular_game_name(String popular_game_name) {
        this.popular_game_name = popular_game_name;
    }

    public Float getPopular_game_rating() {
        return popular_game_rating;
    }

    public void setPopular_game_rating(Float popular_game_rating) {
        this.popular_game_rating = popular_game_rating;
    }

    public String getPopular_game_stream_status() {
        return popular_game_stream_status;
    }

    public void setPopular_game_stream_status(String popular_game_stream_status) {
        this.popular_game_stream_status = popular_game_stream_status;
    }

    public String getPopular_photo_url() {
        return popular_photo_url;
    }

    public void setPopular_photo_url(String popular_photo_url) {
        this.popular_photo_url = popular_photo_url;
    }

    public PopularGamesModel(String popular_game_name, Float popular_game_rating, String popular_game_stream_status, String popular_photo_url) {
        this.popular_game_name = popular_game_name;
        this.popular_game_rating = popular_game_rating;
        this.popular_game_stream_status = popular_game_stream_status;
        this.popular_photo_url = popular_photo_url;
    }

    String popular_photo_url;
}
