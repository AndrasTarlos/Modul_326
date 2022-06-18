package view.buttons;

import utils.DatahandlerJSON;

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
public class EditButton extends JButton {
    private static URI imgPath;
    static {
        try {
            imgPath = Objects.requireNonNull(DatahandlerJSON.class.getResource("../IMAGES/EditButton.png")).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public EditButton() {
        ImageIcon addButtonPic = new ImageIcon(Paths.get(imgPath).toString());
        JLabel imgLabel = new JLabel(addButtonPic);
        this.setBackground(new Color(246, 245, 245, 255));
        this.add(imgLabel);
    }
}
