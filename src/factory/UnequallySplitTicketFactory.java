package factory;

import objects.tickets.Ticket;
import objects.tickets.UnequallySplitTicket;

public class UnequallySplitTicketFactory extends TicketFactory{
    @Override
    public Ticket createTicket(String name, double totalPrice) {
        return new UnequallySplitTicket(name, totalPrice);
    }
}
