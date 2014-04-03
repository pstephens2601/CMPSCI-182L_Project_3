/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Creates the JMenuBar at the top of the main game window.
 -----------------------------------------------------------------------------*/

package views;

import controllers.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar {
    
    private JMenu fileMenu;
    private JMenu gameMenu;
    private JMenuItem startRef;
    private JMenuItem restartRef;
    
    
    public MainMenu(final GameController game) {
        fileMenu = buildFileMenu(game);
        gameMenu = buildGameMenu(game);
        
        add(fileMenu);
        add(gameMenu);   
    }
    
    private JMenu buildFileMenu(final GameController game) {
        JMenu localFileMenu = new JMenu("File");
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        localFileMenu.add(exit);
        
        return localFileMenu;
    }
    
    private JMenu buildGameMenu(final GameController game) {
        
        JMenu localGameMenu = new JMenu("game");
        
        JMenuItem start = new JMenuItem("Start Game");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                game.startGame();
            }
        });
        localGameMenu.add(start);
        startRef = start;
        
        JMenuItem end = new JMenuItem("End Game");
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                game.endGame();
            }
        });
        localGameMenu.add(end);
        
        JMenuItem restart = new JMenuItem("Restart Game");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                game.restartGame();
            }
        });
      
        restartRef = restart;
        
        return localGameMenu;
    }
    
    public void startGame() {
        gameMenu.insert(restartRef, 0);
        gameMenu.remove(startRef); 
    }
    public void endGame() {
        gameMenu.insert(startRef, 0);
        gameMenu.remove(restartRef);
    }
}
