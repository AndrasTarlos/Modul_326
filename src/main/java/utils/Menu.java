package utils;

import company.Company;
import fascades.Fascade;
import fascades.FascadeLogbook;
import log.LogBook;
import view.*;
import view.popups.Authorization;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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

    public static FascadeLogbook fascadeLogbook;
    public static DatahandlerJSON datahandlerJSON;

    public static Company company;

    /**
     * The main JFrame is created in this Menu constructor
     */
    public Menu() {
        this.setLayout(new BorderLayout());
        this.setTitle("I am looking for");

        // Initializing objects
        OverviewPane overviewPane = new OverviewPane();
        AssignmentPane assignmentPane = new AssignmentPane();
        PersonPane personPane = new PersonPane();
        DataPane dataPane = new DataPane();
        LogbookPane logbookPane = new LogbookPane();
        Authorization authorization = new Authorization();
        // Menu bar
        JTabbedPane selectTab = new JTabbedPane();
        selectTab.addTab("Übersicht", overviewPane);
        selectTab.addTab("Zuordnung", assignmentPane);
        selectTab.addTab("Person", personPane);
        selectTab.addTab("Stammdaten", dataPane);
        selectTab.addTab("Logbuch", logbookPane);

        selectTab.addChangeListener(e -> {
            if (selectTab.getSelectedIndex() == 1 ||
                    selectTab.getSelectedIndex() == 2 ||
                    selectTab.getSelectedIndex() == 3 ||
                    selectTab.getSelectedIndex() == 4) {

                authorization.setVisible(true);
            }
        });

        authorization.setVisible(false);

        this.add(selectTab);

        this.setSize(600, 700);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(500, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Add window listener
        WindowListener wl = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Save everything in the JSON file when the JFrame is closing
                datahandlerJSON.writeCompanyJSON(company);
            }
        };
        this.addWindowListener(wl);

    }

    /**
     * Here starts the execution of the program
     * @param args String args
     */
    public static void main(String[] args) {
        datahandlerJSON = DatahandlerJSON.getDatahandlerJSONInstance();
        company = datahandlerJSON.readCompanyJSON();

        fascade = datahandlerJSON.readFascadeJSON();
        fascadeLogbook = new FascadeLogbook();
        fascade.setCompany(company);
        new Menu();
    }
}
