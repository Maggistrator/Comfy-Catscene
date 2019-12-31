package experimantal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Sova
 */
public class KindOfWindow {
    JFrame frame = new JFrame("yay");
    Player player = new Player();
    Hiline hiline = new Hiline();
    JPanel modePanel = new JPanel();
    JPanel fileFunctionsPanel = new JPanel();
    
    public KindOfWindow() {   
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());  
        frame.setMinimumSize(new Dimension(640, 480));
       
        buildModeToolbar();
        buildFileFunctionsToolbar();
        
        modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
        fileFunctionsPanel.setLayout(new BoxLayout(fileFunctionsPanel, BoxLayout.Y_AXIS));
        modePanel.setBorder(new LineBorder(Color.black));
        fileFunctionsPanel.setBorder(new LineBorder(Color.black));
        player.setBorder(new LineBorder(Color.black));
        hiline.setBorder(new LineBorder(Color.black));
     
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tldr();
        //tuneLayout(frame); 
        frame.setVisible(true);
    }
    
    private void buildModeToolbar(){
        JButton source = new JButton(new ImageIcon("sys/smalltext.png"));
        JButton table = new JButton(new ImageIcon("sys/smalltext.png"));
        modePanel.add(source);
        modePanel.add(table);
    }
    
    private void buildFileFunctionsToolbar(){
        JButton nc = new JButton(new ImageIcon("sys/smalltext.png"));
        JButton imp = new JButton(new ImageIcon("sys/smalltext.png"));
        JButton exp = new JButton(new ImageIcon("sys/smalltext.png"));
        fileFunctionsPanel.add(nc);
        fileFunctionsPanel.add(imp);
        fileFunctionsPanel.add(exp);
    }
    
    private void tldr(){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0.9;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 3;
        frame.add(player, c);
        
        GridBagConstraints mpc = new GridBagConstraints();
        mpc.fill = GridBagConstraints.VERTICAL;
        mpc.gridx = 0;
        mpc.gridy = 1;
        mpc.weightx = 0.0;
        mpc.insets = new Insets(0, 5, 5, 0);
        frame.add(modePanel, mpc);
        
        GridBagConstraints tlpc = new GridBagConstraints();
        tlpc.fill = GridBagConstraints.BOTH;
        tlpc.gridx = 1;
        tlpc.gridy = 1;
        tlpc.weightx = 0.8;
        tlpc.weighty = 0.1;
        tlpc.insets = new Insets(0, 0, 5, 0);
        frame.add(hiline, tlpc);
        
        GridBagConstraints ffpc = new GridBagConstraints();
        ffpc.fill = GridBagConstraints.VERTICAL;
        ffpc.weightx = 0.0;
        ffpc.gridx = 2;
        ffpc.gridy = 1;
        ffpc.insets = new Insets(0, 0, 5, 5);
        frame.add(fileFunctionsPanel, ffpc);
    }
}