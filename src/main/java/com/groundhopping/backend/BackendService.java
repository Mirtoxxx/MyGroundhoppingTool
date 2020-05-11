package com.groundhopping.backend;

import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BackendService {

    private HashMap<Long, Game> games = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(BackendService.class.getName());
    private static BackendService instance;
    private long nextId = 0;

    // Init dummy data
    public void ensureTestData() {
        save(new Game("Bieberer Berg", "04.05.2012", "Offenbach FC", "Borussia Mönchengladbach", "1:7"));
        save(new Game("Borussia Park", "22.02.2020", "Borussia Mönchengladbach", "TSG 1899 Hoffenheim", "1:1"));
        save(new Game("Allianz Arena", "05.11.2005", "FC Bayern München", "SV Werder Bremen", "3:1"));
    }


    private BackendService() {
    }

    public static BackendService getInstance() {
        if (instance == null) {
            instance = new BackendService();
            instance.ensureTestData();
        }
        return instance;
    }

    public synchronized List<Game> findAll() {
        return findAll(null);
    }

    public synchronized List<Game> findAll(String filter) {
        ArrayList<Game> arrayList = new ArrayList<>();
        for (Game game : games.values()) {
            try {
                boolean passesFilter = (filter == null || filter.isEmpty()) || game.toString().toLowerCase().contains(filter.toLowerCase());
                if (passesFilter) {
                    arrayList.add(game.clone());
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(BackendService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Collections.sort(arrayList, new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return (int) (o2.getId() - o1.getId());
            }
        });

        return arrayList;
    }

    public synchronized void delete(Game game) {
        games.remove(game.getId());
    }

    public synchronized void save(Game entry) {
        if (entry == null) {
            LOGGER.log(Level.SEVERE, "Customer is null");
            return;
        }
        if (entry.getId() == null) {
            entry.setId(nextId++);
        }
        try {
            entry = (Game) entry.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
        games.put(entry.getId(), entry);
    }

    public DataProvider getStats() {
        DataProvider<Game, ?> series = new ListDataProvider<>(findAll());

        return series;
    }
}

