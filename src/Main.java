import controller.Controller;
import objects.tickets.TicketTypes;
import view.windows.MainWindow;

//to do
/*
bij aanmaak ticket ook soort ticket aanduiden (cinema en zo)
toString van deze types aanpassen zodat het mee in de ui staat
iets van eind rekening calculeren.

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


        c.addTicket("tikkie", 5, "willem", true, TicketTypes.OTHER);
        c.addPersonToTicket("tikkie", "herman", 3);
        c.addPersonToTicket("tikkie", "bart", 1);
    }

}


