import controller.Controller;
import view.windows.MainWindow;

//to do
/*
equally split bij aanmaak ticket --> andere opties (geld hoeveelheid bij unequally)
bij aanmaak ticket ook soort ticket aanduiden (cinema en zo)
iets van eind rekening calculeren.

 */

public class Main {
    public static void main(String[] args) {

        MainWindow v = new MainWindow();
        v.initialize();

        Controller c = new Controller();

        c.addPropertyChangeListener(v);

        c.addPerson("willem");
        c.addPerson("herman");
        c.addPerson("bart");


        c.addTicket("tikkie", 5, "willem", true);
        c.addPersonToTicket("tikkie", "herman", 3);
        c.addPersonToTicket("tikkie", "bart", 1);




    }
}

