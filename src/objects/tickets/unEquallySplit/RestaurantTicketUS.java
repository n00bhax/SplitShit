package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.equallySplit.EquallySplitTicket;

public class RestaurantTicketUS extends UnEquallySplitTicket {
    public RestaurantTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
