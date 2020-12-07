package factory;

import objects.Person;
import objects.tickets.Ticket;

public abstract class TicketFactory {

    abstract public Ticket createTicket(String name, double debtAmount, Person lender);
}
