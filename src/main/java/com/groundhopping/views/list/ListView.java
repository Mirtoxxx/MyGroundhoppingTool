package com.groundhopping.views.list;

import com.groundhopping.backend.BackendService;
import com.groundhopping.backend.Game;
import com.groundhopping.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "list", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("List")

public class ListView extends VerticalLayout {

    private BackendService service;

    Grid<Game> games = new Grid<>(Game.class);
    GameForm form;

    public ListView(BackendService service) {
        this.service = service;
        setSizeFull();
        configureGrid();
        updateGrid();
        configureForm();
        // get a toolbar
        Button addGame = new Button("Add new Game");
        addGame.addClickListener(click -> {
            games.asSingleSelect().clear();
            form.setGame(new Game());
        });

        HorizontalLayout toolbar = new HorizontalLayout(addGame);
        toolbar.setSizeFull();

//Fill content of the "list" page
        HorizontalLayout content = new HorizontalLayout(games, form);

        content.setSizeFull();
        add(toolbar, content);
// only open Form, when something is selected
        closeForm();
    }

    private void configureForm() {
        form = new GameForm();
    }

    private void updateGrid() {
        games.setItems(service.getGames());
    }

    private void configureGrid() {
        games.setSizeFull();
        games.setColumns("stadium", "date", "homeTeam", "awayTeam", "score");

        games.getColumns().forEach(col -> col.setAutoWidth(true));

        games.asSingleSelect().addValueChangeListener(evt-> editGame(evt.getValue()));
    }

    private void editGame(Game game) {
        if (game == null){
            closeForm();
        }
        else {
            form.setGame(game);
            form.setVisible(true);
        }
    }

    private void closeForm() {
        form.setGame(null);
        form.setVisible(false);
    }

    }



