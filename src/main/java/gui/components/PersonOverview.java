package gui.components;

import employees.HRPerson;
import employees.Person;
import utils.Fascade;
import utils.Menu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class PersonOverview extends JPanel {
    DefaultListModel<String> personListModel;
    List<Person> personList;
    JList<String> jList;
    JScrollPane scrollPanePerson;
    JLabel testLabel;
    Fascade fascade;

    public PersonOverview() {
        this.setLayout(new BorderLayout());
        personList = new ArrayList<>();

        fascade = Menu.fascade;
        personList = fascade.getAllPerson();

        personListModel = new DefaultListModel<>();
        jList = new JList<>(personListModel);

        for (int i = 0; i < personList.size(); i++) {
            personListModel.add(i,personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
        }

        scrollPanePerson = new JScrollPane(jList);

        this.setPreferredSize(new Dimension(170, 0));
        this.add(scrollPanePerson);
        this.setBorder(new TitledBorder("   Übersicht:  "));
        this.setVisible(true);
        }
    }