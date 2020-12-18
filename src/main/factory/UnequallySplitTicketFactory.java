package factory;

import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.TicketTypes;
import objects.tickets.unEquallySplit.*;

public class UnequallySplitTicketFactory extends TicketFactory{

    @Override
    public Ticket createTicket(String name, double debtAmount, Person lender, TicketTypes ticketType) {

        return switch (ticketType) {
            case AIRPLANE -> new AirplaneTicketUS(name, debtAmount, lender);
            case PARTY -> new PartyTicketUS(name, debtAmount, lender);
            case RESTAURANT -> new RestaurantTicketUS(name, debtAmount, lender);
            default -> new OtherTicketUS(name, debtAmount, lender);
        };
    }
}
