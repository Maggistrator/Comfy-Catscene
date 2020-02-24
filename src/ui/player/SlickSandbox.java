package ui.player;

import com.catscene.code.Cutsciene;
import com.catscene.core.TrueTypeFont;
import java.awt.Font;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * @author Maggistrator
 */
public class SlickSandbox extends BasicGame {
    private Image placeholder;
    Cutsciene cs = new Cutsciene();
    
    //костыль, который загружает массив русских символов в поддерживаемые кодировки
    public static Font font = new Font("Courier New", Font.PLAIN, 16);
    public static TrueTypeFont slicFont;

    public SlickSandbox(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        placeholder = new Image("sys/placeholder.jpg");
        slicFont = new TrueTypeFont(font, true, ("йцукенгшщзхъфывапролджэячсмитьбюё".toUpperCase() + "йцукенгшщзхъфывапролджэячсмитьбюё").toCharArray());
        cs.initWithScript("res/scripts/test.xml", container, slicFont);
        cs.start();
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setFont(slicFont);
        g.setColor(Color.white);
        g.drawImage(placeholder, 0, 0);
        cs.render(g, container, 0, 0);
        g.drawString(cs.playingAt() + "", container.getWidth() - 40, 0);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        cs.update(delta);
    }
}
