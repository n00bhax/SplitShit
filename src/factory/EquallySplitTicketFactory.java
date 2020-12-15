package factory;

import objects.Person;
import objects.tickets.TicketTypes;
import objects.tickets.equallySplit.*;
import objects.tickets.Ticket;


public class EquallySplitTicketFactory extends TicketFactory{

    @Override
    public Ticket createTicket(String name, double debtAmount, Person lender, TicketTypes ticketType) {
        return switch (ticketType) {
            case AIRPLANE -> new AirplaneTicketES(name, debtAmount, lender);
            case PARTY -> new PartyTicketES(name, debtAmount, lender);
            case RESTAURANT -> new RestaurantTicketES(name, debtAmount, lender);
            default -> new OtherTicketES(name, debtAmount, lender);
        };
    }
}
