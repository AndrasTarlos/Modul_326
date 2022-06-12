package gui;

import gui.components.AddAssignmentPanel;
import gui.components.PersonInfoPanel;
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
    PersonInfoPanel personInfoPanel;
    AddAssignmentPanel personAssignmentPanel;

    JLabel personEditLabel;


    public Assignment() {
        this.setLayout(new BorderLayout());

        GridLayout personDetailLayout = new GridLayout(2, 0);

        personEditPanel = new JPanel();
        personInfoPanel = new PersonInfoPanel();
        personAssignmentPanel = new AddAssignmentPanel(true);
        personOverviewPanel = new PersonOverview(personInfoPanel, personAssignmentPanel);
        personDetailPanel = new JPanel();

        personEditPanel.setBorder(new TitledBorder("Person zuordnen:  "));
        personEditPanel.setLayout(new BorderLayout());
        personEditLabel = new JLabel("  Personen bearbeiten:");
        personEditPanel.add(personOverviewPanel, BorderLayout.WEST);

        personDetailPanel.setBorder(new TitledBorder("  Detail: "));
        personDetailPanel.setLayout(personDetailLayout);
        personDetailPanel.add(personInfoPanel);
        personDetailPanel.add(personAssignmentPanel);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(personEditPanel);
        this.setVisible(true);
    }
}
