package view;

import fascades.Fascade;
import view.components.DataInfoPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import utils.Menu;

public class DataPane extends JPanel {
    DataInfoPanel dataInfoPanel;
    JPanel componentsPanel;
    JPanel companyPanel;
    JLabel companylabel;
    JTextField companyTextField;
    Fascade fascade;

    public DataPane() {
        fascade = utils.Menu.fascade;
        companyPanel = new JPanel();
        companyPanel.setLayout(new GridLayout(1, 2));

        companylabel = new JLabel("Firma:");
        companyTextField = new JTextField(fascade.getCompanyName());
        companyTextField.setColumns(15);
        companyPanel.add(companylabel);
        companyPanel.add(companyTextField);

        componentsPanel = new JPanel();
        componentsPanel.setLayout(new BoxLayout(componentsPanel, BoxLayout.Y_AXIS));

        String[] labelNames = {"Abteilung:", "Funktionen:", "Teams:"};

        for (int i = 0; i < 3; i++) {
            dataInfoPanel = new DataInfoPanel(labelNames[i]);
            componentsPanel.add(dataInfoPanel);
            dataInfoPanel.setBorder(new TitledBorder(""));
        }
        this.setLayout(new BorderLayout());
        this.add(companyPanel, BorderLayout.NORTH);
        this.add(componentsPanel, BorderLayout.CENTER);
    }

    public static void hel() {

    }
}
