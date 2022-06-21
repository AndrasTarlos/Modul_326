package view.popups;

import employees.HRPerson;
import view.components.PersonInfo;
import view.components.PersonOverview;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * @author: Francesco Ryu
 * @version: 4.0
 * @date: 20.06.2022
 */

public class CreateEditPerson extends JDialog {
    PersonInfo personInfoPanel;
    JCheckBox hrPersonCheckBox;
    JCheckBox administratorCheckBox;


    JPanel checkBoxPanel;
    JPanel buttonPanel;

    JPanel pwdPanel;

    JLabel pwdLabel;

    JTextField pwdTextField;
    JButton quitButton;
    JButton saveButton;

    public CreateEditPerson(PersonOverview personOverview) {
        personInfoPanel = new PersonInfo(true);

        pwdPanel = new JPanel();
        pwdLabel = new JLabel();
        pwdLabel.setText("Passwort hinzufügen:");
        pwdTextField = new JTextField();
        pwdTextField.setEnabled(false);
        pwdTextField.setColumns(15);
        pwdPanel.add(pwdLabel);
        pwdPanel.add(pwdTextField);
        pwdPanel.setVisible(true);

        hrPersonCheckBox = new JCheckBox("HR-Mitarbeiter");
            hrPersonCheckBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    pwdTextField.setEnabled(true);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    pwdTextField.setEnabled(false);
                }
            });

        administratorCheckBox = new JCheckBox("Administrator");
        administratorCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pwdTextField.setEnabled(true);
            }
            else if (e.getStateChange() == ItemEvent.DESELECTED) {
                pwdTextField.setEnabled(false);
            }
        });

        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        checkBoxPanel.add(hrPersonCheckBox, BorderLayout.NORTH);
        checkBoxPanel.add(administratorCheckBox, BorderLayout.CENTER);
        checkBoxPanel.add(pwdPanel, BorderLayout.SOUTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        quitButton = new JButton(" Abbrechen ");
        quitButton.addActionListener(e -> this.setVisible(false));
        saveButton = new JButton(" Speichern ");
        buttonPanel.add(saveButton, BorderLayout.EAST);
        buttonPanel.add(quitButton, BorderLayout.WEST);
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        saveButton.addActionListener(e -> {
            // Only accept the "speichern" button, if the user has entered a name
            if (!personInfoPanel.getName().equals("")) {
                HRPerson p = new HRPerson();

                // Set the modus or / and the password if needed
                if (administratorCheckBox.isSelected()) {
                    p.setModus(2);
                    p.setPwd(pwdTextField.getText());
                } else if (hrPersonCheckBox.isSelected()) {
                    p.setModus(1);
                    p.setPwd(pwdTextField.getText());
                } else {
                    p.setModus(0);
                    p.setPwd(null);
                }
                // Set the name of the new person
                String[] nameSplit = personInfoPanel.getName().split(" ");
                p.setFirstName(nameSplit[0]);
                if (nameSplit.length > 1)
                    p.setLastName(nameSplit[1]);

                utils.Menu.fascade.createPerson(p);
                personOverview.updateButtons();
                this.setVisible(false);
            }
        });

        this.setLayout(new BorderLayout());
        this.setTitle("Person erfassen");
        this.add(personInfoPanel, BorderLayout.NORTH);
        this.add(checkBoxPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setSize(400, 400);
    }
}
