package view;

import controller.Controller;
import database.Database;
import objects.Person;
import objects.tickets.Ticket;
import view.panels.DatabasePanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewFrame extends JFrame implements PropertyChangeListener {

    private Controller controller;
    DatabasePanel<Ticket> ticketsPanel;
    DatabasePanel<Person> personsPanel;

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

        ticketsPanel = new DatabasePanel(Database.getTicketDatabase(), "Tickets");
        personsPanel = new DatabasePanel(Database.getPersonDatabase(), "Persons");
        this.add(ticketsPanel);
        this.add(personsPanel);

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ticketsPanel.refresh();
        personsPanel.refresh();

        //jframe grid layout

    }
}
