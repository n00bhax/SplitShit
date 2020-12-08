package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.equallySplit.EquallySplitTicket;

public class PartyTicketUS extends UnEquallySplitTicket {
    public PartyTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
