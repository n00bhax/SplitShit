package controller;

import database.Persons;
import database.Tickets;
import objects.Person;
import objects.Ticket;

public class Controller {

    private Tickets tickets;
    private Persons persons;


    public Controller(Tickets tickets, Persons persons) {
        this.tickets = tickets;
        this.persons = persons;
    }

    public void addTicket(String name, double totalPrice){
        Ticket t = new Ticket(name, totalPrice);
        tickets.add(name, t);
    }

    public void addPerson(String name){
        Person p = new Person(name);
        persons.add(name, p);
    }

    public void addPersonToTicket(String ticketName, String personName, double amountPayed){
        Ticket t = tickets.getObject(ticketName);
        Person p = persons.getObject(personName);
        t.addPerson(p, amountPayed );
    }

    public void printAllTickets(){
        for (Ticket t: tickets){
            t.print();
        }
    }

}
