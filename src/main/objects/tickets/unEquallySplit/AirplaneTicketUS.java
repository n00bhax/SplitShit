package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class AirplaneTicketUS extends UnEquallySplitTicket {

    public AirplaneTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public TicketTypes getType() {
        return TicketTypes.AIRPLANE;
    }

    @Override
    public String toString() {
        return super.toString() + "(Airplane)";
    }
}
