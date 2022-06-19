package view;

import fascades.FascadeLogbook;
import utils.Menu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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