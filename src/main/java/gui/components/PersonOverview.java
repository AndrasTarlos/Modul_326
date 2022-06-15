package gui.components;

import employees.HRPerson;
import exception.UnknownSortingTypeException;
import org.jetbrains.annotations.NotNull;
import utils.Fascade;
import utils.Menu;
import utils.ReadWriteJSON;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class PersonOverview extends JPanel {
    PersonInfoPanel personInfoPanel;
    AddAssignmentPanel addAssignmentPanel;
    DefaultListModel<String> personListModel;
    List<HRPerson> personList;
    JScrollPane scrollPanePerson;

    JPanel contentPanel;
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

        searchBar = new JPanel();
        searchBar.setBorder(new TitledBorder(""));
        searchBar.setLayout(new GridLayout(2, 1));
        searchBar.setPreferredSize(new Dimension(0, 45));
        searchBar.add(imgButton);
        searchBar.add(searchBarTextField);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        scrollPanePerson = new JScrollPane(contentPanel);

        addButtonsToContentPanel();

        this.setPreferredSize(new Dimension(170, 0));
        this.add(scrollPanePerson);
        this.add(searchBar, BorderLayout.SOUTH);
        this.setBorder(new TitledBorder("   Übersicht:  "));
        this.setVisible(true);

        if (!setVisibleSearchBar) {
            searchBar.setVisible(false);
        }
    }

    public void addButtonsToContentPanel() {
        for (int i = 0; i < personList.size(); i++) {
            JButton button = new JButton(personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
            button.setMinimumSize(new Dimension(170, 25));
            button.setMaximumSize(new Dimension(170, 25));
            button.setBorder(null);
            button.setBorderPainted(false);
            button.setBackground(new Color(246, 245, 245, 226));
            button.setFocusable(false);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updatePanels(fascade.getPersonByFullName(e.getActionCommand()));
                }
            });
            contentPanel.add(button);
        }
        contentPanel.revalidate();
    }

    public void removeContentPanelButtons() {
        contentPanel.removeAll();
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

    public void sortPerson(@NotNull String type) {
        try {
            switch (type) {
                case "Keine":
                    personList = Menu.fascade.getAllPerson();
                    removeContentPanelButtons();
                    addButtonsToContentPanel();
                    break;
                case "A-Z":
                    personList = Menu.fascade.getAllPersonSortedAZ();
                    removeContentPanelButtons();
                    addButtonsToContentPanel();
                    break;
                case "Z-A":
                    personList = Menu.fascade.getAllPersonSortedZA();
                    removeContentPanelButtons();
                    addButtonsToContentPanel();
                    this.repaint();
                    break;
                default:
                    throw new UnknownSortingTypeException();
            }

        } catch (UnknownSortingTypeException e) {
            throw new RuntimeException(e);
        }
    }
}
