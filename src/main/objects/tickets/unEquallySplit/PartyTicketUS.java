package objects.tickets.unEquallySplit;

import objects.Person;

public class PartyTicketUS extends UnEquallySplitTicket {
    public PartyTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public String toString() {
        return super.toString() + "(Party)";
    }
}
