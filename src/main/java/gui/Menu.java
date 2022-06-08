package gui;


import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    JTabbedPane selectTab;
    public Menu() {
        this.setLayout(new BorderLayout());
        this.setTitle("I am looking for");


        Overview overview = new Overview();
        Assignment assignment = new Assignment();
        Person person = new Person();
        Data data = new Data();
        Logbook logbook = new Logbook();

        selectTab = new JTabbedPane();
        selectTab.addTab("Übersicht", overview);
        selectTab.addTab("Zuordnung", assignment);
        selectTab.addTab("Person", person);
        selectTab.addTab("Stammdaten", data);
        selectTab.addTab("Logbuch", logbook);

        this.add(selectTab);

        this.setSize(600, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
