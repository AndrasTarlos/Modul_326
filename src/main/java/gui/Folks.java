package gui;


import gui.components.buttons.AddButton;

import gui.components.PersonInfoPanel;
import gui.components.PersonOverview;
import gui.components.buttons.AddButton;
import gui.components.buttons.DeleteButton;
import gui.components.buttons.EditButton;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

public class Folks extends JPanel {
    AddButton addButton;
    EditButton editButton;
    DeleteButton deleteButton;

    JPanel personEditPanel;
    JPanel personDetailPanel;

    PersonOverview personOverview;
    PersonInfoPanel personInfoPanel;

    JPanel southPanel;
    public Folks() throws IOException {




        personEditPanel = new JPanel();
        personEditPanel.setLayout(new BorderLayout());
        personEditPanel.setBorder(new TitledBorder("   Personen bearbeiten:   "));

        personOverview = new PersonOverview(personInfoPanel = new PersonInfoPanel(), null, false);
        personOverview.setPreferredSize(new Dimension(170, 0));

        personDetailPanel = new JPanel();
        personDetailPanel.setBorder(new TitledBorder("   Detail:   "));
        personDetailPanel.setLayout(new GridLayout(2, 1));
        personDetailPanel.add(personInfoPanel);

        southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 9));

        addButton = new AddButton();
        editButton = new EditButton();
        deleteButton = new DeleteButton();

        southPanel.add(addButton);
        southPanel.add(editButton);
        //southPanel.add(deleteButton);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        personEditPanel.add(personOverview, BorderLayout.WEST);

        this.setLayout(new BorderLayout());
        this.add(personEditPanel);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}
