package view;

import controller.Controller;
import database.Database;
import view.panels.TicketsPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewFrame extends JFrame implements PropertyChangeListener {

    private Controller controller;
    TicketsPanel panel;

    public ViewFrame() {
        super("SplitShit");
    }

    public void initialize(Controller controller)
    {
        this.controller = controller;

        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        panel = new TicketsPanel();
        this.add(panel);

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("SOMETHING HAS CHANGED");


        System.out.println("Persons: " + Database.getPersonDatabase());
        System.out.println("Tickets: " + Database.getTicketDatabase());

        panel.refresh();

        //System.out.println(evt.getNewValue());

    }
}
