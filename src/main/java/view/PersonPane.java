package view;


import employees.HRPerson;
import view.buttons.AddButton;

import view.components.PersonInfo;
import view.components.PersonOverview;
import view.buttons.DeleteButton;
import view.buttons.EditButton;
import view.popups.CreatePerson;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PersonPane extends JPanel {
    AddButton addButton;
    EditButton editButton;
    DeleteButton deleteButton;

    JPanel personEditPanel;
    JPanel personDetailPanel;
    JPanel checkBoxPanel;

    JCheckBox hrPersonCheckBox;
    JCheckBox administratorCheckBox;

    PersonOverview personOverview;
    PersonInfo personInfo;
    CreatePerson createPerson;

    JPanel southPanel;
    JPanel buttonPanel;

    HRPerson focusedPerson;

    public PersonPane() {
        hrPersonCheckBox = new JCheckBox("HR-Mitarbeiter ");
        hrPersonCheckBox.setFocusable(false);
        hrPersonCheckBox.setEnabled(false);

        administratorCheckBox = new JCheckBox("Administrator ");
        administratorCheckBox.setFocusable(false);
        administratorCheckBox.setEnabled(false);

        checkBoxPanel = new JPanel();

        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        checkBoxPanel.add(hrPersonCheckBox);
        checkBoxPanel.add(administratorCheckBox);

        personEditPanel = new JPanel();
        personEditPanel.setLayout(new BorderLayout());
        personEditPanel.setBorder(new TitledBorder("   Personen bearbeiten:   "));

        personOverview = new PersonOverview(personInfo = new PersonInfo(true), null, this,  false);
        personOverview.setPreferredSize(new Dimension(170, 0));

        personDetailPanel = new JPanel();
        personDetailPanel.setBorder(new TitledBorder("   Detail:   "));
        personDetailPanel.setLayout(new GridLayout(2, 1));
        personDetailPanel.add(personInfo);

        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();

        personDetailPanel.add(checkBoxPanel);

        addButton = new AddButton();
        editButton = new EditButton();
        deleteButton = new DeleteButton();

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        createPerson = new CreatePerson();
        createPerson.setVisible(false);

        addButton.addActionListener(e -> {
            createPerson.setVisible(true);
        });

        southPanel.add(buttonPanel, BorderLayout.WEST);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        personEditPanel.add(personOverview, BorderLayout.WEST);

        this.setLayout(new BorderLayout());
        this.add(personEditPanel);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    public void updateCheckBox(HRPerson person) {
        setFocusedPerson(person);

        hrPersonCheckBox.setSelected(false);
        administratorCheckBox.setSelected(false);
        switch (person.getModus()) {
            case 1 -> hrPersonCheckBox.setSelected(true);
            case 2 -> administratorCheckBox.setSelected(true);
        }
    }

    public void setFocusedPerson(HRPerson person) {
        this.focusedPerson = person;
    }

}
