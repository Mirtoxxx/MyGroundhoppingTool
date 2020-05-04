package com.groundhopping.backend;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Game {

    @NotNull
    @NotEmpty
    private String stadium;

    private String date;
    @NotNull
    @NotEmpty
    private String homeTeam;
    @NotNull
    @NotEmpty
    private String awayTeam;
    @NotNull
    @NotEmpty
    private String score;
    private String notes = "";

    public Game(String stadium, String date, String homeTeam, String awayTeam, String score) {
        super();
        this.stadium = stadium;
        this.date = date;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.score = score;
    }

    public Game() {

    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getScore(){
        return score;
    }

    public void setScore(String score){
        this.score = score;
    }

}
