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

/**
 * @Author: Francesco Ryu/Andras Tarlos
 * @Date: 15.06.2022
 * @Version: 15.1
 */

public class PersonInfoPanel extends JPanel {
    JTextField nameInputTextField;
    JLabel personNameLabel;

    JLabel imagePlaceHolder;
    JLabel imageLabel;

    private static URI imgPath;

    static {
        try {
            imgPath = Objects.requireNonNull(ReadWriteJSON.class.getResource("../IMAGES/profile.png")).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonInfoPanel() {
        personNameLabel = new JLabel("  Name:  ");
        ImageIcon personPic = new ImageIcon(Paths.get(imgPath).toString());
        JLabel imgLabel = new JLabel(personPic);
        imgLabel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));

        nameInputTextField = new JTextField();
        nameInputTextField.setColumns(25);
        nameInputTextField.setEditable(false);

        /*imagePlaceHolder = new JLabel();
        imagePlaceHolder.setPreferredSize(new Dimension(200, 200));
        imagePlaceHolder.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        imagePlaceHolder.add(imgLabel);*/

        this.add(personNameLabel);
        this.add(nameInputTextField);
        this.add(imgLabel, BorderLayout.CENTER);
        this.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
    }

    public void update(Person person) {
        nameInputTextField.setText(person.getFirstName() + " " + person.getLastName());
    }
}
