package view;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class LogbookPane extends JPanel {

    DefaultListModel<String> defaultListModel;
    JScrollPane jScrollPane;

    public LogbookPane() {
        defaultListModel = new DefaultListModel<>();
        for (int i = 0; i < 50; i++) {
            defaultListModel.addElement("TESTTESTTEST");
        }



        //jScrollPane = new JScrollPane(defaultListModel);

        this.setVisible(true);
    }
}