package gui;

import javax.swing.*;
import java.awt.*;

public class Assignment extends JPanel {

    JPanel personEditPanel;
    JPanel personListPanel;

    DefaultListModel personListModel;
    JList personList;
    JLabel overviewLabel;

    public Assignment() {
        this.setLayout(new BorderLayout());
        personEditPanel = new JPanel();
        personEditPanel.setLayout(new BorderLayout());
        personEditPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        personListPanel = new JPanel();
        personListPanel.setLayout(new BorderLayout());

        overviewLabel = new JLabel("Übersicht:");

        personListModel = new DefaultListModel();
        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");

        personList = new JList(personListModel);
        personEditPanel.add(personListPanel, BorderLayout.CENTER);
        personEditPanel.add(overviewLabel, BorderLayout.NORTH);
        personListPanel.add(personList);

        this.add(personEditPanel, BorderLayout.WEST);
        this.setVisible(true);
    }
}
