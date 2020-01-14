package ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;

/**
 * Hilight + Timline class
 * @author Sova
 */
public class Hiline extends JTable{
    Dimension standartSize = new Dimension(400, 120);
    
    public Hiline() {
        setPreferredSize(standartSize);
        setForeground(Color.red);
    }
    
}
