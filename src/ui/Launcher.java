package ui;

import ui.general.KindOfWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Maggistrator
 */
public class Launcher {

    public static void main(String[] args) {
        setLoolAndFeelDecorated();
        SwingUtilities.invokeLater(() -> {
            KindOfWindow mw = new KindOfWindow();

            mw.show();
        });
    }

    //<editor-fold defaultstate="collapsed" desc="настройка Look and Feel">
    private static void setLoolAndFeelDecorated() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Стиль интерфейса сломался, так что будет установлен стиль по-умолчанию.");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

}
