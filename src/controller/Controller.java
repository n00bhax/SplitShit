package controller;

import calculator.Calculator;
import database.Database;
import factory.FactoryProducer;
import factory.TicketFactory;
import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.TicketTypes;

import java.beans.PropertyChangeListener;
import java.util.LinkedHashMap;

public class Controller {

    private final Database<Ticket> tickets = Database.getTicketDatabase();
    private final Database<Person> persons = Database.getPersonDatabase();

    public Controller() {

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl){
        tickets.addPropertyChangeListener(pcl);
        persons.addPropertyChangeListener(pcl);
    }

    public void addTicket(String ticketName, double totalPrice, String lenderName, boolean isEquallySplit, TicketTypes type){

        Person lender = persons.get(lenderName);

        TicketFactory f = FactoryProducer.getFactory(isEquallySplit);

        Ticket t = f.createTicket(ticketName, totalPrice, lender, type);
        tickets.add(ticketName, t);
    }

    public void addPerson(String name){

        Person p = new Person(name);
        persons.add(name, p);
    }

    public void addPersonToTicket(String ticketName, String personName, double debtAmount){

        Ticket t = tickets.get(ticketName);
        Person p = persons.get(personName);

        if (t == null || p == null) {
            if (t == null)
                System.out.println(ticketName +" bestaat niet");
            if (p == null)
                System.out.println(personName+" bestaat niet");
            return;
        }

        t.addPerson(p, debtAmount);
    }

    public LinkedHashMap<Person, LinkedHashMap<Person, Double>> calculateBill(){
        Calculator calc = new Calculator();
        return calc.createBill();
    }

}
