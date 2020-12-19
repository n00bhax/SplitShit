package objects.tickets.unEquallySplit;

import objects.Person;

public class RestaurantTicketUS extends UnEquallySplitTicket {
    public RestaurantTicketUS(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public String toString() {
        return super.toString() + "(Restaurant)";
    }

}
