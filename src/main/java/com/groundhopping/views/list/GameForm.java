package com.groundhopping.views.list;

import com.groundhopping.backend.Game;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class GameForm extends FormLayout {

    private TextField stadium = new TextField("Stadium");
    private TextField date = new TextField("Date");
    private TextField homeTeam = new TextField("Home Team");
    private TextField awayTeam = new TextField("Away Team");
    private TextField score = new TextField("Score");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    Binder<Game> binder = new BeanValidationBinder<>(Game.class);

    public GameForm(){
        binder.bindInstanceFields(this);


        add(stadium,
                date,
                homeTeam,
                awayTeam,
                score,
                buttonsLayout());
    }
    public void setGame(Game game){
        binder.setBean(game);
    }

    private Component buttonsLayout(){
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        //save.addClickListener(click -> save());


        HorizontalLayout buttons = new HorizontalLayout();

        buttons.add(save, delete, cancel);

        return buttons;
    }




}
