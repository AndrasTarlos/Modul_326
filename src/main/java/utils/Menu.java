package utils;

import company.Company;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Author: Francesco Ryu
 * Date: 08.06.2022
 *
 */

public class Menu extends JFrame {
    public static Fascade fascade;

    public Menu(Fascade fascade) throws IOException {
        Menu.fascade = fascade;

        this.setLayout(new BorderLayout());
        this.setTitle("I am looking for");
        Overview overview = new Overview();
        Assignment assignment = new Assignment();
        Folks folks = new Folks();
        Data data = new Data();
        Logbook logbook = new Logbook();

        JTabbedPane selectTab = new JTabbedPane();
        selectTab.addTab("Übersicht", overview);
        selectTab.addTab("Zuordnung", assignment);
        selectTab.addTab("Personen", folks);
        selectTab.addTab("Stammdaten", data);
        selectTab.addTab("Logbuch", logbook);

        this.add(selectTab);

        this.setSize(600, 700);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        ReadWriteJSON readWriteJSON = new ReadWriteJSON();
        Fascade fascade = readWriteJSON.readFascadeJSON();
        Company company = readWriteJSON.readCompanyJSON();
        fascade.setCompany(company);
        new Menu(fascade);
    }
}
