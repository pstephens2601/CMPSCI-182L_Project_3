/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.GameController;
import views.GameBoard;
import javax.swing.*;

public class GameWindow extends JFrame {
    
    private GameBoard display;
    
    public GameWindow(GameController game) {
        setJMenuBar(new MainMenu(game));
        setTitle("The Golden Keyboard");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public GameWindow(int width, int height, GameController game) {
        setJMenuBar(new MainMenu(game));
        setTitle("The Golden Keyboard");
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setDisplay(GameBoard newDisplay) {
        display = newDisplay;
    }
    
    public GameBoard getDisplay() {
        return display;
    }
    
    
    
}