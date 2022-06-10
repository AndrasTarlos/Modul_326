package gui;

import javax.swing.*;
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

    JLabel overviewLabel;
    JLabel personEditLabel;

    public Assignment() {
        this.setLayout(new BorderLayout());

        GridLayout personDetailLayout = new GridLayout(2, 0);

        personListPanel = new JPanel();
        personEditPanel = new JPanel();
        personOverviewPanel = new JPanel();
        personDetailPanel = new JPanel();
        personNameImagePanel = new JPanel();
        personAssignmentPanel = new JPanel();

        personEditPanel.setLayout(new BorderLayout());
        personOverviewPanel.setLayout(new BorderLayout());

        overviewLabel = new JLabel("Übersicht:");
        personEditLabel = new JLabel("Personen bearbeiten:");

        personListModel = new DefaultListModel();
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");
        personListModel.addElement("Francesco Ryu");

        personList = new JList(personListModel);

        JScrollPane scrollPanePerson = new JScrollPane(personList);
        scrollPanePerson.setPreferredSize(new Dimension(170, 0));

        personListPanel.add(scrollPanePerson);

        personOverviewPanel.add(overviewLabel, BorderLayout.PAGE_START);
        personOverviewPanel.add(scrollPanePerson, BorderLayout.LINE_START);
        personOverviewPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        personEditPanel.add(personOverviewPanel, BorderLayout.WEST);

        personNameImagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        personAssignmentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        personDetailPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        personDetailPanel.setLayout(personDetailLayout);
        personDetailPanel.add(personNameImagePanel);
        personDetailPanel.add(personAssignmentPanel);

        personEditPanel.add(personDetailPanel, BorderLayout.CENTER);
        this.add(personEditPanel);
        this.add(personEditLabel, BorderLayout.PAGE_START);
        this.setVisible(true);
    }
}
