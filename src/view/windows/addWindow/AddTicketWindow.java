package view.windows.addWindow;

import controller.Controller;
import database.Database;
import objects.Person;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class AddTicketWindow extends AddWindow {

    private JTextField ticketName;
    private JTextField totalPrice;
    private JComboBox<String> lenderCB;

    private JToggleButton isUnequallySplit;

    private JComboBox<String> lendingCB;
    private JButton add;
    private JList<String> dbJList;
    private DefaultListModel<String> dbListModel;


    public AddTicketWindow(Controller controller) {
        super("New ticket", controller);
    }

    public void initialize()
    {
        ticketName = new JTextField(10);
        totalPrice = new JTextField(10);
        lenderCB = new JComboBox<>(Database.getPersonDatabase().getKeys());
        lendingCB = new JComboBox<>(Database.getPersonDatabase().getKeys());
        isUnequallySplit = new JToggleButton("Split unequally", false);
        add = new JButton("+");

        dbListModel = new DefaultListModel<>();
        dbJList = new JList<>(dbListModel);

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

        this.add(isUnequallySplit, c);
        c.gridy++;

        this.add(new JLabel("Choose lending:"), c);
        c.gridy++;

        this.add(lendingCB, c);
        c.gridy++;

        this.add(add, c);
        c.gridy++;

        this.add(dbJList, c);
        c.gridy++;

        this.add(createButton,c);
        c.gridy++;

        this.setSize(250, 400);

        equallyButtonListener();
        addButtonListener();
    }

    public void equallyButtonListener(){
        this.isUnequallySplit.addActionListener(l ->
        {
            boolean selected = isUnequallySplit.getModel().isSelected();
            System.out.println(selected);
            SwingUtilities.updateComponentTreeUI(this);

        });
    }

    public void addButtonListener(){
        this.add.addActionListener(l ->
        {
            String p = (String) lendingCB.getSelectedItem();
            dbListModel.addElement(p);

        });
    }

    public void createButtonListener(){
        this.createButton.addActionListener(l ->
        {
            String lender = (String) lenderCB.getSelectedItem();
            controller.addTicket(ticketName.getText(), Double.parseDouble(totalPrice.getText()), lender, true );

            for (Object p : dbListModel.toArray()){
                controller.addPersonToTicket(ticketName.getText(), p.toString(), 0 );
            }
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }


}
