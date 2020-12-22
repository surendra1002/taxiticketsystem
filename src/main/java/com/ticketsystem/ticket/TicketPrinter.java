package com.ticketsystem.ticket;

import com.ticketsystem.TicketSystemDefaults;
import com.ticketsystem.doc.TicketDoc;

/**
 * This class prints the ticket information.
 * If we want to change the format then we need to change only this class with out impacting any other class
 */
public class TicketPrinter {
    private TicketSystemDefaults systemDefaults;

    public TicketPrinter(TicketSystemDefaults systemDefaults) {
        this.systemDefaults = systemDefaults;
    }

    public void print(TicketDoc ticketDoc) {
        StringBuilder printer = new StringBuilder();
        printer.append("Taxi Ticket \n")
                .append("----------\n")
                .append("Source:")
                .append(ticketDoc.getFrom())
                .append("\n")
                .append("Destination:")
                .append(ticketDoc.getTo())
                .append("\n")
                .append("Kms:")
                .append(ticketDoc.getDistance())
                .append("\n")
                .append("No. of travellers:")
                .append(ticketDoc.getPassengers())
                .append("\n")
                .append("Total:")
                .append(ticketDoc.getTotalAmount())
                .append(" ")
                .append(systemDefaults.getCurrency());
        System.out.println(printer.toString());

    }
}
