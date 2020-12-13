package view.windows.addWindow;

import controller.Controller;
import database.Database;
import objects.Person;
import objects.tickets.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class AddTicketWindow extends AddWindow {

    private JTextField ticketName;
    private JTextField totalPrice;
    private JComboBox<String> persons;
    private JButton equallyButton;
    private JButton unEquallyButton;


    public AddTicketWindow(Controller controller) {
        super("New ticket", controller);
    }

    public void initialize()
    {
        ticketName = new JTextField(10);
        totalPrice = new JTextField(10);
        persons = new JComboBox<String>(Database.getPersonDatabase().getKeys());
        equallyButton = new JButton("Equally split");
        unEquallyButton = new JButton("Unequally split");

        this.add(new JLabel("Enter ticket name:"), c);
        c.gridy++;
        this.add(ticketName, c);
        c.gridy++;

        this.add(new JLabel("Enter total price:"), c);
        c.gridy++;
        this.add(totalPrice, c);
        c.gridy++;

        this.add(new JLabel("Choose lender:"), c);
        c.gridy++;
        this.add(persons, c);
        c.gridy++;

        this.add(equallyButton, c);
        c.gridy++;
        this.add(unEquallyButton, c);
        c.gridy++;

        this.add(createButton,c);

        this.setSize(250, 400);

        equallyButtonListener();
    }

    public void equallyButtonListener(){
        this.equallyButton.addActionListener(l ->
        {
            //hier is nog iets raar
            this.remove(equallyButton);

        });
    }

    public void createButtonListener(){
        this.createButton.addActionListener(l ->
        {
            String lender = (String) persons.getSelectedItem();
            controller.addTicket(ticketName.getText(), Double.parseDouble(totalPrice.getText()), lender, true );
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }


}
