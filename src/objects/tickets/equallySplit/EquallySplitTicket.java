package objects.tickets.equallySplit;

import objects.Person;
import objects.tickets.Ticket;

import java.util.ArrayList;

public abstract class EquallySplitTicket extends Ticket {

    private final ArrayList<Person> people = new ArrayList<>();

    public EquallySplitTicket(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public void addPerson(Person p, double debtAmount) {
        people.add(p);
    }

    @Override
    public String toString() {
        return name + ": " + lender.getName() + " payed " + totalPrice + people.toString();
    }

}
