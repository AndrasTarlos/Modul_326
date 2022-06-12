package gui.components;

import company.Department;
import company.Team;
import employees.HRPerson;
import employees.JobFunction;
import employees.Participation;
import employees.Person;
import utils.Fascade;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AddAssignmentPanel extends JPanel {

    JPanel labelPanel;
    JPanel selectionPanel;

    JLabel abteilung;
    JLabel funktion;
    JLabel teams;

    JComboBox<String> departmentComboBox;
    JComboBox<String> functionComboBox;
    JComboBox<String> teamsComboBox;

    Fascade fascade;

    public AddAssignmentPanel() {
        this.setBorder(new MatteBorder(2, 0, 0, 0, Color.BLACK));
        this.setLayout(new BorderLayout());
        fascade = utils.Menu.fascade;

        labelPanel = new JPanel();
        selectionPanel = new JPanel();

        abteilung = new JLabel("Abteilung:");
        abteilung.setBorder(new EmptyBorder(0, 0, 0, 0));

        funktion = new JLabel("Funktion:");
        funktion.setBorder(new EmptyBorder(5, 0, 0, 0));

        teams = new JLabel("Teams:");
        teams.setBorder(new EmptyBorder(5, 0, 0, 0));

        departmentComboBox = new JComboBox<>();
        departmentComboBox.setPreferredSize(new Dimension(224, 20));

        functionComboBox = new JComboBox<>();
        functionComboBox.setPreferredSize(new Dimension(224, 20));

        teamsComboBox = new JComboBox<>();
        teamsComboBox.setPreferredSize(new Dimension(224, 20));

        selectionPanel.add(departmentComboBox);
        selectionPanel.add(functionComboBox);
        selectionPanel.add(teamsComboBox);

        labelPanel.add(abteilung);
        labelPanel.add(funktion);
        labelPanel.add(teams);

        labelPanel.setPreferredSize(new Dimension(100, 0));

        loadComboBoxData();

        this.add(labelPanel, BorderLayout.WEST);
        this.add(selectionPanel, BorderLayout.CENTER);
    }

    public void loadComboBoxData() {
        for (Team t: fascade.getAllTeams()) {
            teamsComboBox.addItem(t.getDesignation());
        }
        for (JobFunction f: fascade.getJobFunctions()) {
            functionComboBox.addItem(f.getDesignation());
        }
        for (Department d: fascade.getAllDepartment()) {
            departmentComboBox.addItem(d.getName());
        }
    }

    public void updateComboBox(HRPerson person) {
        Participation p = person.getParticipation();
        teamsComboBox.setSelectedItem(p.getTeam().getDesignation());
        functionComboBox.setSelectedItem(p.getFunction().getDesignation());
        departmentComboBox.setSelectedItem(person.getDepartmentName());
    }
}
