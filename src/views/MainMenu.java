/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar {  
    
    public MainMenu(final GameController game) {
        add(buildFileMenu(game));
        add(buildGameMenu(game));   
    }
    
    private JMenu buildFileMenu(final GameController game) {
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        fileMenu.add(exit);
        
        return fileMenu;
    }
    
    private JMenu buildGameMenu(final GameController game) {
        
        JMenu gameMenu = new JMenu("game");
        
        JMenuItem start = new JMenuItem("Start Game");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                game.startGame();
            }
        });
        gameMenu.add(start);
        
        JMenuItem end = new JMenuItem("End Game");
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                game.endGame();
            }
        });
        gameMenu.add(end);
        
        return gameMenu;
    }
}
