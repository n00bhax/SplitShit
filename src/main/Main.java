import controller.Controller;
import objects.Person;
import objects.tickets.TicketTypes;
import view.windows.MainWindow;

import java.util.LinkedHashMap;

//to do
/*
bij aanmaak ticket ook soort ticket aanduiden (cinema en zo)
toString van deze types aanpassen zodat het mee in de ui staat

tests maken

schema maken

 */

public class Main {
    public static void main(String[] args) {

        MainWindow v = new MainWindow();
        v.initialize();

        dummyStuff(v);

    }

    public static void dummyStuff(MainWindow v){
        Controller c = new Controller();

        c.addPropertyChangeListener(v);

        c.addPerson("willem");
        c.addPerson("herman");
        c.addPerson("bart");
        c.addPerson("Manfred");


        c.addTicket("tikkie", 5, "willem", false, TicketTypes.OTHER);
        c.addPersonToTicket("tikkie", "herman", 3);
        c.addPersonToTicket("tikkie", "bart", 1);

        c.addTicket("nog1", 10, "willem", true , TicketTypes.OTHER);
        c.addPersonToTicket("nog1", "herman", 0.0);
        c.addPersonToTicket("nog1", "Manfred", 0.0);

        c.addTicket("nog2", 50, "herman", true , TicketTypes.OTHER);
        c.addPersonToTicket("nog2", "herman", 0.0);
        c.addPersonToTicket("nog2", "willem", 0.0);

    }

}


