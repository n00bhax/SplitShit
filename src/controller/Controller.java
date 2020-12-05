package controller;

import database.Database;
import objects.Person;
import objects.Ticket;

import java.beans.PropertyChangeListener;

public class Controller {

    private Database<Ticket> tickets = Database.getTicketDatabase();
    private Database<Person> persons = Database.getPersonDatabase();

    public Controller() {

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
        Ticket t = tickets.get(ticketName);
        Person p = persons.get(personName);
        t.addPerson(p, amountPayed );
    }

    public void printAllTickets(){
        for (Ticket t: tickets){
            System.out.println(t);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        tickets.addPropertyChangeListener(pcl);
        persons.addPropertyChangeListener(pcl);
    }
}
