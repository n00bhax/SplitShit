package view.panels;

import database.Database;
import objects.tickets.Ticket;

import javax.swing.*;

//Maak deze klasse algemeen voor database

public class DatabasePanel<E> extends JPanel{

    private JList<E> dbJList;
    private DefaultListModel<E> dbListModel;

    private Database<E> db;

    public DatabasePanel(Database<E> db, String titel)
    {
        this.db = db;
        JLabel label = new JLabel(titel);
        dbListModel = new DefaultListModel<>();
        dbJList = new JList<>(dbListModel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        this.add(dbJList);

    }

    public void refresh(){

        for(E e: this.db)
            this.dbListModel.addElement(e);
    }
}
