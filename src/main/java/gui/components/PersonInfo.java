package gui.components;

import employees.Person;
import utils.ReadWriteJSON;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

public class PersonInfo extends JPanel {
    JTextField nameInputTextField;
    JLabel personNameLabel;

    JLabel imagePlaceHolder;

    private static final URI imgPath;

    static {
        try {
            imgPath = Objects.requireNonNull(ReadWriteJSON.class.getResource("../IMAGES/profile.png")).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonInfo() {
        personNameLabel = new JLabel("  Name: ");

        nameInputTextField = new JTextField();
        nameInputTextField.setColumns(25);
        nameInputTextField.setEditable(false);

        ImageIcon profileImage = new ImageIcon(Paths.get(imgPath).toString());

        imagePlaceHolder = new JLabel(profileImage);
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
