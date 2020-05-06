package com.groundhopping.backend;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BackendService {

    private GameRepository gameRepository;

    public BackendService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
    public long count() {
        return gameRepository.count();}

        //Event support
        public void delete (Game game){
            gameRepository.delete(game);
        }

        public void save (Game game){

            gameRepository.save(game);
        }

        @PostConstruct
        public void populateTestData() {

            if (gameRepository.count() == 0) {
                Random r = new Random(0);

                gameRepository.saveAll(
                        Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                                "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                                "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                                "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                                "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                                "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                                "Jaydan Jackson", "Bernard Nilsen")
                                .map(name -> {
                                    String[] split = name.split(" ");
                                    Game game = new Game();
                                    game.setHomeTeam(split[0]);
                                    game.setAwayTeam(split[1]);
                                    game.setScore(r + ":" + r);
                                    return game;
                                }).collect(Collectors.toList()));
            }
        }
    }

// Init dummy data
        /*ArrayList<Game> games = new ArrayList<>();
        games.add(new Game("Bieberer Berg",
                LocalDate.of(2004, 05, 4),
                "Offenbach FC",
                "Borussia Mönchengladbach",
                "1:7"));
        games.add(new Game("Allianz Arena",
                LocalDate.of(2005, 11, 05),
                "FC Bayern München",
                "SV Werder Bremen",
                "3:1"));

        gameRepository.saveAll(games);*/