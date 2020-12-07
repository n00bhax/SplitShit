package objects.tickets;

import objects.Person;

public class EquallySplitTicket extends Ticket {

    public EquallySplitTicket(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
