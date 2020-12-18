package calculator;

import database.Database;
import factory.FactoryProducer;
import factory.TicketFactory;
import objects.Person;
import objects.tickets.Ticket;
import objects.tickets.TicketTypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

public class Calculator_ITest {

    public Calculator_ITest(){}

    @Before
    public void initialize(){

        Person p = new Person("willem");
        Person p2 = new Person("herman");
        Person p3 = new Person("manfred");

        Database.getPersonDatabase().add(p.getName(), p);
        Database.getPersonDatabase().add(p2.getName(), p2);
        Database.getPersonDatabase().add(p3.getName(), p3);

        TicketFactory f = FactoryProducer.getFactory(true);
        Ticket t = f.createTicket("testTicket", 50, p, TicketTypes.OTHER);

        Database.getTicketDatabase().add(t.getName(), t);

        t.addPerson(p, 0); //0 because equallySplit
        t.addPerson(p2, 0);
        t.addPerson(p3, 0);


        Ticket t2 = f.createTicket("testTicket2", 20, p3, TicketTypes.OTHER);

        Database.getTicketDatabase().add(t2.getName(), t2);
        t2.addPerson(p, 0);
        t2.addPerson(p3,0);

    }

    @Test
    public void t_calculateDebt(){
        Calculator c = new Calculator();

        Person p = Database.getPersonDatabase().get("willem");
        Person p2 = Database.getPersonDatabase().get("herman");

        LinkedHashMap<Person, LinkedHashMap<Person, Double>> bill = c.createBill();

        Assert.assertEquals("Willem paid 50 and it's equally split between 3 people. The result should be 16.66", 16.666, bill.get(p).get(p2), 0.001);

    }

    @Test
    public void t_calculateComplexDebt(){
        Calculator c = new Calculator();

        Person p = Database.getPersonDatabase().get("willem");
        Person p3 = Database.getPersonDatabase().get("manfred");

        LinkedHashMap<Person, LinkedHashMap<Person, Double>> bill = c.createBill();

        Assert.assertEquals("Willem paid 50 and it's equally split between 3 people. Everyone owes Willem 16.66. Willem, however, is also in debt with Manfred for another ticket. Therefore manfred only owes willem 16.66 - 10.0", 6.66, bill.get(p).get(p3), 0.01);
    }
}
