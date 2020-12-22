package com.ticketsystem.routs.impl;


import com.ticketsystem.customexceptions.RouteNotFoundException;
import org.junit.Test;
import org.mockito.Mockito;

public class RouteChartImplTest {

    @Test
    public void addRoute() throws RouteNotFoundException {
        RouteChartImpl routeChart = Mockito.spy(RouteChartImpl.getInstance());
        routeChart.addRoute("HYDERABAD", "PUNE", 900.0);
        assert (routeChart.getDistance("HYDERABAD", "PUNE") == 900.0);
        assert (routeChart.getDistance("PUNE", "HYDERABAD") == 900.0);
    }

    @Test(expected = RouteNotFoundException.class)
    public void deleteRoute() throws RouteNotFoundException {
        RouteChartImpl routeChart = Mockito.spy(RouteChartImpl.getInstance());
        routeChart.addRoute("HYDERABAD", "PUNE", 900.0);
        routeChart.deleteRoute("HYDERABAD", "PUNE");
        routeChart.getDistance("HYDERABAD", "PUNE");
    }

}