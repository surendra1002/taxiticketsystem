package com.ticketsystem.ticket;

import com.ticketsystem.doc.TicketDoc;

public interface TicketGenerator {
    TicketDoc generateTicket(String pune, String nasik, int i);
}
