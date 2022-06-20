package view.popups;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author: Francesco Ryu
 * @Version: 1.0
 * @date: 20.06.2022
 */

public class Authorization extends JDialog {
    JPanel namePanel;
    JPanel codePanel;
    JPanel buttonPanel;
    JPanel mainPanel;

    JLabel nameLabel;
    JLabel codeLabel;

    JTextField inputCode;

    JComboBox selectPerson;

    JButton quitButton;
    JButton continueButton;

    public Authorization() {

        namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        nameLabel = new JLabel("Name:");
        selectPerson = new JComboBox();
        selectPerson.setPreferredSize(new Dimension(200, 19));
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(selectPerson, BorderLayout.EAST);

        mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(namePanel, BorderLayout.NORTH);
        mainPanel.setBorder(new LineBorder(Color.BLACK));
        this.add(mainPanel);
        this.setResizable(false);
        this.setSize(350, 250);


    }
}
