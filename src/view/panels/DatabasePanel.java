package view.panels;

import controller.Controller;
import database.Database;
import view.DatabaseType;
import view.windows.addWindow.AddPersonWindow;
import view.windows.addWindow.AddTicketWindow;

import javax.swing.*;


public class DatabasePanel<E> extends JPanel{

    private JList<E> dbJList;
    private DefaultListModel<E> dbListModel;

    private JButton addButton;
    private JButton removeButton;

    private final Database<E> db;
    private DatabaseType dbType;

    private Controller controller;

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

    public void refresh(){

        dbListModel.clear();

        for(E e: this.db)
            this.dbListModel.addElement(e);

    }

}
