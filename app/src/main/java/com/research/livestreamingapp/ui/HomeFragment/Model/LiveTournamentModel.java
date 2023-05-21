package com.research.livestreamingapp.ui.HomeFragment.Model;

public class LiveTournamentModel {
    String game_name;
    String tournament_time;
    String photo_url;

    public LiveTournamentModel(String game_name, String tournament_time, String photo_url) {
        this.game_name = game_name;
        this.tournament_time = tournament_time;
        this.photo_url = photo_url;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getTournament_time() {
        return tournament_time;
    }

    public void setTournament_time(String tournament_time) {
        this.tournament_time = tournament_time;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
