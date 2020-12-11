package controller;

import database.Database;
import factory.FactoryProducer;
import factory.TicketFactory;
import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.TicketTypes;

import java.beans.PropertyChangeListener;

public class Controller {

    private final Database<Ticket> tickets = Database.getTicketDatabase();
    private final Database<Person> persons = Database.getPersonDatabase();

    // Ik gebruik geen Observers wegens deprecated in java 15. Jens zei dat het goed was.
    //private PropertyChangeListener pcl;

    public Controller() {

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl){
        //this.pcl = pcl;
        tickets.addPropertyChangeListener(pcl);
        persons.addPropertyChangeListener(pcl);
    }

    public void addTicket(String ticketName, double totalPrice, Person lender, boolean isEquallySplit){
        TicketFactory f = FactoryProducer.getFactory(isEquallySplit);
        Ticket t = f.createTicket(ticketName, totalPrice, lender, TicketTypes.OTHER);
        //t.addPropertyChangeListener(pcl);
        tickets.add(ticketName, t);
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
        if (t == null || p == null) {
            if (t == null)
                System.out.println(ticketName +" bestaat niet");
            if (p == null)
                System.out.println(personName+" bestaat niet");
            return;
        }
        t.addPerson(p, amountPayed );
    }


}
