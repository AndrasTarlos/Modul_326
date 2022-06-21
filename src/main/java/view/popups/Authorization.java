package view.popups;

import employees.HRPerson;
import fascades.Fascade;
import utils.Menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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

    public Authorization() {
        Fascade fascade = new Fascade();
        HRPerson p;

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

        p = new HRPerson();

        if (inputCode.getText().equals(Menu.fascade.getPersonByFullName(Objects.requireNonNull(selectPerson.getSelectedItem()).toString()))) {
            continueButton.addActionListener(e -> continueButton.setEnabled(true));
        }

        interactionPanel.add(inputCode);


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        quitButton = new JButton(" Abbrechen ");
        continueButton = new JButton(" Weiter ");
        buttonPanel.add(quitButton, BorderLayout.WEST);
        buttonPanel.add(continueButton, BorderLayout.EAST);
        buttonPanel.setBorder(emptyBorder);

        continueButton.setEnabled(false);

        this.setTitle("Authentifizierung");
        this.add(labelPanel, BorderLayout.WEST);
        this.add(interactionPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setSize(300, 150);
        this.setLocation(250, 250);
    }

    private void addComboBoxContent() {
        for (HRPerson p: Menu.fascade.getAllPerson()) {
            selectPerson.addItem(p.getFirstName() + " " + p.getLastName());
        }
    }
}
