package factory;

import objects.Person;
import objects.tickets.EquallySplitTicket;
import objects.tickets.Ticket;

public class EquallySplitTicketFactory extends TicketFactory{

    @Override
    public Ticket createTicket(String name, double debtAmount, Person lender) {
        return new EquallySplitTicket(name, debtAmount, lender);
    }
}
