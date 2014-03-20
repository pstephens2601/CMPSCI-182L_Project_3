/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import views.GameBoard;
import views.GameWindow;
import models.Stack;
import models.Room;

/**
 *
 * @author Owner
 */
public class GameController {
    
    private String gameStatus;
    private final GameWindow window;
    private GameBoard titleScreen;
    private GameBoard gameScreen;
    
    private Stack stack;
    
    
    public GameController() {
        window = new GameWindow(800, 500, this);
        window.setDisplay(titleScreen);
    }
    
    public void startGame() {
        window.setDisplay(gameScreen);
    }
}
