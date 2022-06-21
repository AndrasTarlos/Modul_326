package view.components;

import employees.Person;
import utils.DatahandlerJSON;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author: Francesco Ryu/Andras Tarlos
 * @version: 5.0
 * @date: 20.06.2022
 * <h2>Description</h2>
 * Creates personInfo with nameInputTextField, personNameLabel and imagePlaceHolder
 */

public class PersonInfo extends JPanel {
    JTextField nameInputTextField;
    JLabel personNameLabel;

    JLabel imagePlaceHolder;

    private static final URI imgPath;

    static {
        try {
            imgPath = Objects.requireNonNull(DatahandlerJSON.class.getResource("../IMAGES/profile.png")).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The constructor of the PersonInfo class
     * @param textFieldEditable a boolean value (if true then you can write the name inside the textField)
     */

    public PersonInfo(boolean textFieldEditable) {
        personNameLabel = new JLabel("  Name: ");

        /**
         * Creates TextField to display/edit person name
         */

        nameInputTextField = new JTextField();
        nameInputTextField.setColumns(25);
        nameInputTextField.setEditable(true);

        /**
         * Creates image to the panel
         */

        ImageIcon profileImage = new ImageIcon(Paths.get(imgPath).toString());

        imagePlaceHolder = new JLabel(profileImage);
        imagePlaceHolder.setPreferredSize(new Dimension(200, 200));
        imagePlaceHolder.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));

        this.add(personNameLabel);
        this.add(nameInputTextField);
        this.add(imagePlaceHolder);
        this.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
        if (!textFieldEditable) {
            nameInputTextField.setEditable(false);
        }
    }


    public void update(Person person) {
        nameInputTextField.setText(person.getFirstName() + " " + person.getLastName());
    }
}
