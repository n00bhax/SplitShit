package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.equallySplit.EquallySplitTicket;

public class OtherTicketUS extends UnEquallySplitTicket {
    public OtherTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
