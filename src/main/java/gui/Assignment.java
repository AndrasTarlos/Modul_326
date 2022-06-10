package gui;

import gui.components.PersonOverview;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * author: Francesco Ryu
 * date: 10.06.2022
 */

public class Assignment extends JPanel {

    JPanel personEditPanel;

    PersonOverview personOverviewPanel;
    JPanel personDetailPanel;
    JPanel personNameImagePanel;
    JPanel personAssignmentPanel;

    JLabel personEditLabel;
    JLabel personNameLabel;

    JTextField nameInputTextField;

    public Assignment() {
        this.setLayout(new BorderLayout());

        GridLayout personDetailLayout = new GridLayout(2, 0);

        personEditPanel = new JPanel();
        personOverviewPanel = new PersonOverview();
        personDetailPanel = new JPanel();
        personNameImagePanel = new JPanel();
        personAssignmentPanel = new JPanel();

        personEditPanel.setBorder(new TitledBorder("    Person bearbeiten:  "));

        personEditPanel.setLayout(new BorderLayout());

        nameInputTextField = new JTextField();
        nameInputTextField.setColumns(25);

        personEditLabel = new JLabel("  Personen bearbeiten:");
        personNameLabel = new JLabel("  Name: " );

        personEditPanel.add(personOverviewPanel, BorderLayout.WEST);

        //personNameImagePanel.setLayout(new GridLayout(2, 2));
        personNameImagePanel.add(personNameLabel);
        personNameImagePanel.add(nameInputTextField);

        personAssignmentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        personDetailPanel.setBorder(new TitledBorder("  Detail: "));
        personDetailPanel.setLayout(personDetailLayout);
        personDetailPanel.add(personNameImagePanel);
        personDetailPanel.add(personAssignmentPanel);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(personEditPanel);
        //this.add(personEditLabel, BorderLayout.PAGE_START);
        this.setVisible(true);
    }
}
