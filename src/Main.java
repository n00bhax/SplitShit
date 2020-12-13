import controller.Controller;
import view.windows.MainWindow;

public class Main {
    public static void main(String[] args) {


        Controller c = new Controller();
        MainWindow v = new MainWindow();
        v.initialize(c);

        c.addPropertyChangeListener(v);

        c.addPerson("willem");
        c.addPerson("herman");
        c.addPerson("bart");


        c.addTicket("tikkie", 5, c.getPerson("willem"), true);
        c.addPersonToTicket("tikkie", "herman", 3);
        c.addPersonToTicket("tikkie", "bart", 1);




    }
}

