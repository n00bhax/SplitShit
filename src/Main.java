import controller.Controller;
import view.ViewFrame;

public class Main {
    public static void main(String[] args) {

        Controller c = new Controller();
        ViewFrame v = new ViewFrame();
        v.initialize(c);

        c.addPropertyChangeListener(v);

        c.addPerson("willem");
        c.addPerson("bart");

        c.addTicket("tikkie", 5, c.getPerson("willem"), false);
        c.addPersonToTicket("tikkie", "willem", 3);
        c.addPersonToTicket("tikkie", "bart", 1);


    }
}

