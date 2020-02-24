package ui.player;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Sova
 */
public class Player extends CanvasGameContainer {

    private final Dimension standartSize = new Dimension(600, 220);
    /*
    * не загружать новый инстанс BasicGame на каждый вызов Play(), 
    * гораздо лучше откатывать само слайдшоу командами вроде catscene.play()
    * catscene.stop() или catscene.reload(), что позоволит даже не останавливать 
    * рендеринг Slick - пусть просто рисует, что ему говорит катсцена, или черный экран/плейсхолдер
    */
    
    public Player(Game game) throws SlickException {
        super(game);
        setPreferredSize(standartSize);
    }

    public void play() {
        try {
            start();
        } catch (SlickException ex) {
            JOptionPane.showMessageDialog(this, "Slick не работает, предпросмотр отвалился");
        }
    }

    public void stop() {
        
    }

    private void setupPlaceholder() throws SlickException {
    }

    public Dimension getStandartSize() {
        return standartSize;
    }
}
