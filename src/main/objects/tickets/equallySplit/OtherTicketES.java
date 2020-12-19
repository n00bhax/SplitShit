package objects.tickets.equallySplit;

import objects.Person;

public class OtherTicketES extends EquallySplitTicket{
    public OtherTicketES(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public String toString() {
        return super.toString() + "(Other)";
    }
}
