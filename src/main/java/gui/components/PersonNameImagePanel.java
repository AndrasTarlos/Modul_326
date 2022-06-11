package gui.components;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PersonNameImagePanel extends JPanel {
    JTextField nameInputTextField;
    JLabel personNameLabel;

    JLabel imagePlaceHolder;
    JLabel imageLabel;

    public PersonNameImagePanel() {
        PersonOverview personOverview = new PersonOverview();
        personNameLabel = new JLabel("  Name: ");
        ImageIcon picture = new ImageIcon("img.png");

        nameInputTextField = new JTextField("PLACEHOLDER");
        nameInputTextField.setColumns(25);
        nameInputTextField.setEditable(false);

        imagePlaceHolder = new JLabel();
        imagePlaceHolder.setPreferredSize(new Dimension(200, 200));
        imagePlaceHolder.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        imagePlaceHolder.setText("PLACEHOLDER");

        this.add(personNameLabel);
        this.add(nameInputTextField);
        this.add(imagePlaceHolder);
    }
}
