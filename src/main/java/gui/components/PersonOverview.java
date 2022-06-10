package gui.components;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PersonOverview extends JPanel {
    DefaultListModel<String> personListModel;
    JList<String> personList;
    JScrollPane scrollPanePerson;

    public PersonOverview() {
        personListModel = new DefaultListModel<>();
        for (int i = 0; i < 1; i++) {
            personListModel.addElement("Francesco Ryu");
            personListModel.addElement("Max Muster");
            personListModel.addElement("Hans Maier");
        }

        personList = new JList<>(personListModel);
        //scrollPanePerson = new JScrollPane(personList);
        this.add(personList);
        this.setPreferredSize(new Dimension(170, 0));
        this.setBorder(new TitledBorder("   Übersicht:  "));
        this.setVisible(true);
    }
}
