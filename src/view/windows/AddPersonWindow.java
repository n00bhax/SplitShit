package view.windows;

import controller.Controller;
import database.Database;
import objects.Person;
import view.DatabaseType;
import view.panels.DatabasePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class AddPersonWindow extends JFrame {

    private JTextField textField;
    private JLabel label;
    private JButton button;

    private final Database<Person> db = Database.getPersonDatabase();

    public AddPersonWindow(){
        super("Add a Person");
    }

    public void initialize()
    {
        textField = new JTextField();
        button = new JButton("Create");
        label = new JLabel("Enter name:");

        label.setBounds(50, 10, 100, 50);
        textField.setBounds(50, 50, 130, 30);
        button.setBounds(50,100,140, 40);

        this.add(label);
        this.add(textField);
        this.add(button);

        this.setLayout(null);
        this.setSize(250, 200);

        buttonListener();

        this.setVisible(true);
    }

    public void buttonListener(){
        this.button.addActionListener(l ->
        {
            String text = textField.getText();
            Person p = new Person(text);
            db.add(text, p);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }
}
