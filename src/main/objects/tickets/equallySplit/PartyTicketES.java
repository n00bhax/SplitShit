package objects.tickets.equallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class PartyTicketES extends EquallySplitTicket{
    public PartyTicketES(String ticketName, double debtAmount, Person lender) {
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
