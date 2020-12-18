package factory;

import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.TicketTypes;

public abstract class TicketFactory {

    abstract public Ticket createTicket(String name, double debtAmount, Person lender, TicketTypes ticketType);
}
