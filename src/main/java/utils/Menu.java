package utils;

import company.Company;
import fascades.Fascade;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Author: Francesco Ryu
 * Date: 08.06.2022
 *
 */
// Test exchange
public class Menu extends JFrame {
    public static Fascade fascade;

    public Menu(Fascade fascade) throws IOException {
        Menu.fascade = fascade;

        this.setLayout(new BorderLayout());
        this.setTitle("I am looking for");
        OverviewPane overviewPane = new OverviewPane();
        AssignmentPane assignmentPane = new AssignmentPane();
        PersonPane personPane = new PersonPane();
        DataPane dataPane = new DataPane();
        LogbookPane logbookPane = new LogbookPane();

        JTabbedPane selectTab = new JTabbedPane();
        selectTab.addTab("Übersicht", overviewPane);
        selectTab.addTab("Zuordnung", assignmentPane);
        selectTab.addTab("Person", personPane);
        selectTab.addTab("Stammdaten", dataPane);
        selectTab.addTab("Logbuch", logbookPane);

        this.add(selectTab);

        this.setSize(600, 700);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        DatahandlerJSON datahandlerJSON = new DatahandlerJSON();
        Fascade fascade = datahandlerJSON.readFascadeJSON();
        Company company = datahandlerJSON.readCompanyJSON();
        fascade.setCompany(company);
        new Menu(fascade);
    }
}
