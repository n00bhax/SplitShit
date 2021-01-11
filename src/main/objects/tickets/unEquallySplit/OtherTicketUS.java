package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class OtherTicketUS extends UnEquallySplitTicket {
    public OtherTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public TicketTypes getType() {
        return TicketTypes.OTHER;
    }

    @Override
    public String toString() {
        return super.toString() + "(Other)";
    }
}
