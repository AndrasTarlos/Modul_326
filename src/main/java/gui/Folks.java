package gui;

import gui.components.buttons.AddButton;

import javax.swing.*;

public class Folks extends JPanel {
    AddButton addButton;
    public Folks() {
        addButton = new AddButton();
        this.add(addButton);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}
