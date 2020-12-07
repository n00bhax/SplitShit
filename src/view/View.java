package view;

import controller.Controller;
import database.Database;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("SOMETHING HAS CHANGED");

        // zorg ervoor dat alles gerefreshed wordt hier.
        System.out.println("Persons: " + Database.getPersonDatabase());
        System.out.println("Tickets: " + Database.getTicketDatabase());

        //System.out.println(evt.getNewValue());

    }
}
