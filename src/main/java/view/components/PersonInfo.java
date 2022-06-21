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
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 * @author: Francesco Ryu / Andras Tarlos
 * @version: 5.0
 * @date: 20.06.2022
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

    public PersonInfo(boolean textFieldEditable) {
        personNameLabel = new JLabel("  Name: ");

        nameInputTextField = new JTextField();
        nameInputTextField.setColumns(25);
        nameInputTextField.setEditable(true);

        PromptSupport.setPrompt("Vorname und Nachname eingeben", nameInputTextField);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, nameInputTextField);

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

    public String getName() {
        return nameInputTextField.getText();
    }
}
