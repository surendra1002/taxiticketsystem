package com.ticketsystem.ticket.impl;

import com.ticketsystem.TicketSystemDefaults;
import com.ticketsystem.customexceptions.RouteNotFoundException;
import com.ticketsystem.doc.TicketDoc;
import com.ticketsystem.pricing.PriceCalculator;
import com.ticketsystem.routs.RouteChart;
import com.ticketsystem.ticket.TicketGenerator;
import com.ticketsystem.ticket.TicketPrinter;

/**
 * This class implements the main business logic
 * It gets route information from the Route chart,gets price information from the price calculator
 * and sends the consolidated information to Ticket Printer for print.
 */

public class TicketGeneratorImpl implements TicketGenerator {
    private RouteChart routeChart;
    private TicketSystemDefaults systemDefaults = new TicketSystemDefaults();
    private PriceCalculator priceCalculator = new PriceCalculator(systemDefaults);
    private TicketPrinter ticketPrinter = new TicketPrinter(systemDefaults);

    public TicketGeneratorImpl(RouteChart routeChart) {
        this.routeChart = routeChart;
    }

    @Override
    public TicketDoc generateTicket(String from, String to, int passengers) {
        TicketDoc ticketDoc = null;
        try {
            ticketDoc = collectTicketInfo(from, to, passengers);
            ticketPrinter.print(ticketDoc);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return ticketDoc;
    }

    /**
     * This method gets distance from two cities from the route chart and gets the total amount from the
     * Price calculator.
     *
     * @param from
     * @param to
     * @param passengers
     * @return
     * @throws RouteNotFoundException
     */
    private TicketDoc collectTicketInfo(String from, String to, int passengers) throws RouteNotFoundException {
        double distance = routeChart.getDistance(from, to);
        TicketDoc ticketDoc = new TicketDoc(from, to, passengers);
        ticketDoc.setDistance(distance);
        double totalAmount = priceCalculator.calculateTotalAmount(distance, passengers);
        ticketDoc.setTotalAmount(totalAmount);
        return ticketDoc;
    }
}
