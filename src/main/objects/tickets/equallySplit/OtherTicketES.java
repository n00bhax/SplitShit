package objects.tickets.equallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class OtherTicketES extends EquallySplitTicket{
    public OtherTicketES(String ticketName, double debtAmount, Person lender) {
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
