package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * @author Sova
 */
public class KindOfWindow {
    JFrame frame = new JFrame("Comfy Catscene");
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
        modePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        fileFunctionsPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        player.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        hiline.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
        modePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        fileFunctionsPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tldr();
    }
    
    private void buildModeToolbar(){
        JButton table = new JButton(new ImageIcon("sys/timeline.png"));
        JButton source = new JButton(new ImageIcon("sys/code.png"));
        table.setToolTipText("Эта кнопка переключает редактор в режим работы с таймлайном");
        source.setToolTipText("Эта кнопка переключает редактор в режим работы с исходным кодом");
        modePanel.add(table);
        modePanel.add(source);
    }
    
    private void buildFileFunctionsToolbar(){
        JButton nc = new JButton(new ImageIcon("sys/newcatscene.png"));
        JButton exp = new JButton(new ImageIcon("sys/save.png"));
        JButton imp = new JButton(new ImageIcon("sys/load.png"));
        fileFunctionsPanel.add(nc);
        fileFunctionsPanel.add(exp);
        fileFunctionsPanel.add(imp);
    }
    
    private void tldr(){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0.9;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 3;
        frame.add(player, c);
        
        GridBagConstraints mpc = new GridBagConstraints();
        mpc.fill = GridBagConstraints.VERTICAL;
        mpc.gridx = 0;
        mpc.gridy = 1;
        mpc.weightx = 0.0;
        mpc.insets = new Insets(0, 10, 10, 0);
        frame.add(modePanel, mpc);
        
        GridBagConstraints tlpc = new GridBagConstraints();
        tlpc.fill = GridBagConstraints.BOTH;
        tlpc.gridx = 1;
        tlpc.gridy = 1;
        tlpc.weightx = 0.8;
        tlpc.weighty = 0.1;
        tlpc.insets = new Insets(0, 0, 10, 0);
        frame.add(hiline, tlpc);
        
        GridBagConstraints ffpc = new GridBagConstraints();
        ffpc.fill = GridBagConstraints.VERTICAL;
        ffpc.weightx = 0.0;
        ffpc.gridx = 2;
        ffpc.gridy = 1;
        ffpc.insets = new Insets(0, 0, 10, 10);
        frame.add(fileFunctionsPanel, ffpc);
    }
    
    public void show(){
        frame.setVisible(true);
    }
    
    public void hide(){
        frame.setVisible(false);
    }
}