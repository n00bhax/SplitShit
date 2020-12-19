package objects.tickets.unEquallySplit;

import objects.Person;

public class OtherTicketUS extends UnEquallySplitTicket {
    public OtherTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public String toString() {
        return super.toString() + "(Other)";
    }
}
