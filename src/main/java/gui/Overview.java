package gui;

import gui.components.AddAssignmentPanel;
import gui.components.PersonInfoPanel;
import gui.components.PersonOverview;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Overview extends JPanel {
    PersonInfoPanel personInfoPanel;
    AddAssignmentPanel personAssignmentPanel;
    JPanel personenPanel;
    PersonOverview personOverview;
    JPanel personDetailPanel;


    public Overview() {
        this.setLayout(new BorderLayout());
        personenPanel = new JPanel(new BorderLayout());
        GridLayout personDetailLayout = new GridLayout(2, 0);
        personDetailPanel = new JPanel(personDetailLayout);
        personAssignmentPanel = new AddAssignmentPanel(false);
        personInfoPanel = new PersonInfoPanel();
        personenPanel.setBorder(new TitledBorder("  Personen:    "));

        personOverview = new PersonOverview(personInfoPanel, personAssignmentPanel);
        personOverview.setPreferredSize(new Dimension(170, 0));

        personDetailPanel.setBorder(new TitledBorder("  Detail: "));
        personDetailPanel.add(personInfoPanel);
        personDetailPanel.add(personAssignmentPanel);

        personenPanel.add(personOverview, BorderLayout.WEST);
        personenPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(personenPanel);

    }
}
