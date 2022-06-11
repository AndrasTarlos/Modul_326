package gui.components;

import employees.Person;
import utils.Fascade;
import utils.Menu;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class PersonOverview extends JPanel {
    PersonInfoPanel personInfoPanel;
    DefaultListModel<String> personListModel;
    List<Person> personList;
    JScrollPane scrollPanePerson;
    Fascade fascade;

    public PersonOverview(PersonInfoPanel personInfoPanel) {
        this.setLayout(new BorderLayout());
        personList = new ArrayList<>();
        fascade = Menu.fascade;
        personList = fascade.getAllPerson();
        personListModel = new DefaultListModel<>();
        setPersonInfoPanel(personInfoPanel);

        addButtons();

        this.setPreferredSize(new Dimension(170, 0));
        this.add(scrollPanePerson);
        this.setBorder(new TitledBorder("   Übersicht:  "));
        this.setVisible(true);
    }

    public void addButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < personList.size(); i++) {
            JButton button = new JButton(personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
            button.setMinimumSize(new Dimension(170, 25));
            button.setMaximumSize(new Dimension(170, 25));
            button.setBorder(null);
            button.setBorderPainted(false);
            button.setBackground(new Color(246, 245, 245));
            button.setFocusable(false);

            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setBackground(new Color(178, 176, 176));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setBackground(new Color(246, 245, 245));
                }
            });

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updatePersonInfoPanel(fascade.getPersonByFullName(e.getActionCommand()));
                }
            });
            panel.add(button);
        }
        scrollPanePerson = new JScrollPane(panel);
    }

    public void setPersonInfoPanel(PersonInfoPanel personInfoPanel) {
        this.personInfoPanel = personInfoPanel;
    }

    public void updatePersonInfoPanel(Person person) {
        personInfoPanel.update(person);
    }
}
