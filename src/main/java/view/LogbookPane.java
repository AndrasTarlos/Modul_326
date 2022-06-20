package view;

import fascades.FascadeLogbook;
import utils.Menu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * <h1>Logbook</h1>
 * @author: Francesco Ryu
 * @version: 1.0
 * @date: 18.06.2022
 * <h2>Description</h2>
 * // GUI for Logbook. Generates a panel for the specific tab in the Menu.java
 */

public class LogbookPane extends JPanel {

    DefaultListModel<String> defaultListModel;
    JScrollPane jScrollPane;
    JList jList;
    FascadeLogbook fascadeLogbook;


    public LogbookPane() {
        fascadeLogbook = Menu.fascadeLogbook;

        defaultListModel = fascadeLogbook.getAllEntries();

        jList = new JList(defaultListModel);

        jScrollPane = new JScrollPane(jList);

        this.setLayout(new BorderLayout());
        this.add(jScrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}