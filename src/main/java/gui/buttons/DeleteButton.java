package gui.buttons;

import utils.ReadWriteJSON;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @Author: Francesco Ryu
 * @Date: 15.06.2022
 * @Version: 1.0
 */
public class DeleteButton extends JButton{
    private static URI imgPath;

    static {
        try {
            imgPath = Objects.requireNonNull(ReadWriteJSON.class.getResource("../IMAGES/DeleteButton.png")).toURI();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public DeleteButton() {
        ImageIcon addButtonPic = new ImageIcon(Paths.get(imgPath).toString());
        JLabel imgLabel = new JLabel(addButtonPic);
        this.setBackground(new Color(246, 245, 245, 255));
        this.add(imgLabel);
    }
}
