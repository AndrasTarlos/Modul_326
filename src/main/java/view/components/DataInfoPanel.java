package view.components;

import company.Department;
import company.Team;
import employees.JobFunction;
import fascades.Fascade;
import utils.Menu;
import view.buttons.AddButton;
import view.buttons.DeleteButton;
import view.buttons.EditButton;
import view.popups.CreateFunction;
import view.popups.EditFunction;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>DataInfoPanel</h1>
 * @author: Francesco Ryu / Andras Tarlos
 * @version: 9.0
 * @date: 21.06.2022
 * <h2>Description</h2>
 *
 */

public class DataInfoPanel extends JPanel {
    JPanel contentPanel;
    JScrollPane jScrollPane;
    JPanel buttonPanel;
    JPanel buttonScrollPanePanel;
    JLabel label;
    Object[] itemList;
    String labelName;
    AddButton addButton;
    EditButton editButton;
    DeleteButton deleteButton;
    Fascade fascade;
    CreateFunction createFunction;
    EditFunction editFunction;
    String focusedItem;

    public DataInfoPanel(String labelName) {
        fascade = utils.Menu.fascade;
        label = new JLabel(labelName);
        setLabelName(labelName);

        addButton = new AddButton();
        editButton = new EditButton();
        deleteButton = new DeleteButton();

        switch (labelName) {
            case "Abteilung:" -> {
                addButton.addActionListener(e -> {
                    createFunction = new CreateFunction("Abteilung", this);
                });
                editButton.addActionListener(e -> {
                    if (focusedItem != null)
                        editFunction = new EditFunction("Abteilung", focusedItem, this);
                    updateButtons();
                });
                deleteButton.addActionListener(e -> {
                    if (focusedItem != null) {
                        Menu.fascade.deleteDepartment(focusedItem);
                        focusedItem = null;
                    }
                    updateButtons();
                });
            }
            case "Funktionen:" -> {
                addButton.addActionListener(e -> {
                    createFunction = new CreateFunction("Funktion", this);
                });
                editButton.addActionListener(e -> {
                    if (focusedItem != null)
                        editFunction = new EditFunction("Funktion", focusedItem, this);
                });
                deleteButton.addActionListener(e -> {
                    if (focusedItem != null) {
                        Menu.fascade.deleteJobFunction(focusedItem);
                        focusedItem = null;
                    }
                    updateButtons();
                });
            }
            case "Teams:" -> {
                addButton.addActionListener(e -> {
                    createFunction = new CreateFunction("Team", this);
                });
                editButton.addActionListener(e -> {
                    if (focusedItem != null)
                        editFunction = new EditFunction("Team", focusedItem, this);
                });
                deleteButton.addActionListener(e -> {
                    if (focusedItem != null) {
                        Menu.fascade.deleteTeam(focusedItem);
                        focusedItem = null;
                    }
                    updateButtons();
                });
            }
        }

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        jScrollPane = new JScrollPane(contentPanel);
        jScrollPane.setPreferredSize(new Dimension(200, 150));

        FlowLayout flowLayout = new FlowLayout();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(flowLayout);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        addButtons();

        buttonScrollPanePanel = new JPanel();
        buttonScrollPanePanel.add(jScrollPane);
        buttonScrollPanePanel.add(buttonPanel);

        this.setLayout(new GridLayout(1, 2));
        this.add(label);
        this.add(buttonScrollPanePanel);
    }

    public void addButtons() {
        switch (labelName) {
            case "Abteilung:" -> itemList = fascade.getAllDepartment().toArray();
            case "Funktionen:" -> itemList = fascade.getJobFunctions().toArray();
            case "Teams:" -> itemList = fascade.getTeams().toArray();
        }

        for (int i = 0; i < itemList.length; i++) {
            String name = null;
            switch (labelName) {
                case "Abteilung:" -> name = ((Department) itemList[i]).getName();
                case "Funktionen:" -> name = ((JobFunction) itemList[i]).getDesignation();
                case "Teams:" -> name = ((Team) itemList[i]).getDesignation();
            }

            JButton button = new JButton(name);
            button.setMaximumSize(new Dimension(180, 30));
            button.setPreferredSize(new Dimension(180, 30));

            button.setBorder(null);
            button.setBorderPainted(false);
            button.setBackground(new Color(246, 245, 245, 255));
            button.setFocusable(false);

            button.addActionListener(e -> {
                focusedItem = e.getActionCommand();
            });
            contentPanel.add(button);
        }
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void updateButtons() {
        contentPanel.removeAll();
        addButtons();
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
