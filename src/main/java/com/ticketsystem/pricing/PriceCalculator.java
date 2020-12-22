package com.ticketsystem.pricing;

import com.ticketsystem.TicketSystemDefaults;

public class PriceCalculator {
    TicketSystemDefaults systemDefaults;

    public PriceCalculator(TicketSystemDefaults systemDefaults) {
        this.systemDefaults = systemDefaults;
    }

    public double calculateTotalAmount(double distance, int passengers) {
        double totalAmount = systemDefaults.getMinimumAmount() * passengers;
        totalAmount += (distance - systemDefaults.getMinimumDistance() > 0.0) ?
                (distance - systemDefaults.getMinimumDistance()) *
                        systemDefaults.getPerKMPrice() * passengers : 0.0;
        return totalAmount;

    }
}
