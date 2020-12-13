package view.panels;

import database.Database;
import objects.tickets.Ticket;
import view.DatabaseType;
import view.windows.AddPersonWindow;

import javax.swing.*;


public class DatabasePanel<E> extends JPanel{

    private JList<E> dbJList;
    private DefaultListModel<E> dbListModel;

    private JButton addButton;
    private JButton removeButton;

    private final Database<E> db;
    private DatabaseType dbType;

    public DatabasePanel(Database<E> db, String title, DatabaseType dbType)
    {
        this.db = db;
        this.dbType = dbType;

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
                    AddPersonWindow w = new AddPersonWindow();
                    w.initialize();
                } else if (dbType == DatabaseType.TICKET){

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
