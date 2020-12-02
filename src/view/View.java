package view;

import objects.Ticket;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("SOMETHING HAS CHANGED");
        System.out.println(evt.getNewValue());
        //newTicket.print();
        //System.out.println( (Ticket) evt.getNewValue().print());
    }
}
