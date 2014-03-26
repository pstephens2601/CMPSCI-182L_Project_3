/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.GameController;
import views.Screen;
import javax.swing.*;

public class GameWindow extends JFrame {
    
    private Screen [] screens = new Screen [2];
    
    public GameWindow(GameController game) {
        setJMenuBar(new MainMenu(game));
        setTitle("The Golden Keyboard");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildScreens();
        setScreen(0);
        setVisible(true);
    }
    
    public GameWindow(int width, int height, GameController game) {
        setJMenuBar(new MainMenu(game));
        setTitle("The Golden Keyboard");
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildScreens();
        setScreen(0);
        setVisible(true);
    }
    
    public void startGame() {
        setScreen(1);
        for (int i = 0; i < screens.length; i++) {
            screens[i].startGame();
        }
    }
    
    public void endGame() {
        setScreen(0);
        for (int i = 0; i < screens.length; i++) {
            screens[i].endGame();
        } 
    }
    
    private void buildScreens() {
        screens[0] = new TitleScreen();
        add(screens[0]);
        screens[1] =  new GameScreen();
        add(screens[1]);
    }
    
    private void setScreen(int screenNum) {
        
    }
}