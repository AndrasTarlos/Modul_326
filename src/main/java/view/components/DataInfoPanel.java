package view.components;

import view.buttons.AddButton;
import view.buttons.DeleteButton;
import view.buttons.EditButton;

import javax.swing.*;
import java.awt.*;

public class DataInfoPanel extends JPanel {
    DefaultListModel defaultListModel;
    JList jList;
    JScrollPane jScrollPane;

    JPanel buttonPanel;

    AddButton addButton;
    EditButton editButton;
    DeleteButton deleteButton;

    public DataInfoPanel() {
        this.setLayout(new BorderLayout());

        defaultListModel = new DefaultListModel();
        jList = new JList(defaultListModel);
        jScrollPane = new JScrollPane(jList);

        addButton = new AddButton();
        editButton = new EditButton();
        deleteButton = new DeleteButton();

        buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
