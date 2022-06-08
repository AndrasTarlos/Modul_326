package gui;

import javax.swing.*;
import java.awt.*;

public class CreateFunction extends JFrame {
    private JButton speichern = new JButton("Speichern");
    private javax.swing.JButton abbrechen = new JButton("Abbrechen");
    private JTextField txt = new JTextField("Text eingeben");
    JLabel label = new JLabel("Abteilung:");
    JLabel label2 = new JLabel("");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    public CreateFunction(){
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel1, BorderLayout.NORTH);
        getContentPane().add(panel2, BorderLayout.SOUTH);

        panel1.setLayout(new GridLayout(1,2));
        panel1.add(label);
        panel1.add(txt);

        panel2.setLayout(new GridLayout(1,3));
        panel2.add(label2);
        panel2.add(abbrechen);
        panel2.add(speichern);

        setSize(300, 150);
        setTitle("Funktion erfassen/bearbeiten");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        CreateFunction gui = new CreateFunction();
        gui.setSize(300, 120);
    }
}
