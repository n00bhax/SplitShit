package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.Ticket;

public class UnEquallySplitTicket extends Ticket {

    public UnEquallySplitTicket(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
