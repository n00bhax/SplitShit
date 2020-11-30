import controller.Controller;
import database.Persons;
import database.Tickets;
import objects.Person;
import objects.Ticket;

public class Main {
    public static void main(String[] args) {

        Controller c = new Controller(Tickets.getInstance(), Persons.getInstance());

        c.addPerson("willem");
        c.addTicket("tikkie", 5);
        c.addPersonToTicket("tikkie", "willem", 5);
        c.printAllTickets();
    }
}
