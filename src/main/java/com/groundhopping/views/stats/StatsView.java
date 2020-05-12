package com.groundhopping.views.stats;

import com.groundhopping.backend.BackendService;
import com.groundhopping.views.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Map;

@Route (value = "stats", layout= MainView.class)
@PageTitle("Stats")
public class StatsView extends VerticalLayout {
    private BackendService service = BackendService.getInstance() ;


public StatsView (){
    setSizeFull();
    setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    add(getStadiumChart());
}

private Component getStadiumChart(){
    Chart chart = new Chart(ChartType.PIE);

    Configuration conf = chart.getConfiguration();
    conf.setTitle("Home Teams");
    conf.setSubTitle("Games grouped by home team");

    DataSeries dataSeries = new DataSeries();
    Map<String, Integer> stats = service.getStats();
    stats.forEach((name, number) -> dataSeries.add(new DataSeriesItem(name, number)));

    conf.setSeries(dataSeries);


    return chart;




}




}
