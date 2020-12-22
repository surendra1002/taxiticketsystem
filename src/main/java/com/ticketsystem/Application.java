package com.ticketsystem;

import com.ticketsystem.routs.RouteChart;
import com.ticketsystem.routs.impl.RouteChartImpl;
import com.ticketsystem.ticket.TicketGenerator;
import com.ticketsystem.ticket.impl.TicketGeneratorImpl;

public class Application {
    public static void main(String[] args) {
        RouteChart routeChart = RouteChartImpl.getInstance();
        //routeChart.addRoute("PUNE", "HYDERABAD", 900);
        TicketGenerator ticketGenerator = new TicketGeneratorImpl(routeChart);
        ticketGenerator.generateTicket("PUNE", "NASIK", 2);
    }
}
