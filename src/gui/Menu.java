package gui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    JTabbedPane selectTab;
    public Menu() {
        this.setLayout(new BorderLayout());
        this.setTitle("I am looking for");

        selectTab = new JTabbedPane();
        selectTab.addTab("Übersicht", new Overview());
        selectTab.addTab("Zuordnung", new Assignment());
        selectTab.addTab("Person", new Persons());
        selectTab.addTab("Stammdaten", new Data());
        selectTab.addTab("Logbuch", new Logbook());

        this.add(selectTab);

        this.setSize(600, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
