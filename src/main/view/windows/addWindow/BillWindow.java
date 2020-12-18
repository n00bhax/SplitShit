package view.windows.addWindow;

import calculator.Calculator;

import javax.swing.*;
import java.awt.*;

public class BillWindow extends JFrame {

    private final JList<String> dbJList;
    private final DefaultListModel<String> dbListModel;

    public BillWindow(){

        super("Bill");

        this.dbListModel = new DefaultListModel<>();
        this.dbJList = new JList<>(dbListModel);

        this.add(dbJList);

        this.setSize(400,200);

        Calculator c = new Calculator();
        for (String s :c.getBill()){
            dbListModel.addElement(s);
        }

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
