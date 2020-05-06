package com.groundhopping.backend;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Game extends AbstractEntity implements Cloneable{

    @NotNull
    @NotEmpty
    private String stadium;

    private LocalDate date;
    @NotNull
    @NotEmpty
    private String homeTeam;
    @NotNull
    @NotEmpty
    private String awayTeam;
    @NotNull
    @NotEmpty
    private String score;

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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


    public String getScore(){
        return score;
    }

    public void setScore(String score){
        this.score = score;
    }

}
