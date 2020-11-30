import objects.Person;
import objects.Ticket;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("willem");
        Ticket t = new Ticket("testTicket", 5);
        t.addPerson(p, 5);
        t.printDistribution();
        System.out.println(t.getName());
    }
}
