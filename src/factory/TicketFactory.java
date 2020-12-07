package factory;

import objects.tickets.Ticket;

public abstract class TicketFactory {

    abstract public Ticket createTicket(String name, double totalPrice);
}
