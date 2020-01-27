package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sova    
 */
public class Player extends JPanel {
    Dimension standartSize = new Dimension(600, 220);
    private BufferedImage placeholder;

    public Player() {
        try {
            setPreferredSize(standartSize);
            placeholder = ImageIO.read(new File("sys/placeholder.jpg"));
        } catch (IOException ex) {
            System.out.println("player is dead, long live the player: "+ex);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(placeholder, 3, 3, getWidth()-7, getHeight()-7, null);
    }
    
}
