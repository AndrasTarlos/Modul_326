package gui.components;

import company.Department;
import company.Team;
import employees.HRPerson;
import employees.JobFunction;
import employees.Participation;
import fascades.Fascade;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignmentSettings extends JPanel {

    private final JComboBox<String> departmentComboBox;
    private final JComboBox<String> functionComboBox;
    private final JComboBox<String> teamsComboBox;

    private final Fascade fascade;
    private HRPerson focusedPerson;

    public AssignmentSettings(boolean enableComboBoxes) {
        //this.setBorder(new MatteBorder(2, 0, 0, 0, Color.BLACK));
        this.setLayout(new BorderLayout());
        fascade = utils.Menu.fascade;

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
                if (focusedPerson != null) {
                    fascade.switchPersonDepartmentTo(fascade.getSearchedDepartment((String) departmentComboBox.getSelectedItem()), focusedPerson);
                }
                    //focusedPersondepartmentComboBox.getSelectedItem();
            }
        });

        functionComboBox = new JComboBox<>();
        functionComboBox.setPreferredSize(new Dimension(224, 20));
        functionComboBox.setFocusable(false);
        functionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (focusedPerson != null) {
                    fascade.setJobFunctionOfPerson(focusedPerson, (String) functionComboBox.getSelectedItem());
                }
            }
        });

        teamsComboBox = new JComboBox<>();
        teamsComboBox.setPreferredSize(new Dimension(224, 20));
        teamsComboBox.setFocusable(false);
        teamsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (focusedPerson != null) {
                    fascade.setTeamOfPerson(focusedPerson, (String) teamsComboBox.getSelectedItem());
                    focusedPerson.getParticipation().setTeam(fascade.getSearchedTeam((String) teamsComboBox.getSelectedItem()));
                }
            }
        });

        if (!enableComboBoxes) {
            departmentComboBox.setEnabled(false);
            departmentComboBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    super.paint(g);
                }
            });

            functionComboBox.setEnabled(false);
            functionComboBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    super.paint(g);
                }
            });

            teamsComboBox.setEnabled(false);
            teamsComboBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public void paint(Graphics g) {
                    setForeground(Color.BLACK);
                    super.paint(g);
                }
            });
        }

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
        for (Team t: fascade.getTeams()) {
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
        focusedPerson = person;
        Participation p = person.getParticipation();
        teamsComboBox.setSelectedItem(p.getTeam().getDesignation());
        functionComboBox.setSelectedItem(p.getFunction().getDesignation());
        departmentComboBox.setSelectedItem(person.getDepartmentName());
    }
}
