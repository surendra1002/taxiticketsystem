package com.ticketsystem;

/**
 * This class holds default properties of the system.
 * User may change these values time to time.
 * These values can be setup in any properties file and load here.
 */
public class TicketSystemDefaults {
    private double minimumDistance = 100;
    private double minimumAmount = 750;
    private double perKMPrice = 5;
    private String currency = "INR";

    public double getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(double minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    public double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(double minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public double getPerKMPrice() {
        return perKMPrice;
    }

    public void setPerKMPrice(double perKMPrice) {
        this.perKMPrice = perKMPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
