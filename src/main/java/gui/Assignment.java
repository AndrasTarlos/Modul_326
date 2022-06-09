package gui;

import javax.swing.*;
import java.awt.*;

/**
 * author: Francesco Ryu
 */

public class Assignment extends JPanel {

    JPanel personEditPanel;
    JPanel personListPanel;
    JPanel personOverviewPanel;

    DefaultListModel personListModel;
    JList personList;

    JLabel overviewLabel;
    JLabel personEditLabel;

    public Assignment() {
        this.setLayout(new BorderLayout());

        personListPanel = new JPanel();
        personEditPanel = new JPanel();
        personOverviewPanel = new JPanel();

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

        personEditPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        personEditPanel.add(personOverviewPanel, BorderLayout.WEST);
        this.add(personEditPanel);
        this.add(personEditLabel, BorderLayout.PAGE_START);
        this.setVisible(true);
    }
}
