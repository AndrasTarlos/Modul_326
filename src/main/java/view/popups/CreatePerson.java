package view.popups;

import view.components.PersonInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author: Francesco Ryu
 * @Version: 4.0
 * @date: 20.06.2022
 */

public class CreatePerson extends JDialog {
    PersonInfo personInfoPanel;
    JCheckBox HRPersonCheckBox;
    JCheckBox administratorCheckBox;

    JPanel checkBoxPanel;
    JPanel buttonPanel;

    JButton quitButton;
    JButton saveButton;

    public CreatePerson() {
        personInfoPanel = new PersonInfo(true);

        HRPersonCheckBox = new JCheckBox("HR-Mitarbeiter");

        administratorCheckBox = new JCheckBox("Administrator");

        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        checkBoxPanel.add(HRPersonCheckBox);
        checkBoxPanel.add(administratorCheckBox);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        quitButton = new JButton(" Abbrechen ");
        quitButton.addActionListener(e -> this.setVisible(false));
        saveButton = new JButton(" Speichern ");
        buttonPanel.add(saveButton, BorderLayout.EAST);
        buttonPanel.add(quitButton, BorderLayout.WEST);
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.setLayout(new BorderLayout());
        this.setTitle("Person erfassen");
        this.add(personInfoPanel, BorderLayout.NORTH);
        this.add(checkBoxPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setSize(400, 400);
    }

}
