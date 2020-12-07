package objects.tickets;

import objects.Person;

public class UnEquallySplitTicket extends Ticket{

    public UnEquallySplitTicket(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
