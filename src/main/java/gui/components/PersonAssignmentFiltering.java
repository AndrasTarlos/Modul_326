package gui.components;

import company.Department;
import company.Team;
import employees.HRPerson;
import employees.JobFunction;
import fascades.Fascade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
/**
 * <h1>PersonAssignmentFiltering</h1>
 * @author: Andras Tarlos
 * @version: 1.0
 * @date: 18.06.2022
 * <h2>Description</h2>
 * This filtering panel makes the searching in the person list easy. You just have
 * to select the corresponding filter settings and see the results.
 */
public class PersonAssignmentFiltering extends JPanel {
    private final JComboBox<String> departmentComboBox;
    private final JComboBox<String> functionComboBox;
    private final JComboBox<String> teamsComboBox;

    private PersonOverview personOverview;

    private final Fascade fascade;

    public PersonAssignmentFiltering(PersonOverview personOverview) {
        //this.setBorder(new MatteBorder(2, 0, 0, 0, Color.BLACK));
        this.setLayout(new BorderLayout());
        fascade = utils.Menu.fascade;
        setPersonOverview(personOverview);

        JPanel labelPanel = new JPanel();
        JPanel selectionPanel = new JPanel();

        JLabel department = new JLabel("Abteilung:");
        department.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel function = new JLabel("Funktion:");
        function.setBorder(new EmptyBorder(5, 0, 0, 0));

        JLabel teams = new JLabel("Teams:");
        teams.setBorder(new EmptyBorder(5, 0, 0, 0));

        departmentComboBox = new JComboBox<>();
        departmentComboBox.setPreferredSize(new Dimension(224, 20));
        departmentComboBox.setFocusable(false);
        departmentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterPerson();
            }
        });

        functionComboBox = new JComboBox<>();
        functionComboBox.setPreferredSize(new Dimension(224, 20));
        functionComboBox.setFocusable(false);
        functionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterPerson();
            }
        });

        teamsComboBox = new JComboBox<>();
        teamsComboBox.setPreferredSize(new Dimension(224, 20));
        teamsComboBox.setFocusable(false);
        teamsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterPerson();
            }
        });

        selectionPanel.add(departmentComboBox);
        selectionPanel.add(functionComboBox);
        selectionPanel.add(teamsComboBox);

        labelPanel.add(department);
        labelPanel.add(function);
        labelPanel.add(teams);

        labelPanel.setPreferredSize(new Dimension(100, 0));

        loadComboBoxData();

        this.add(labelPanel, BorderLayout.WEST);
        this.add(selectionPanel, BorderLayout.CENTER);
    }

    public void loadComboBoxData() {
        teamsComboBox.addItem("Keine");
        for (Team t: fascade.getTeams()) {
            teamsComboBox.addItem(t.getDesignation());
        }
        functionComboBox.addItem("Keine");
        for (JobFunction f: fascade.getJobFunctions()) {
            functionComboBox.addItem(f.getDesignation());
        }
        departmentComboBox.addItem("Keine");
        for (Department d: fascade.getAllDepartment()) {
            departmentComboBox.addItem(d.getName());
        }
    }
    public void filterPerson() {
        String dep = (!Objects.equals((String) departmentComboBox.getSelectedItem(), "Keine")) ? (String) departmentComboBox.getSelectedItem() : null;
        String func = (!Objects.equals((String) functionComboBox.getSelectedItem(), "Keine")) ? (String) functionComboBox.getSelectedItem() : null;
        String teams = (!Objects.equals((String) teamsComboBox.getSelectedItem(), "Keine")) ? (String) teamsComboBox.getSelectedItem() : null;
        personOverview.setPersonList(fascade.getFilteredPerson(dep,teams, func));
        personOverview.updateButtons();
    }

    public void setPersonOverview(PersonOverview p) {
        personOverview = p;
    }
}
