package gui.components;

import employees.Person;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class PersonInfoPanel extends JPanel {
    JTextField nameInputTextField;
    JLabel personNameLabel;

    JLabel imagePlaceHolder;
    JLabel imageLabel;

    public PersonInfoPanel() {
        personNameLabel = new JLabel("  Name: ");
        ImageIcon picture = new ImageIcon("img.png");

        nameInputTextField = new JTextField();
        nameInputTextField.setColumns(25);
        nameInputTextField.setEditable(false);

        imagePlaceHolder = new JLabel();
        imagePlaceHolder.setPreferredSize(new Dimension(200, 200));
        imagePlaceHolder.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));

        this.add(personNameLabel);
        this.add(nameInputTextField);
        this.add(imagePlaceHolder);
        this.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
    }

    public void update(Person person) {
        nameInputTextField.setText(person.getFirstName() + " " + person.getLastName());
    }
}
