package utils;

import company.Company;
import fascades.Fascade;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * <h1>Menu</h1>
 * @author: Francesco Ryu, Andras Tarlos
 * @version: 1.0
 * @date: 08.06.2022
 * <h2>Description</h2>
 * This is the main class of our software. The main method has to started
 * to start the GUI as well to activate the fascades and the model classes.
 */

public class Menu extends JFrame {
    public static Fascade fascade;

    /**
     * The main JFrame is created in this Menu constructor
     * @param fascade to access information from the model classes
     * @throws IOException if an error occurs
     */
    public Menu(Fascade fascade) throws IOException {
        Menu.fascade = fascade;

        this.setLayout(new BorderLayout());
        this.setTitle("I am looking for");

        // Initializing objects
        OverviewPane overviewPane = new OverviewPane();
        AssignmentPane assignmentPane = new AssignmentPane();
        PersonPane personPane = new PersonPane();
        DataPane dataPane = new DataPane();
        LogbookPane logbookPane = new LogbookPane();

        // Menu bar
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

    /**
     * Here starts the execution of the program
     * @param args String args
     * @throws IOException if an error occurs
     */
    public static void main(String[] args) throws IOException {
        DatahandlerJSON datahandlerJSON = new DatahandlerJSON();
        Fascade fascade = datahandlerJSON.readFascadeJSON();
        Company company = datahandlerJSON.readCompanyJSON();
        fascade.setCompany(company);
        new Menu(fascade);
        // TODO wait until the GUI is closed
        datahandlerJSON.writeCompanyJSON(company);
    }
}
