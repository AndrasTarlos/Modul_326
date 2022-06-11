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

    JComboBox<String> funktionComboBox;
    JList selectFunktionList;

    public AddAssignmentPanel() {
        this.setBorder(new MatteBorder(2, 0, 0, 0, Color.BLACK));
        this.setLayout(new BorderLayout());

        labelPanel = new JPanel();
        selectionPanel = new JPanel();

        abteilung = new JLabel("Abteilung:");
        funktion = new JLabel("Funktion:");
        teams = new JLabel("Teams:");

        abteilungTextField = new JTextField();
        abteilungTextField.setColumns(20);

        funktionComboBox = new JComboBox<>();
        funktionComboBox.setPreferredSize(new Dimension(50, 20));

        selectFunktionList = new JList();

        selectionPanel.add(abteilungTextField);
        selectionPanel.add(funktionComboBox);

        labelPanel.add(abteilung);
        labelPanel.add(funktion);
        labelPanel.add(teams);

        labelPanel.setBorder(new TitledBorder(""));
        labelPanel.setPreferredSize(new Dimension(100, 0));

        this.add(labelPanel, BorderLayout.WEST);
        this.add(selectionPanel, BorderLayout.CENTER);
    }
}
