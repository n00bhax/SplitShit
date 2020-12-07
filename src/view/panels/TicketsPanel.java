package view.panels;

import database.Database;
import objects.tickets.Ticket;

import javax.swing.*;

public class TicketsPanel extends JPanel{

    private JList<Ticket> ticketsJList;
    private DefaultListModel<Ticket> ticketsListModel;

    private Database<Ticket> db = Database.getTicketDatabase();

    public TicketsPanel()
    {
        JLabel label = new JLabel("Tickets");
        ticketsListModel = new DefaultListModel<>();
        ticketsJList = new JList<>(ticketsListModel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        this.add(ticketsJList);

    }

    public void refresh(){

        for(Ticket t: this.db)
            this.ticketsListModel.addElement(t);
    }
}
