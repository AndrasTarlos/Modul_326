package gui;


import gui.buttons.AddButton;

import gui.components.PersonAssignmentSettings;
import gui.components.PersonInfo;
import gui.components.PersonOverview;
import gui.buttons.DeleteButton;
import gui.buttons.EditButton;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

public class PersonPane extends JPanel {
    AddButton addButton;
    EditButton editButton;
    DeleteButton deleteButton;

    JPanel personEditPanel;
    JPanel personDetailPanel;

    PersonOverview personOverview;
    PersonInfo personInfo;

    JPanel southPanel;
    JPanel buttonPanel;
    public PersonPane() throws IOException {
        personEditPanel = new JPanel();
        personEditPanel.setLayout(new BorderLayout());
        personEditPanel.setBorder(new TitledBorder("   Personen bearbeiten:   "));

        personOverview = new PersonOverview(personInfo = new PersonInfo(), null, false);
        personOverview.setPreferredSize(new Dimension(170, 0));

        personDetailPanel = new JPanel();
        personDetailPanel.setBorder(new TitledBorder("   Detail:   "));
        personDetailPanel.setLayout(new GridLayout(2, 1));
        personDetailPanel.add(personInfo);

        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();


        addButton = new AddButton();
        editButton = new EditButton();
        deleteButton = new DeleteButton();

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        southPanel.add(buttonPanel, BorderLayout.WEST);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        personEditPanel.add(personOverview, BorderLayout.WEST);

        this.setLayout(new BorderLayout());
        this.add(personEditPanel);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}
