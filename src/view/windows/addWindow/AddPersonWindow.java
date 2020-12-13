package view.windows.addWindow;

import controller.Controller;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class AddPersonWindow extends AddWindow {

    private JTextField textField;

    public AddPersonWindow(Controller controller){
        super("New person", controller);
    }

    public void initialize()
    {
        textField = new JTextField(10);

        this.add(new JLabel("Enter name:"), c);
        c.gridy++;
        this.add(textField,c);
        c.gridy++;
        this.add(createButton,c);

        this.setSize(250, 200);

    }

    public void createButtonListener(){
        this.createButton.addActionListener(l ->
        {
            String text = textField.getText();
            controller.addPerson(text);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }
}
