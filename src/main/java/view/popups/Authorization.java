package view.popups;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
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

        EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);

        namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        nameLabel = new JLabel("Name:");
        selectPerson = new JComboBox();
        selectPerson.setPreferredSize(new Dimension(200, 19));
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(selectPerson, BorderLayout.EAST);
        namePanel.setBorder(emptyBorder);

        codePanel = new JPanel();
        codePanel.setLayout(new BorderLayout());
        codeLabel = new JLabel("Code:");
        inputCode = new JTextField();
        inputCode.setPreferredSize(new Dimension(200, 15));
        codePanel.add(codeLabel, BorderLayout.WEST);
        codePanel.add(inputCode, BorderLayout.EAST);
        codePanel.setBorder(emptyBorder);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        quitButton = new JButton(" Abbrechen ");
        continueButton = new JButton(" Weiter ");
        buttonPanel.add(quitButton, BorderLayout.WEST);
        buttonPanel.add(continueButton, BorderLayout.EAST);
        buttonPanel.setBorder(emptyBorder);

        this.setTitle("Authentifizierung");
        this.add(namePanel, BorderLayout.NORTH);
        this.add(codePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setSize(300, 150);
        this.setLocation(250, 250);


    }
}
