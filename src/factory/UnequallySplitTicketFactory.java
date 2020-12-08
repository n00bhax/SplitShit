package factory;

import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.TicketTypes;
import objects.tickets.equallySplit.OtherTicketES;
import objects.tickets.unEquallySplit.UnEquallySplitTicket;

public class UnequallySplitTicketFactory extends TicketFactory{

    @Override
    public Ticket createTicket(String name, double debtAmount, Person lender, TicketTypes ticketType) {

        switch (ticketType){
            //case "Airplane": return new AirplaneTicket(name, debtAmount, lender);
            //case "Party": return new PartyTicket(name, debtAmount, lender);
            //case "Restaurant": return new RestaurantTicket(name, debtAmount, lender);
        }
        return new OtherTicketES(name,debtAmount,lender);
    }
}
