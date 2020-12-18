package view.windows;

import controller.Controller;
import database.Database;
import objects.Person;
import objects.tickets.Ticket;
import view.DatabaseType;
import view.panels.DatabasePanel;
import view.windows.addWindow.BillWindow;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainWindow extends JFrame implements PropertyChangeListener {

    private final Controller controller = new Controller();

    private DatabasePanel<Ticket> ticketsPanel;
    private DatabasePanel<Person> personsPanel;
    private JButton calculateBill;

    public MainWindow() {
        super("SplitShit");
    }

    public void initialize()
    {

        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../image.png")));

        ticketsPanel = new DatabasePanel(Database.getTicketDatabase(), "Tickets", DatabaseType.TICKET, controller);
        personsPanel = new DatabasePanel(Database.getPersonDatabase(), "Persons", DatabaseType.PERSON, controller);

        calculateBill = new JButton("Calculate Bill");

        this.add(ticketsPanel);
        this.add(personsPanel);
        this.add(calculateBill);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        buttonListener();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ticketsPanel.refresh();
        personsPanel.refresh();

    }

    private void buttonListener(){
        this.calculateBill.addActionListener(l ->
        {
            BillWindow w = new BillWindow();
        });
    }

}
