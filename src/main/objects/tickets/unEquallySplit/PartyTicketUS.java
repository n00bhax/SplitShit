package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class PartyTicketUS extends UnEquallySplitTicket {
    public PartyTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public TicketTypes getType() {
        return TicketTypes.PARTY;
    }

    @Override
    public String toString() {
        return super.toString() + "(Party)";
    }
}
