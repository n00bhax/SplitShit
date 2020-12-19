package view.windows.addWindow;

import controller.Controller;
import database.Database;
import objects.tickets.TicketTypes;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class AddTicketWindow extends AddWindow {

    private JTextField ticketName;
    private JTextField totalPrice;
    private JTextField individualPrice;
    private JLabel individualPriceHere;
    private JComboBox<String> lenderCB;
    private JComboBox<TicketTypes> ticketTypeCB;

    private JToggleButton isUnequallySplit;

    private JComboBox<String> lendingCB;
    private JButton add;
    private JList<String> personJList;
    private DefaultListModel<String> personListModel;


    public AddTicketWindow(Controller controller) {
        super("New ticket", controller);
    }

    public void initialize()
    {
        ticketName = new JTextField(10);
        totalPrice = new JTextField(10);
        individualPrice = new JTextField(10);
        individualPriceHere = new JLabel("Individual price for selected person:");
        lenderCB = new JComboBox<>(Database.getPersonDatabase().getKeys());
        lendingCB = new JComboBox<>(Database.getPersonDatabase().getKeys());
        ticketTypeCB = new JComboBox<>(TicketTypes.values());
        isUnequallySplit = new JToggleButton("Split unequally", false);
        add = new JButton("+");

        personListModel = new DefaultListModel<>();
        personJList = new JList<>(personListModel);

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
        this.add(lenderCB, c);
        c.gridy++;

        this.add(ticketTypeCB, c);
        c.gridy++;

        this.add(isUnequallySplit, c);
        c.gridy++;

        this.add(new JLabel("Choose lending:"), c);
        c.gridy++;

        this.add(lendingCB, c);
        c.gridy++;

        this.add(add, c);
        c.gridy++;

        this.add(personJList, c);
        c.gridy++;

        this.add(createButton,c);
        c.gridy++;

        this.setSize(250, 400);

        equallyButtonListener();
        addButtonListener();
        individualPriceListener();
    }

    public void addButtonListener(){
        this.add.addActionListener(l ->
        {
            String p = (String) lendingCB.getSelectedItem();
            personListModel.addElement(p);

        });
    }

    public void equallyButtonListener(){
        this.isUnequallySplit.addActionListener(l ->
        {
            if ( isUnequallySplit.getModel().isSelected()){

                this.remove(createButton);

                this.add(individualPriceHere, c);
                c.gridy++;
                this.add(individualPrice, c);
                c.gridy++;
                this.add(createButton, c);
                c.gridy++;
            } else {
                this.remove(individualPrice);
                this.remove(individualPriceHere);
            }

            SwingUtilities.updateComponentTreeUI(this);

        });
    }

    public void individualPriceListener(){
        this.individualPrice.addActionListener(l ->
        {
            int index = personJList.getSelectedIndex();
            String name = personListModel.getElementAt(index).split(": ")[0];
            double price = Double.parseDouble(individualPrice.getText());
            personListModel.setElementAt(name + ": " + price, index);

        });
    }

    public void createButtonListener(){
        this.createButton.addActionListener(l ->
        {
            String lender = (String) lenderCB.getSelectedItem();

            if ( isUnequallySplit.getModel().isSelected()){

                controller.addTicket(ticketName.getText(), Double.parseDouble(totalPrice.getText()), lender, false, (TicketTypes) ticketTypeCB.getSelectedItem());
                for (Object p : personListModel.toArray()){
                    String name = p.toString().split(": ")[0];
                    double amountPayed = Double.parseDouble(p.toString().split(": ")[1]);
                    controller.addPersonToTicket(ticketName.getText(), name, amountPayed);
                }

            } else {

                controller.addTicket(ticketName.getText(), Double.parseDouble(totalPrice.getText()), lender, true, (TicketTypes) ticketTypeCB.getSelectedItem());

                for (Object p : personListModel.toArray()){
                    controller.addPersonToTicket(ticketName.getText(), p.toString(), 0 );
                }
            }

            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }


}
