package com.groundhopping.views.list;

import com.groundhopping.backend.BackendService;
import com.groundhopping.backend.Game;
import com.groundhopping.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "list", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("List")

public class ListView extends VerticalLayout {

    private BackendService service = BackendService.getInstance();
    TextField filter = new TextField();
    Grid<Game> games = new Grid<>(Game.class);
    GameForm form;

    public ListView() {
        setSizeFull();
        configureGrid();
        updateGrid();
        configureForm();

        // get a toolbar with Filter and "add" button

        filter.setPlaceholder("Filter the games");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> updateGrid());

        Button addGame = new Button("Add new Game");
        addGame.addClickListener(click -> {
            games.asSingleSelect().clear();
            form.setGame(new Game());
            form.setVisible(true);
        });

        HorizontalLayout toolbar = new HorizontalLayout(filter, addGame);


//Fill content of the "list" page
        HorizontalLayout content = new HorizontalLayout(games, form);

        content.setSizeFull();
        add(toolbar, content);
// only open Form, when something is selected
        closeForm();
    }

    private void configureForm() {
        form = new GameForm(this);
    }

    public void updateGrid() {
        games.setItems(service.findAll(filter.getValue()));
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



