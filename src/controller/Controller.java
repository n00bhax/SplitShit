package controller;

import database.Database;
import objects.Person;
import objects.Ticket;
import view.View;

import java.beans.PropertyChangeListener;

public class Controller {

    private Database<Ticket> tickets = Database.getTicketDatabase();
    private Database<Person> persons = Database.getPersonDatabase();

    private PropertyChangeListener pcl;

    public Controller() {

    }

    public void addTicket(String name, double totalPrice){
        Ticket t = new Ticket(name, totalPrice);
        t.addPropertyChangeListener(pcl);
        tickets.add(name, t);
    }

    public void addPerson(String name){
        Person p = new Person(name);
        //p.addPropertyChangeListener(pcl);
        persons.add(name, p);
    }

    public void addPersonToTicket(String ticketName, String personName, double amountPayed){
        Ticket t = tickets.get(ticketName);
        Person p = persons.get(personName);
        t.addPerson(p, amountPayed );
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        this.pcl = pcl;
        tickets.addPropertyChangeListener(pcl);
        persons.addPropertyChangeListener(pcl);
    }
    public void printAllTickets(){
        for (Ticket t: tickets){
            System.out.println(t);
        }
    }

}
