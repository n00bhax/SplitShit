package objects.tickets;

import objects.Person;

public abstract class Ticket {

    protected String name;
    protected double totalPrice;
    protected Person lender;

    public Ticket(String ticketName, double totalPrice, Person lender) {
        this.name = ticketName;
        this.totalPrice = totalPrice;
        this.lender = lender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public abstract void addPerson(Person p, double debtAmount);

}
