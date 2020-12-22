# taxiticketsystem
This apllication calculates the taxi fare.

How to run:

Main method contain in com.ticketsystem.Application.java

Provide cities like below in the main mehtod to generate the Ticket.

ticketGenerator.generateTicket("PUNE", "NASIK", 2);

if user wants to add new routes then add line in the main mehtod like below

routeChart.addRoute("PUNE", "HYDERABAD", 900);

Below routes are already hard coded in the system

("PUNE", "MUMBAI", 120);
("PUNE", "NASIK", 200);
("MUMBAI", "GOA", 350);
("MUMBAI", "NASIK", 180);


com.ticketsystem.routs.impl.RouteChartImpl.java
This file contains logic related to add and delete the routes.

com.ticketsystem.pricing.PriceCalculator.java
This file contains logic related to TotalAmount calculation.

com.ticketsystem.ticket.impl.TicketGeneratorImpl.java
This file contains logic to build the final document to be printed.

com.ticketsystem.ticket.TicketPrinter.java
This file contains logic to print the ticket.

com.ticketsystem.TicketSystemDefaults.java
This file contains the default values of system.



