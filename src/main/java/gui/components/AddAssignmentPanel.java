package gui.components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AddAssignmentPanel extends JPanel {

    JPanel labelPanel;
    JPanel selectionPanel;

    JLabel abteilung;
    JLabel funktion;
    JLabel teams;

    JTextField abteilungTextField;

    public AddAssignmentPanel() {
        this.setBorder(new MatteBorder(2, 0, 0, 0, Color.BLACK));
        this.setLayout(new BorderLayout());

        labelPanel = new JPanel();
        selectionPanel = new JPanel();

        labelPanel.setLayout(new BorderLayout());
        selectionPanel.setLayout(new BorderLayout());

        abteilung = new JLabel("Abteilung:  ");
        funktion = new JLabel("Funktion:    ");
        teams = new JLabel("Teams:  ");

        Border borderAbteilung = abteilung.getBorder();
        Border marginAbteilung = new EmptyBorder(50, 10, 0, 0);
        abteilung.setBorder(new CompoundBorder(borderAbteilung, marginAbteilung));

        Border borderFunktion = funktion.getBorder();
        Border marginFunktion = new EmptyBorder(0, 10, 0, 0);
        funktion.setBorder(new CompoundBorder(borderFunktion, marginFunktion));

        Border borderTeams = teams.getBorder();
        Border marginTeams = new EmptyBorder(0, 10, 50, 0);
        teams.setBorder(new CompoundBorder(borderTeams, marginTeams));

        abteilungTextField = new JTextField();
        abteilungTextField.setColumns(20);

        Border borderAbteilungTextField = abteilungTextField.getBorder();
        abteilungTextField.setBorder(new CompoundBorder(borderAbteilungTextField, marginAbteilung));

        selectionPanel.add(abteilungTextField);

        labelPanel.add(abteilung, BorderLayout.NORTH);
        labelPanel.add(funktion, BorderLayout.CENTER);
        labelPanel.add(teams, BorderLayout.SOUTH);

        labelPanel.setBorder(new TitledBorder(""));
        labelPanel.setPreferredSize(new Dimension(100, 0));

        selectionPanel.add(abteilungTextField, BorderLayout.NORTH);

        this.add(labelPanel, BorderLayout.WEST);
        this.add(selectionPanel, BorderLayout.CENTER);
    }
}
