package ui;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sova    
 */
public class Player extends JPanel {
    Dimension standartSize = new Dimension(600, 220);

    public Player() {
        setPreferredSize(standartSize);
        add(new JLabel(new ImageIcon("sys/placeholder.jpg")));
    }
    
}
