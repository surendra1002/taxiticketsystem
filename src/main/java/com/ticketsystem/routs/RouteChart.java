package com.ticketsystem.routs;

import com.ticketsystem.customexceptions.RouteNotFoundException;

public interface RouteChart {
    boolean addRoute(String from, String to, double distance);

    boolean deleteRoute(String from, String to);

    double getDistance(String from, String to) throws RouteNotFoundException;

}
