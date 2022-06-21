package view.popups;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdesktop.swingx.prompt.PromptSupport;

/**
 * @author: Julian Janik
 * @Version: 9.0
 * @date: 20.06.2022
 */

public class CreateFunction extends JFrame {
    JLabel label2 = new JLabel("");

    public CreateFunction(String title){
        getContentPane().setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        getContentPane().add(panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        getContentPane().add(panel2, BorderLayout.SOUTH);

        panel1.setLayout(new GridLayout(1,2));
        panel1.add(new JLabel(title));


        JTextField txt = new JTextField();
        PromptSupport.setPrompt("Text eingeben", txt);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, txt);
        panel1.add(txt);

        JButton abbrechen = new JButton("Abbrechen");
        abbrechen.addActionListener(e -> this.setVisible(false));

        panel2.setLayout(new GridLayout(1,3));
        panel2.add(label2);
        panel2.add(abbrechen);
        JButton speichern = new JButton("Speichern");
        speichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel2.add(speichern);

        setSize(350, 150);
        setTitle(title + " erfassen");
        setVisible(true);
        setResizable(false);
    }
}
