package gui;

import employees.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * author: Francesco Ryu
 * date: 10.06.2022
 */

public class Assignment extends JPanel {

    JPanel personEditPanel;
    JPanel personListPanel;
    JPanel personOverviewPanel;
    JPanel personDetailPanel;
    JPanel personNameImagePanel;
    JPanel personAssignmentPanel;

    DefaultListModel personListModel;
    JList personList;
    JLabel personEditLabel;
    JLabel personNameLabel;

    JTextField nameInputTextField;

    public Assignment() {
        this.setLayout(new BorderLayout());

        personListModel = new DefaultListModel();
        for (int i = 0; i < 15; i++) {
            personListModel.addElement("Francesco Ryu");
            personListModel.addElement("Max Muster");
            personListModel.addElement("Hans Maier");
        }

        personList = new JList(personListModel);

        GridLayout personDetailLayout = new GridLayout(2, 0);

        personListPanel = new JPanel();
        personEditPanel = new JPanel();
        personOverviewPanel = new JPanel();
        personDetailPanel = new JPanel();
        personNameImagePanel = new JPanel();
        personAssignmentPanel = new JPanel();

        personEditPanel.setLayout(new BorderLayout());
        personOverviewPanel.setLayout(new BorderLayout());

        nameInputTextField = new JTextField();

        JScrollPane scrollPanePerson = new JScrollPane(personList);
        scrollPanePerson.setPreferredSize(new Dimension(170, 0));

        personEditLabel = new JLabel("  Personen bearbeiten:");
        personNameLabel = new JLabel("  Name: ");

        personListPanel.add(scrollPanePerson);

        personOverviewPanel.add(scrollPanePerson, BorderLayout.LINE_START);
        personOverviewPanel.setBorder(new TitledBorder("Übersicht:"));

        personEditPanel.add(personOverviewPanel, BorderLayout.WEST);

        personNameImagePanel.setLayout(new GridBagLayout());


        personNameImagePanel.add(personNameLabel);

        personAssignmentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        personDetailPanel.setBorder(new TitledBorder("  Detail: "));
        personDetailPanel.setLayout(personDetailLayout);
        personDetailPanel.add(personNameImagePanel);
        personDetailPanel.add(personAssignmentPanel);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(personEditPanel);
        this.add(personEditLabel, BorderLayout.PAGE_START);
        this.setVisible(true);
    }
}
