package objects.tickets.equallySplit;

import objects.Person;

public class RestaurantTicketES extends EquallySplitTicket{
    public RestaurantTicketES(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }
}
