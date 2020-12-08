package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.equallySplit.EquallySplitTicket;

public class AirplaneTicketUS extends UnEquallySplitTicket {

    public AirplaneTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
