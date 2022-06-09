package gui;

import employees.Person;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Assignment extends JPanel {

    JPanel personListPanel;
    DefaultListModel personListModel;
    JList personList;

    public Assignment() {
        this.setLayout(new BorderLayout());
        personListPanel = new JPanel();
        personListModel = new DefaultListModel();

        personListModel.addElement("Francesco Ryu");
        personListModel.addElement("Andras Tarlos");
        personListModel.addElement("Julian Janik");

        personList = new JList(personListModel);

        personListPanel.add(personList);

        this.add(personListPanel, BorderLayout.WEST);
        this.setVisible(true);
    }
}
