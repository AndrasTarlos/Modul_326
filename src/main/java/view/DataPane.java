package view;

import view.components.DataInfoPanel;

import javax.swing.*;
import java.awt.*;

public class DataPane extends JPanel {
    DataInfoPanel dataInfoPanel;

    public DataPane() {
        for (int i = 0; i < 3; i++) {
            dataInfoPanel = new DataInfoPanel();
            this.add(dataInfoPanel);
        }
    }

}
