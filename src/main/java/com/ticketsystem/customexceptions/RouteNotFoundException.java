package com.ticketsystem.customexceptions;

public class RouteNotFoundException extends Exception {
    private String message;

    public RouteNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
