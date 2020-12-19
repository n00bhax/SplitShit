package objects.tickets.equallySplit;

import objects.Person;

public class PartyTicketES extends EquallySplitTicket{
    public PartyTicketES(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public String toString() {
        return super.toString() + "(Party)";
    }
}
