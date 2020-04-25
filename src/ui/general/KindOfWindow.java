package ui.general;

import ui.player.Player;
import ui.hiline.Hiline;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import org.newdawn.slick.SlickException;
import ui.player.SlickSandbox;

/**
 * НАПОМИНАЛКА: Использовать для редактора XML библиотеку rsyntaxtextarea 
 * из BeardedSorcererIDE, чтобы она была сразу с подсветкой синтаксиса
 * 
 * @author Maggistrator
 */
public class KindOfWindow {    
    JFrame frame;    //Главное окно программы
    Player player;                                  //Slick2D-холст предпросмотра
    Hiline hiline;                   //Hilight+Timline - имитатор таймлайна
    SlickSandbox game;//Slick2D-игра, управляющая нативной отрисовкой Slick2D-контейнера "player"
    JMenuBar menu ;
    
    @Deprecated
    JPanel modePanel = new JPanel();                //Панель управления режимами программы
    @Deprecated
    JPanel fileFunctionsPanel = new JPanel();       //Панель файловых операций, таких как сохранение или загрузка 

    
    public KindOfWindow() {
        frame = new JFrame("Comfy Catscene");
        hiline = new Hiline(); 
        menu = new JMenuBar();
        game = new SlickSandbox("Sandbox");
        //Плеер начинает отрисовку с момента старта программы
        try {
            player = new Player(game);
        } catch (SlickException | NullPointerException ex) {
            JOptionPane.showMessageDialog(frame, "Slick не работает, предпросмотр отвалился");
        }
        if(player != null) 
                player.play();
        else System.out.println("suck my cock");
        //Настройка параметров окна
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());  
        frame.setMinimumSize(new Dimension(640, 480));
       
        //функции настройки панелей
        buildModeToolbar();
        buildFileFunctionsToolbar();
        
        modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
        fileFunctionsPanel.setLayout(new BoxLayout(fileFunctionsPanel, BoxLayout.Y_AXIS));
        modePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        fileFunctionsPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        hiline.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
        modePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        fileFunctionsPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        
        //Slick не позволяет закрыть окно через EXIT_ON_CLOSE, и этот слушатель выполняет его работу
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                player.stop();
                System.exit(0);
            }
        });
        buildMainMenu();
        configureLayout();
    }
    
    private void buildModeToolbar(){
        //TODO: подумать, следует ли выделять построение панелей в функции - не будет ли правильнее 
        //сделать всё в конструкторе, благо методы совсем небольшие
        //Или же стоит выделить настройку главного окна, плеера и таймлайна так же отдельными функциями?
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
    
    private void buildMainMenu(){
        JMenu fileMenuItem = new JMenu("File");
        JMenu imageMenuItem = new JMenu("Image");
        JMenu musicMenuItem = new JMenu("Music");
        JMenu soundMenuItem = new JMenu("Sound");
        JMenu subtitlesMenuItem = new JMenu("Subtitles");
        JMenu modeMenuItem = new JMenu("Mode");
        JMenu helpMenuItem = new JMenu("Help");
        
        menu.add(fileMenuItem);
        menu.add(imageMenuItem);
        menu.add(musicMenuItem);
        menu.add(soundMenuItem);
        menu.add(subtitlesMenuItem);
        menu.add(modeMenuItem);
        menu.add(helpMenuItem);
       
        //menu.setHelpMenu(helpMenuItem); //Not yet implemented in JDK
        frame.setJMenuBar(menu);
    }
    
    private void configureLayout(){
        //Расположение плеера
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0.9;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 3;
        frame.add(player, c);
        
        //Конфигурируем панель управления режимами
        GridBagConstraints mpc = new GridBagConstraints();
        mpc.fill = GridBagConstraints.VERTICAL;
        mpc.gridx = 0;
        mpc.gridy = 1;
        mpc.weightx = 0.0;
        mpc.insets = new Insets(0, 10, 10, 0);
        //frame.add(modePanel, mpc);
        
        //Конфигурируем таймлайн
        GridBagConstraints tlpc = new GridBagConstraints();
        tlpc.fill = GridBagConstraints.BOTH;
        tlpc.gridx = 1;
        tlpc.gridy = 1;
        tlpc.weightx = 0.8;
        tlpc.weighty = 0.1;
        tlpc.insets = new Insets(0, 10, 10, 10);
        frame.add(hiline, tlpc);
        
        //Конфигурируем панель файловых функций
        GridBagConstraints ffpc = new GridBagConstraints();
        ffpc.fill = GridBagConstraints.VERTICAL;
        ffpc.weightx = 0.0;
        ffpc.gridx = 2;
        ffpc.gridy = 1;
        ffpc.insets = new Insets(0, 0, 10, 10);
        //frame.add(fileFunctionsPanel, ffpc);
    }
    
    /**
     * Показывает главное окно
     */
    public void show(){
        frame.setVisible(true);
    }
    
    /**
     * Скрывает главное окно
     */
    public void hide(){
        frame.setVisible(false);
    }
}