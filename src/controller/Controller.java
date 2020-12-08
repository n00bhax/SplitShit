package controller;

import database.Database;
import factory.FactoryProducer;
import factory.TicketFactory;
import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.TicketTypes;

import java.beans.PropertyChangeListener;

public class Controller {

    private Database<Ticket> tickets = Database.getTicketDatabase();
    private Database<Person> persons = Database.getPersonDatabase();

    private PropertyChangeListener pcl;

    public Controller() {

    }

    public void addTicket(String name, double totalPrice, Person lender, boolean isEquallySplit){
        TicketFactory f = FactoryProducer.getFactory(isEquallySplit);
        Ticket t = f.createTicket(name, totalPrice, lender, TicketTypes.AIRPLANE);
        t.addPropertyChangeListener(pcl);
        tickets.add(name, t);
    }

    public void addPerson(String name){
        Person p = new Person(name);
        //p.addPropertyChangeListener(pcl);
        persons.add(name, p);
    }

    public Person getPerson(String name){
        return persons.get(name);
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
