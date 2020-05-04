package com.groundhopping.backend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackendService {

    private List<Game> games;

    {
    // Init dummy data

        games = new ArrayList<>();
        games.add(new Game("Bieberer Berg", "04.05.2012", "Offenbach FC", "Borussia Mönchengladbach", "1:7"));
        games.add(new Game("Allianz Arena", "05.11.2005", "FC Bayern München", "SV Werder Bremen", "3:1"));
    }


    public List<Game> getGames() {
        return games;
    }

}
