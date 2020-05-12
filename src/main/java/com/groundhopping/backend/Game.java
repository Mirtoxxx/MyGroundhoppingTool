package com.groundhopping.backend;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Game implements Cloneable, Serializable {

    @NotNull
    @NotEmpty
    private String stadium;

    private Long id;

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

        setStadium(stadium);
        setDate(date);
        setAwayTeam(awayTeam);
        setHomeTeam(homeTeam);
        setScore(score);
    }

    public Game() {

    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
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


    @Override
    public Game clone() throws CloneNotSupportedException{
        return (Game) super.clone();
    }
    @Override
    public String toString(){
        return stadium + homeTeam + awayTeam;
    }


}
