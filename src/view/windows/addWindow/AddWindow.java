package view.windows.addWindow;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public abstract class AddWindow extends JFrame {

    protected JButton createButton;
    protected Controller controller;
    protected GridBagConstraints c = new GridBagConstraints();


    protected AddWindow(String title, Controller controller) {

        super(title);
        this.controller = controller;

        this.createButton = new JButton("Create");

        this.setLayout(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;

        createButtonListener();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public abstract void createButtonListener();

}
