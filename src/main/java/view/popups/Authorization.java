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
 * @author: Francesco Ryu/Andras Tarlos
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

    public static HRPerson currentUser;

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
        labelPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        interactionPanel = new JPanel();
        interactionPanel.setLayout(new BoxLayout(interactionPanel, BoxLayout.Y_AXIS));
        selectPerson = new JComboBox<>();
        interactionPanel.add(selectPerson);
        addComboBoxContent();
        inputCode = new JPasswordField();

        interactionPanel.add(inputCode);
        interactionPanel.setBorder(new EmptyBorder(20, 20, 20, 20));


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        quitButton = new JButton(" Abbrechen ");
        continueButton = new JButton(" Weiter ");
        buttonPanel.add(quitButton, BorderLayout.WEST);
        buttonPanel.add(continueButton, BorderLayout.EAST);
        buttonPanel.setBorder(emptyBorder);

        continueButton.addActionListener(e -> {
            currentUser = fascade.getPersonByFullName(Objects.requireNonNull(selectPerson.getSelectedItem()).toString());


            if (inputCode.getText().equals(fascade.getPersonsPassword(currentUser))) {
                setVisible(false);
                loggedIn = true;
                JOptionPane.showMessageDialog(this, "Login erfolgreich");
            }
            if (!inputCode.getText().equals(fascade.getPersonsPassword(currentUser))) {
                System.out.println("failed");
                tabbedPane.setSelectedIndex(0);
                JOptionPane.showMessageDialog(this, "Ungültiger Code und/oder Name");
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
