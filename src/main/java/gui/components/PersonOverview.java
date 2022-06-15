package gui.components;

import company.Team;
import employees.HRPerson;
import employees.Person;
import utils.Fascade;
import utils.Menu;
import utils.ReadWriteJSON;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

/**
 * @Author: Francesco Ryu/Andras Tarlos
 * @Date: 15.06.2022
 * @Version: 15.1
 */

public class PersonOverview extends JPanel {
    PersonInfoPanel personInfoPanel;
    AddAssignmentPanel addAssignmentPanel;
    DefaultListModel<String> personListModel;
    List<HRPerson> personList;
    JScrollPane scrollPanePerson;
    Fascade fascade;
    JPanel searchBar;
    JTextField searchBarTextField;

    private static URI imgPath;

    static {
        try {
            imgPath = Objects.requireNonNull(ReadWriteJSON.class.getResource("../IMAGES/lensImage.png")).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonOverview(PersonInfoPanel personInfoPanel, AddAssignmentPanel addAssignmentPanel, boolean setVisibleSearchBar) throws IOException {
        this.setLayout(new BorderLayout());
        personList = new ArrayList<>();
        fascade = Menu.fascade;
        personList = fascade.getAllPerson();
        personListModel = new DefaultListModel<>();
        setPersonInfoPanel(personInfoPanel);
        setAddAssignmentPanel(addAssignmentPanel);

        searchBarTextField = new JTextField();
        searchBarTextField.setColumns(15);

        ImageIcon lensImage = new ImageIcon(Paths.get(imgPath).toString());
        JLabel imgLabel = new JLabel(lensImage);
        JButton imgButton = new JButton();
        imgButton.setLayout(new BorderLayout());
        imgButton.add(imgLabel, BorderLayout.WEST);
        imgButton.setBorder(null);
        imgButton.setBorderPainted(false);
        imgButton.setBackground(new Color(246, 245, 245));
        imgButton.setFocusable(false);

        JPanel buttonPanelLens = new JPanel();
        buttonPanelLens.setLayout(new GridLayout(0, 5));
        buttonPanelLens.setBackground(new Color(246, 245, 245));
        buttonPanelLens.add(imgButton);

        searchBar = new JPanel();
        searchBar.setLayout(new GridLayout(2, 1));
        searchBar.setPreferredSize(new Dimension(0, 45));
        searchBar.add(buttonPanelLens);
        searchBar.add(searchBarTextField);


        addButtons();

        this.setPreferredSize(new Dimension(170, 0));
        this.add(scrollPanePerson);
        this.add(searchBar, BorderLayout.SOUTH);
        this.setBorder(new TitledBorder("   Übersicht:  "));
        this.setVisible(true);

        if (!setVisibleSearchBar) {
            searchBar.setVisible(false);
        }
    }

    public void addButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < personList.size(); i++) {
            JButton button = new JButton(personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
            button.setMinimumSize(new Dimension(170, 25));
            button.setMaximumSize(new Dimension(170, 25));
            button.setBorder(null);
            button.setBorderPainted(false);
            button.setBackground(new Color(246, 245, 245));
            button.setFocusable(false);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updatePanels(fascade.getPersonByFullName(e.getActionCommand()));
                }
            });
            panel.add(button);
        }

        scrollPanePerson = new JScrollPane(panel);
    }

    public void setPersonInfoPanel(PersonInfoPanel personInfoPanel) {
        this.personInfoPanel = personInfoPanel;
    }

    public void setAddAssignmentPanel(AddAssignmentPanel addAssignmentPanel) {
        this.addAssignmentPanel = addAssignmentPanel;
    }

    public void updatePanels(HRPerson person) {
        personInfoPanel.update(person);
        addAssignmentPanel.updateComboBox(person);
    }
}
