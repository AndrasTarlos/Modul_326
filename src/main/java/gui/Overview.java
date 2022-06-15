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
    PersonOverview personOverview;

    JPanel personenPanel;
    JPanel personDetailPanel;
    JPanel southPanel;
    JPanel sortPanel;
    JPanel filterPanel;

    JRadioButton noneSort, AtoZSort, ZToASort;

    ButtonGroup sortBtnGroup;


    public Overview() {
        GridLayout personDetailLayout = new GridLayout(2, 0);
        this.setLayout(new BorderLayout());

        personenPanel = new JPanel(new BorderLayout());
        personDetailPanel = new JPanel(personDetailLayout);
        personAssignmentPanel = new AddAssignmentPanel(false);

        personInfoPanel = new PersonInfoPanel();
        personenPanel.setBorder(new TitledBorder("Personen:    "));

        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(0, 120));

        sortPanel = new JPanel();
        sortPanel.setBorder(new TitledBorder("Sortierung:"));
        sortPanel.setPreferredSize(new Dimension(175, 0));
        sortPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        sortBtnGroup = new ButtonGroup();

        noneSort = new JRadioButton("Keine");
        noneSort.setSelected(true);

        AtoZSort = new JRadioButton("A-Z");
        ZToASort = new JRadioButton("Z-A");

        sortBtnGroup.add(noneSort);
        sortBtnGroup.add(AtoZSort);
        sortBtnGroup.add(ZToASort);

        sortPanel.add(noneSort);
        sortPanel.add(AtoZSort);
        sortPanel.add(ZToASort);

        filterPanel = new JPanel();
        filterPanel.setBorder(new TitledBorder("Filter:"));

        southPanel.add(sortPanel, BorderLayout.WEST);
        southPanel.add(filterPanel, BorderLayout.CENTER);

        personOverview = new PersonOverview(personInfoPanel, personAssignmentPanel);
        personOverview.setPreferredSize(new Dimension(170, 0));

        personDetailPanel.setBorder(new TitledBorder("  Detail: "));
        personDetailPanel.add(personInfoPanel);
        personDetailPanel.add(personAssignmentPanel);

        personenPanel.add(personOverview, BorderLayout.WEST);
        personenPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(personenPanel);

    }
}
