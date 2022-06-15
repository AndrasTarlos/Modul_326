package gui;

import gui.components.AddAssignmentPanel;
import gui.components.PersonInfoPanel;
import gui.components.PersonOverview;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Overview extends JPanel {
    PersonInfoPanel personInfoPanel;
    AddAssignmentPanel personAssignmentPanel;
    AddAssignmentPanel filterAssignmentPanel;
    PersonOverview personOverview;

    JPanel personenPanel;
    JPanel personDetailPanel;
    JPanel southPanel;
    JPanel sortPanel;
    JPanel filterPanel;

    JRadioButton noneSort, AtoZSort, ZToASort;

    ButtonGroup sortBtnGroup;


    public Overview() throws IOException {
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
        sortPanel.setLayout(new BorderLayout());

        sortBtnGroup = new ButtonGroup();

        ActionListener sortActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton aButton = (AbstractButton) actionEvent.getSource();
                personOverview.sortPerson(aButton.getText());
            }
        };

        noneSort = new JRadioButton("Keine");
        noneSort.addActionListener(sortActionListener);
        noneSort.setSelected(true);
        noneSort.setFocusable(false);
        AtoZSort = new JRadioButton("A-Z");
        AtoZSort.addActionListener(sortActionListener);
        AtoZSort.setFocusable(false);
        ZToASort = new JRadioButton("Z-A");
        ZToASort.addActionListener(sortActionListener);
        ZToASort.setFocusable(false);

        sortBtnGroup.add(noneSort);
        sortBtnGroup.add(AtoZSort);
        sortBtnGroup.add(ZToASort);

        sortPanel.add(noneSort, BorderLayout.NORTH);
        sortPanel.add(AtoZSort, BorderLayout.CENTER);
        sortPanel.add(ZToASort, BorderLayout.SOUTH);

        filterPanel = new JPanel();
        filterPanel.setBorder(new TitledBorder("Filter:"));
        filterPanel.setLayout(new BorderLayout());

        JLabel department = new JLabel("Abteilung:");
        department.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel function = new JLabel("Funktion:");
        function.setBorder(new EmptyBorder(5, 0, 0, 0));

        JLabel teams = new JLabel("Teams:");
        teams.setBorder(new EmptyBorder(5, 0, 0, 0));

        filterAssignmentPanel = new AddAssignmentPanel(true);

        filterPanel.add(filterAssignmentPanel);

        southPanel.add(sortPanel, BorderLayout.WEST);
        southPanel.add(filterPanel, BorderLayout.CENTER);

        personOverview = new PersonOverview(personInfoPanel, personAssignmentPanel, true);
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
