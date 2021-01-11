package objects.tickets.equallySplit;

import objects.Person;
import objects.tickets.TicketTypes;

public class RestaurantTicketES extends EquallySplitTicket{
    public RestaurantTicketES(String ticketName, double debtAmount, Person lender) {
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
