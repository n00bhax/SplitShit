package view.panels;

import controller.Controller;
import database.Database;
import objects.tickets.Ticket;
import view.DatabaseType;
import view.windows.addWindow.AddPersonWindow;
import view.windows.addWindow.AddTicketWindow;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DatabasePanel<E> extends JPanel{

    private final JList<E> dbJList;
    private final DefaultListModel<E> dbListModel;

    private final JButton addButton;
    private final JButton removeButton;

    private final Database<E> db;
    private final DatabaseType dbType;

    private final Controller controller;

    public DatabasePanel(Database<E> db, String title, DatabaseType dbType, Controller controller)
    {
        this.db = db;
        this.dbType = dbType;
        this.controller = controller;

        JLabel label = new JLabel(title);
        dbListModel = new DefaultListModel<>();
        dbJList = new JList<>(dbListModel);
        addButton = new JButton("+");
        removeButton = new JButton("-");

        addButtonListener();
        removeButtonListener();
        addMouseListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(label);
        this.add(dbJList);
        this.add(addButton);
        this.add(removeButton);

    }

    public void addButtonListener(){
        this.addButton.addActionListener(l ->
            {
                if (dbType == DatabaseType.PERSON){
                    AddPersonWindow w = new AddPersonWindow(controller);
                    w.initialize();
                } else if (dbType == DatabaseType.TICKET){
                    AddTicketWindow w = new AddTicketWindow(controller);
                    w.initialize();
                }

            });
    }

    public void removeButtonListener(){
        this.removeButton.addActionListener(l ->
        {
            E value = dbJList.getSelectedValue();
            String key = value.toString().split(":")[0];
            db.remove(key);

        });
    }

    public void addMouseListener(){
        if (dbType == DatabaseType.TICKET)
            dbJList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // Double-click detected

                        E value = dbJList.getSelectedValue();
                        String key = value.toString().split(":")[0];

                        //make new ticket with info from previous
                        AddTicketWindow w = new AddTicketWindow(controller);
                        w.copyTicket((Ticket) db.get(key));

                        //delete old ticket
                        db.remove(key);
                    }
                }

            });
    }

    public void refresh(){

        dbListModel.clear();

        for(E e: this.db)
            this.dbListModel.addElement(e);

    }

}
