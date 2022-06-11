package gui.components;

import company.Department;
import company.Team;
import employees.JobFunction;
import employees.Person;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;

public class AddAssignmentPanel extends JPanel {

    JPanel labelPanel;
    JPanel selectionPanel;

    JLabel abteilung;
    JLabel funktion;
    JLabel teams;

    JComboBox<String> abteilungComboBox;
    JComboBox<String> funktionComboBox;
    JComboBox<String> teamsComboBox;

    String[] testData = {"asdgbvbbn", "wertrtztjj", "öjklhjh"};

    public AddAssignmentPanel() {
        this.setBorder(new MatteBorder(2, 0, 0, 0, Color.BLACK));
        this.setLayout(new BorderLayout());

        labelPanel = new JPanel();
        selectionPanel = new JPanel();

        abteilung = new JLabel("Abteilung:");
        abteilung.setBorder(new EmptyBorder(0, 0, 0, 0));

        funktion = new JLabel("Funktion:");
        funktion.setBorder(new EmptyBorder(5, 0, 0, 0));

        teams = new JLabel("Teams:");
        teams.setBorder(new EmptyBorder(5, 0, 0, 0));

        abteilungComboBox = new JComboBox<>();
        abteilungComboBox.setPreferredSize(new Dimension(224, 20));

        funktionComboBox = new JComboBox<>();
        funktionComboBox.setPreferredSize(new Dimension(224, 20));

        teamsComboBox = new JComboBox<>();
        teamsComboBox.setPreferredSize(new Dimension(224, 20));

        selectionPanel.add(abteilungComboBox);
        selectionPanel.add(funktionComboBox);
        selectionPanel.add(teamsComboBox);

        labelPanel.add(abteilung);
        labelPanel.add(funktion);
        labelPanel.add(teams);

        labelPanel.setPreferredSize(new Dimension(100, 0));

        this.add(labelPanel, BorderLayout.WEST);
        this.add(selectionPanel, BorderLayout.CENTER);
    }

    public void updateComboBox(ArrayList<Team> teams, ArrayList<JobFunction> jobFunctions, ArrayList<Department> departments, Person person) {
        for (Team t: teams) {
            teamsComboBox.addItem(t.getDesignation());
        }
        for (JobFunction f: jobFunctions) {
            funktionComboBox.addItem(f.getDesignation());
        }
        for (Department d: departments) {
            abteilungComboBox.addItem(d.getName());
        }
    }
}
