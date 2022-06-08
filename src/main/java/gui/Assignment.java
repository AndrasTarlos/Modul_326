package gui;

import javax.swing.*;
import java.awt.*;

public class Assignment extends JPanel {

    JPanel personListPanel;
    JList personList;


    public Assignment() {
        personListPanel = new JPanel();
        personList = new JList();

        this.add(personListPanel, BorderLayout.WEST);
        this.setVisible(true);
    }
}
