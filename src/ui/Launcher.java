package ui;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * @author Maggistrator
 */
public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        setLoolAndFeelDecorated();
            KindOfWindow mw = new KindOfWindow();

            mw.show();
        });
    }

    //метод, отвечающий за смену стиля
    private static void setLoolAndFeelDecorated() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Стиль интерфейса сломался, так что будет установлен стиль по-умолчанию.");
        }
    }
}
