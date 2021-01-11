package view.windows.addWindow;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class BillWindow extends JFrame {

    public BillWindow(){

        super("Bill");

        DefaultListModel<String> dbListModel = new DefaultListModel<>();
        JList<String> dbJList = new JList<>(dbListModel);

        this.add(dbJList);

        this.setSize(400,200);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../image.png")));

        Controller controller = new Controller();
        for (String s : controller.calculateBill()){
            dbListModel.addElement(s);
        }

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
