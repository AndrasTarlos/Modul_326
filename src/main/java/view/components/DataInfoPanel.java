package view.components;

import company.Department;
import company.Team;
import employees.JobFunction;
import fascades.Fascade;
import view.buttons.AddButton;
import view.buttons.DeleteButton;
import view.buttons.EditButton;
import view.popups.CreateFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataInfoPanel extends JPanel {
    DefaultListModel<String> defaultListModel;
    JList jList;
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

    public DataInfoPanel(String labelName) {
        fascade = utils.Menu.fascade;
        label = new JLabel(labelName);
        setLabelName(labelName);

        switch (labelName) {
            case "Abteilung:" -> itemList = fascade.getAllDepartment().toArray();
            case "Funktionen:" -> itemList = fascade.getJobFunctions().toArray();
            case "Teams:" -> itemList = fascade.getTeams().toArray();
        }

        contentPanel = new JPanel();

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));               //new BoxLayout(contentPanel, BoxLayout.Y_AXIS)

        jScrollPane = new JScrollPane(contentPanel);
        jScrollPane.setPreferredSize(new Dimension(200, 150));

        addButton = new AddButton();
        editButton = new EditButton();
        deleteButton = new DeleteButton();

        createFunction = new CreateFunction();
        createFunction.setVisible(false);

        addButton.addActionListener(e -> createFunction.setVisible(true));
        editButton.addActionListener(e -> createFunction.setVisible(true));

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
        for (int i = 0; i < itemList.length; i++) {
            String name = null;
            switch (labelName) {
                case "Abteilung:" -> name = ((Department) itemList[i]).getName();
                case "Funktionen:" -> name = ((JobFunction) itemList[i]).getDesignation();
                case "Teams:" -> name = ((Team) itemList[i]).getDesignation();
            }
            JButton button = new JButton(name);
            button.setMinimumSize(new Dimension(170, 25));
            button.setMaximumSize(new Dimension(170, 25));
            button.setBorder(null);
            button.setBorderPainted(false);
            button.setBackground(new Color(246, 245, 245, 255));
            button.setFocusable(false);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            contentPanel.add(button);
        }
        jScrollPane.revalidate();
        jScrollPane.repaint();
    }



    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

}
