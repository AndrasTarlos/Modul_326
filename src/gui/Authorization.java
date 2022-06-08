package gui;

import javax.swing.*;
import java.awt.*;

public class Authorization extends JFrame {
    String comboBoxListe[] = {"aaa","bbb","ccc"};
    private JComboBox combobox = new JComboBox(comboBoxListe);
    private JTextField txt = new JTextField("eingeben");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton button1 = new JButton("abbrechen");
    JButton button2 = new JButton("weiter");
    JLabel platzhalter = new JLabel();
    JLabel name = new JLabel("name");
    JLabel code = new JLabel("code");

    private Authorization(){
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel1, BorderLayout.NORTH);
        getContentPane().add(panel2, BorderLayout.SOUTH);

        panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new GridLayout(1,4));

        panel1.add(name);
        panel1.add(combobox);
        panel1.add(code);
        panel1.add(txt);

        panel2.add(platzhalter);
        panel2.add(button1);
        panel2.add(button2);

        setTitle("Authorization");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        Authorization gui = new Authorization();
        gui.setSize(300, 170);
    }

}
