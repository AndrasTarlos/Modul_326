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
    public Overview() {
        this.setLayout(new BorderLayout());
        personenPanel = new JPanel(new BorderLayout());
        personInfoPanel = new PersonInfoPanel();
        personenPanel.setBorder(new TitledBorder("  Personen:    "));

        personOverview = new PersonOverview(personInfoPanel, personAssignmentPanel);
        personOverview.setPreferredSize(new Dimension(170, 0));
        personenPanel.add(personOverview, BorderLayout.WEST);
        personenPanel.add(personInfoPanel, BorderLayout.CENTER);
        this.add(personenPanel);

    }
}
