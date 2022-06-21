package view.popups;

import view.components.PersonInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * @author: Francesco Ryu
 * @Version: 4.0
 * @date: 20.06.2022
 */

public class CreateEditPerson extends JDialog {
    PersonInfo personInfoPanel;
    JCheckBox HRPersonCheckBox;
    JCheckBox administratorCheckBox;


    JPanel checkBoxPanel;
    JPanel buttonPanel;

    JPanel pwdPanel;

    JLabel pwdLabel;

    JTextField pwdTextField;
    JButton quitButton;
    JButton saveButton;

    public CreateEditPerson() {
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

        HRPersonCheckBox = new JCheckBox("HR-Mitarbeiter");
            HRPersonCheckBox.addItemListener(e -> {
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
        checkBoxPanel.add(HRPersonCheckBox, BorderLayout.NORTH);
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

        this.setLayout(new BorderLayout());
        this.setTitle("Person erfassen");
        this.add(personInfoPanel, BorderLayout.NORTH);
        this.add(checkBoxPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setSize(400, 400);
    }

}
