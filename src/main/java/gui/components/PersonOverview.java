package gui.components;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PersonOverview extends JPanel {
    DefaultListModel<String> personListModel;
    JList<String> personList;
    JScrollPane scrollPanePerson;
    JLabel testLabel;

    public PersonOverview() {
        this.setLayout(new BorderLayout());
        personListModel = new DefaultListModel<String>();
        for (int i = 0; i < 15; i++) {
            personListModel.addElement("Francesco Ryu");
            personListModel.addElement("Max Muster");
            personListModel.addElement("Hans Maier");
        }


        personList = new JList<>(personListModel);
        scrollPanePerson = new JScrollPane(personList);
        scrollPanePerson.setPreferredSize(new Dimension(170, 0));



        this.setPreferredSize(new Dimension(170, 0));
        this.add(scrollPanePerson, BorderLayout.CENTER);
        this.setBorder(new TitledBorder("   Übersicht:  "));
        this.setVisible(true);
    }
}
