package objects.tickets.equallySplit;

import objects.Person;

public class AirplaneTicketES extends EquallySplitTicket {

    public AirplaneTicketES(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public String toString() {
        return super.toString() + "(Airplane)";
    }
}
