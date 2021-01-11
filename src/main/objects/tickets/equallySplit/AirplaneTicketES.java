package objects.tickets.equallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class AirplaneTicketES extends EquallySplitTicket {

    public AirplaneTicketES(String ticketName, double debtAmount, Person lender) {
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
