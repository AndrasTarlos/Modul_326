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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PersonOverview extends JPanel {
    DefaultListModel<String> personListModel;
    List<String> personList;
    JScrollPane scrollPanePerson;
    JLabel testLabel;

    public PersonOverview() {
        this.setLayout(new BorderLayout());
        personListModel = new DefaultListModel<String>();

        scrollPanePerson = new JScrollPane();


        this.setPreferredSize(new Dimension(170, 0));
        this.add(scrollPanePerson, BorderLayout.CENTER);
        this.setBorder(new TitledBorder("   Übersicht:  "));
        this.setVisible(true);
    }
}
