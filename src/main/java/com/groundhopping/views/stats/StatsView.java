package com.groundhopping.views.stats;

import com.groundhopping.backend.BackendService;
import com.groundhopping.backend.Game;
import com.groundhopping.views.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataProviderSeries;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route (value = "stats", layout= MainView.class)
@PageTitle("Stats")
public class StatsView extends VerticalLayout {
    private BackendService service;
public StatsView (BackendService service){
    setSizeFull();
    this.service = service;
    setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    add(getHomeTeamsChart());
}
private Component getHomeTeamsChart(){
    Chart chart = new Chart(ChartType.PIE);

    Configuration conf = chart.getConfiguration();
    conf.setTitle("Home Teams");
    conf.setSubTitle("Games grouped by home team");

    DataProviderSeries<Game> series = new DataProviderSeries<>(service.getStats(), Game::getHomeTeam);
    conf.addSeries(series);

    return chart;




}




}
