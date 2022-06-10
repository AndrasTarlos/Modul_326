package gui.components;
import javax.swing.*;
public class PersonNameImagePanel extends JPanel {
    JTextField nameInputTextField;
    JLabel personNameLabel;

    public PersonNameImagePanel() {
        personNameLabel = new JLabel("  Name: ");

        nameInputTextField = new JTextField();
        nameInputTextField.setColumns(25);

        /*BufferedImage myPicture = ImageIO.read(new File("img.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);*/

        this.add(personNameLabel);
        this.add(nameInputTextField);
    }
}
