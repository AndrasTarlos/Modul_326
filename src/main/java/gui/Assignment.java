package gui;

import gui.components.AssignmentSettings;
import gui.components.PersonInfo;
import gui.components.PersonOverview;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

/**
 * author: Francesco Ryu
 * date: 10.06.2022
 */

public class Assignment extends JPanel {

    JPanel personEditPanel;

    PersonOverview personOverviewPanel;
    JPanel personDetailPanel;
    PersonInfo personInfo;
    AssignmentSettings personAssignmentPanel;

    JLabel personEditLabel;


    public Assignment() throws IOException {
        this.setLayout(new BorderLayout());

        GridLayout personDetailLayout = new GridLayout(2, 0);

        personEditPanel = new JPanel();
        personInfo = new PersonInfo();
        personAssignmentPanel = new AssignmentSettings(true);
        personOverviewPanel = new PersonOverview(personInfo, personAssignmentPanel, false);
        personDetailPanel = new JPanel();

        personEditPanel.setBorder(new TitledBorder("   Person zuordnen:   "));
        personEditPanel.setLayout(new BorderLayout());
        personEditLabel = new JLabel("   Personen bearbeiten:   ");
        personEditPanel.add(personOverviewPanel, BorderLayout.WEST);

        personDetailPanel.setBorder(new TitledBorder("   Detail:   "));
        personDetailPanel.setLayout(personDetailLayout);
        personDetailPanel.add(personInfo);
        personDetailPanel.add(personAssignmentPanel);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(personEditPanel);
        this.setVisible(true);
    }
}
