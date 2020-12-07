package factory;

import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.UnEquallySplitTicket;

public class UnequallySplitTicketFactory extends TicketFactory{

    @Override
    public Ticket createTicket(String name, double debtAmount, Person lender) {
        return new UnEquallySplitTicket(name, debtAmount, lender);
    }
}
