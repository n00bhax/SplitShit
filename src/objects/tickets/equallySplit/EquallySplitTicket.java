package objects.tickets.equallySplit;

import objects.Person;
import objects.tickets.Ticket;

public abstract class EquallySplitTicket extends Ticket {

    public EquallySplitTicket(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
