package gui;

import gui.components.PersonNameImagePanel;
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
    PersonNameImagePanel personNameImagePanel;
    JPanel personAssignmentPanel;

    JLabel personEditLabel;


    public Assignment() {
        this.setLayout(new BorderLayout());

        GridLayout personDetailLayout = new GridLayout(2, 0);

        personEditPanel = new JPanel();
        personOverviewPanel = new PersonOverview();
        personDetailPanel = new JPanel();
        personNameImagePanel = new PersonNameImagePanel();
        personAssignmentPanel = new JPanel();

        personEditPanel.setBorder(new TitledBorder("    Person bearbeiten:  "));
        personEditPanel.setLayout(new BorderLayout());
        personEditLabel = new JLabel("  Personen bearbeiten:");
        personEditPanel.add(personOverviewPanel, BorderLayout.WEST);

        personAssignmentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        personDetailPanel.setBorder(new TitledBorder("  Detail: "));
        personDetailPanel.setLayout(personDetailLayout);
        personDetailPanel.add(personNameImagePanel);
        personDetailPanel.add(personAssignmentPanel);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(personEditPanel);
        this.setVisible(true);
    }
}
