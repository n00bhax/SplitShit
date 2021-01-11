package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class RestaurantTicketUS extends UnEquallySplitTicket {
    public RestaurantTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public TicketTypes getType() {
        return TicketTypes.RESTAURANT;
    }

    @Override
    public String toString() {
        return super.toString() + "(Restaurant)";
    }

}
