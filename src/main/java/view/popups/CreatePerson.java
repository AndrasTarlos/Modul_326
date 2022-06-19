package view.popups;

import view.components.PersonInfo;

import javax.swing.*;
import java.awt.*;

public class CreatePerson extends JDialog {
    PersonInfo personInfoPanel;
    JCheckBox HRPersonCheckBox;
    JCheckBox administratorCheckBox;

    JPanel checkBoxButtonPanel;
    JPanel checkBoxPanel;
    public CreatePerson() {
        personInfoPanel = new PersonInfo();

        HRPersonCheckBox = new JCheckBox("HR-Mitarbeiter");

        administratorCheckBox = new JCheckBox("Administrator");

        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        checkBoxPanel.add(HRPersonCheckBox);
        checkBoxPanel.add(administratorCheckBox);

        checkBoxButtonPanel = new JPanel();
        checkBoxButtonPanel.add(checkBoxPanel, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.setTitle("Person erfassen");
        this.add(personInfoPanel, BorderLayout.CENTER);
        this.add(checkBoxButtonPanel, BorderLayout.SOUTH);
        this.setSize(500, 500);
    }

}
