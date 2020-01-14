package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Maggistrator
 */
public class Launcher {

    public static void main(String[] args) {
        KindOfWindow mw = new KindOfWindow();
        mw.show();
        debug(mw);
    }
    
    private static void debug(KindOfWindow mw){
        JFrame frame = new JFrame("debug");
        JButton nope = new JButton("show");
        nope.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mw.show();
            }
        });
        JButton yup = new JButton("hide");
        yup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mw.hide();
            }
        });
        frame.setLayout(null);
        nope.setBounds(0,2,200,20);
        yup.setBounds(0,22,200,20);
        frame.setBounds(0,0,216,82);
        frame.add(yup);
        frame.add(nope);
        frame.setVisible(true);
    }
    
}
