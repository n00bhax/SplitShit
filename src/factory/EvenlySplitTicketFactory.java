package factory;

import objects.tickets.EvenlySplitTicket;
import objects.tickets.Ticket;

public class EvenlySplitTicketFactory extends TicketFactory{
    @Override
    public Ticket createTicket(String name, double totalPrice) {
        return new EvenlySplitTicket(name, totalPrice);
    }
}
