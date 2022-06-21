package view.popups;

import com.sun.tools.javac.Main;
import employees.HRPerson;
import fascades.Fascade;
import utils.Menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

/**
 * @author: Francesco Ryu
 * @Version: 1.0
 * @date: 20.06.2022
 */

public class Authorization extends JDialog {
    JPanel labelPanel;
    JPanel interactionPanel;
    JPanel buttonPanel;
    JPanel mainPanel;

    JLabel nameLabel;
    JLabel codeLabel;

    JPasswordField inputCode;
    JComboBox<Object> selectPerson;

    JButton quitButton;
    JButton continueButton;

    private boolean loggedIn = false;

    public Authorization(Menu menu, JTabbedPane tabbedPane) {
        super(menu, true);

        Fascade fascade = Menu.fascade;

        EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);

        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        nameLabel = new JLabel("Name:");
        codeLabel = new JLabel("Code:");
        codeLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        labelPanel.add(nameLabel);
        labelPanel.add(codeLabel);

        interactionPanel = new JPanel();
        interactionPanel.setLayout(new BoxLayout(interactionPanel, BoxLayout.Y_AXIS));
        selectPerson = new JComboBox<>();
        interactionPanel.add(selectPerson);
        addComboBoxContent();
        inputCode = new JPasswordField();

        interactionPanel.add(inputCode);


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        quitButton = new JButton(" Abbrechen ");
        continueButton = new JButton(" Weiter ");
        buttonPanel.add(quitButton, BorderLayout.WEST);
        buttonPanel.add(continueButton, BorderLayout.EAST);
        buttonPanel.setBorder(emptyBorder);

        continueButton.addActionListener(e -> {
            HRPerson p = fascade.getPersonByFullName(Objects.requireNonNull(selectPerson.getSelectedItem()).toString());
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
            }

            if (inputCode.getText().equals(fascade.getPersonsPassword(p))) {
                setVisible(false);
                loggedIn = true;
            }
            if (!inputCode.getText().equals(fascade.getPersonsPassword(p))) {
                System.out.println("failed");
                tabbedPane.setSelectedIndex(0);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
                dispose();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!loggedIn) {
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        this.setTitle("Authentifizierung");
        this.add(labelPanel, BorderLayout.WEST);
        this.add(interactionPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setSize(300, 150);
        this.setLocation(250, 250);
        this.setVisible(true);
    }

    private void addComboBoxContent() {
        for (HRPerson p: Menu.fascade.getAllHRPerson()) {
            selectPerson.addItem(p.getFirstName() + " " + p.getLastName());
        }
    }
}
