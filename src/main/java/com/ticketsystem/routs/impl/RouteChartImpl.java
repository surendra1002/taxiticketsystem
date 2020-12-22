package com.ticketsystem.routs.impl;

import com.ticketsystem.customexceptions.RouteNotFoundException;
import com.ticketsystem.routs.RouteChart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is responsible for building the route chart.
 * the routesMap holds all the routes exist in the system. The information is stored as below
 * it route is PUNE -> MUMBAI 200
 * Map(PUNE, Map(MUMBAI, 200),
 * MUMBAI,Map(PUNE,200))
 * This helps for faster lookups.
 */

public class RouteChartImpl implements RouteChart {
    private Map<String, Map<String, Double>> routesMap = new ConcurrentHashMap<String, Map<String, Double>>();
    private static RouteChartImpl instance = new RouteChartImpl();

    private RouteChartImpl() {
        buildInitalRoutes();
    }

    /**
     * This is nothing but loading all the routes from Database or from file system to in memory
     * at the application start.
     */
    private void buildInitalRoutes() {
        addRoute("PUNE", "MUMBAI", 120);
        addRoute("PUNE", "NASIK", 200);
        addRoute("MUMBAI", "GOA", 350);
        addRoute("MUMBAI", "NASIK", 180);
    }

    public static RouteChartImpl getInstance() {
        return instance;
    }

    /**
     * Adds route at run time.
     *
     * @param from
     * @param to
     * @param distance
     * @return
     */
    @Override
    public boolean addRoute(String from, String to, double distance) {
        from = from.toUpperCase();
        to = to.toUpperCase();
        addBidirectionalRoute(from, to, distance);
        addBidirectionalRoute(to, from, distance);
        return true;
    }

    private boolean addBidirectionalRoute(String from, String to, double distance) {
        Map<String, Double> route = routesMap.computeIfAbsent(from, r -> new ConcurrentHashMap<String, Double>());
        route.put(to, distance);
        return true;

    }

    /**
     * Deletes route at run time
     *
     * @param from
     * @param to
     * @return
     */
    @Override
    public boolean deleteRoute(String from, String to) {
        from = from.toUpperCase();
        to = to.toUpperCase();
        deleteBidirectionalRoute(from, to);
        deleteBidirectionalRoute(to, from);
        return true;
    }

    private boolean deleteBidirectionalRoute(String from, String to) {
        Map<String, Double> route = routesMap.getOrDefault(from, new ConcurrentHashMap<>());
        route.remove(to);
        if (route.isEmpty()) {
            routesMap.remove(from);
        }
        return true;
    }

    /**
     * Utility method to return the distance between two cities.
     *
     * @param from
     * @param to
     * @return
     * @throws RouteNotFoundException
     */

    @Override
    public double getDistance(String from, String to) throws RouteNotFoundException {
        Map<String, Double> route = routesMap.getOrDefault(from.toUpperCase(), new ConcurrentHashMap<>());
        if (route.isEmpty() || route.get(to) == null) {
            throw new RouteNotFoundException("Route not found");
        }
        return route.get(to.toUpperCase());
    }


}
