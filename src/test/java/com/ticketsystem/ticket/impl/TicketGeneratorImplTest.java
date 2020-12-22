package com.ticketsystem.ticket.impl;

import com.ticketsystem.customexceptions.RouteNotFoundException;
import com.ticketsystem.doc.TicketDoc;
import com.ticketsystem.routs.RouteChart;
import com.ticketsystem.routs.impl.RouteChartImpl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;

public class TicketGeneratorImplTest {

    @Test
    public void generateTicket() {
        RouteChart routeChart = RouteChartImpl.getInstance();
        TicketGeneratorImpl ticketGenerator = Mockito.spy(new TicketGeneratorImpl(routeChart));
        TicketDoc ticketDoc = ticketGenerator.generateTicket("PUNE", "NASIK", 2);
        assertTrue(ticketDoc.getTotalAmount() == 2500.0);
    }

    @Test
    public void deleteRoute() throws RouteNotFoundException {
        RouteChart routeChart = RouteChartImpl.getInstance();
        TicketGeneratorImpl ticketGenerator = Mockito.spy(new TicketGeneratorImpl(routeChart));
        TicketDoc ticketDoc = ticketGenerator.generateTicket("PUN", "NASIK", 2);
        assertTrue(ticketDoc == null);
    }
}