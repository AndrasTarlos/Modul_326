package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Assignment extends JPanel {

    JPanel personListPanel;
    JList personList;
    String[] person = {"jklsg", "gjulgjdlfkgjdfkg", "jgkjslgjskfaghga", "riiririr", "jjgkfgfkg"};

    public Assignment() {
        personListPanel = new JPanel();
        personList = new JList(person);


        personListPanel.add(personList);
        this.add(personListPanel, BorderLayout.WEST);
        this.setVisible(true);
    }
}
