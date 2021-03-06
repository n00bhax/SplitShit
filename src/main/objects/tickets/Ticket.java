package objects.tickets;

import objects.Person;

import java.util.ArrayList;

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public Person getLender() {
        return lender;
    }

    public abstract TicketTypes getType();

    public abstract boolean isEquallySplit();

    public abstract void addPerson(Person p, double debtAmount);

    public abstract ArrayList<Person> getDebtors();

    public abstract Double getDebt(Person p);

    public boolean isLender(Person p){
        return p == lender;
    }

}
