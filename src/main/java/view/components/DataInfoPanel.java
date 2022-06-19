package view.components;

import view.buttons.AddButton;
import view.buttons.DeleteButton;
import view.buttons.EditButton;
import view.popups.CreateFunction;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataInfoPanel extends JPanel {
    DefaultListModel defaultListModel;
    JList jList;
    JScrollPane jScrollPane;

    JPanel buttonPanel;
    JPanel buttonScrollPanePanel;

    JLabel label;

    AddButton addButton;
    EditButton editButton;
    DeleteButton deleteButton;

    CreateFunction createFunction;

    public DataInfoPanel(String labelName) {

        label = new JLabel(labelName);

        defaultListModel = new DefaultListModel();
        jList = new JList(defaultListModel);
        jScrollPane = new JScrollPane(jList);

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

        buttonScrollPanePanel = new JPanel(new BorderLayout());
        buttonScrollPanePanel.add(jScrollPane, BorderLayout.CENTER);
        buttonScrollPanePanel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(label);
        this.add(buttonScrollPanePanel);

    }
}
