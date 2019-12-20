/*
 * The MIT License
 *
 * Copyright 2019 Maggistrator.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * This window contains all other GUI components, excluding modal frames.
 *
 * @author Maggistrator
 */
public class MainWindow {
    //Основное окно программы
    JFrame frame = new JFrame("MIT Cutsciene Editor");
    //Заглушки-контейнеры для плеера и таймлайна
    JPanel playerPlaceholder = new JPanel();
    JPanel timelinePlaceholder = new JPanel();
    //панели инструментов работы с файлами, и режимов редактора
    JToolBar editorMode = new JToolBar(JToolBar.VERTICAL);
    JToolBar fileFuncions = new JToolBar(JToolBar.VERTICAL);

    //Стандартные размеры окна и компонентов
    private final int STD_GAP = 5;
    private final Dimension WINDOW_MINIMUM_SIZE = new Dimension(640, 480);
    private final Dimension LARGE_COMPONENT_SIZE = new Dimension(640 - STD_GAP*2, 240 - STD_GAP*2);
    
    
    
    public MainWindow() {        
        frame.setPreferredSize(WINDOW_MINIMUM_SIZE);
        //frame.setLayout(new BorderLayout(STD_GAP, STD_GAP));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Конфигурируем параметры панели-плеера
        //playerPlaceholder.setPreferredSize(LARGE_COMPONENT_SIZE);
        playerPlaceholder.setForeground(Color.red);
        playerPlaceholder.setSize(LARGE_COMPONENT_SIZE);
        //playerPlaceholder.setLocation(STD_GAP, STD_GAP);
        
        //Конфигурируем параметры панели-таймлайна
        //timelinePlaceholder.setPreferredSize(LARGE_COMPONENT_SIZE);
        timelinePlaceholder.setSize(LARGE_COMPONENT_SIZE);
        timelinePlaceholder.setForeground(Color.green);
        //timelinePlaceholder.setLocation(STD_GAP, STD_GAP);
        
        frame.add(playerPlaceholder, BorderLayout.NORTH);
        frame.add(timelinePlaceholder, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
}
