package view.windows;

import controller.Controller;
import database.Database;
import objects.Person;
import objects.tickets.Ticket;
import view.DatabaseType;
import view.panels.DatabasePanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainWindow extends JFrame implements PropertyChangeListener {

    private final Controller controller = new Controller();
    DatabasePanel<Ticket> ticketsPanel;
    DatabasePanel<Person> personsPanel;

    public MainWindow() {
        super("SplitShit");
    }

    public void initialize()
    {

        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        ticketsPanel = new DatabasePanel(Database.getTicketDatabase(), "Tickets", DatabaseType.TICKET, controller);
        personsPanel = new DatabasePanel(Database.getPersonDatabase(), "Persons", DatabaseType.PERSON, controller);
        this.add(ticketsPanel);
        this.add(personsPanel);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ticketsPanel.refresh();
        personsPanel.refresh();

    }
}
