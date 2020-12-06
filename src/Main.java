import controller.Controller;
import database.Database;
import objects.Person;
import objects.Ticket;
import view.View;

public class Main {
    public static void main(String[] args) {

        Controller c = new Controller();
        View v = new View(c);
        c.addPropertyChangeListener(v);


        //c.addPropertyChangeListener(v);

        c.addPerson("willem");
        c.addPerson("bart");

        c.addTicket("tikkie", 5);
        c.addPersonToTicket("tikkie", "willem", 3);
        c.addPersonToTicket("tikkie", "bart", 1);

        //c.printAllTickets();

    }
}

