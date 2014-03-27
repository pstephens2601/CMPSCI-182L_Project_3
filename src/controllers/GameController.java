/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Class which compares the number of array slots looked 
    at in linear and binary searches.
 -----------------------------------------------------------------------------*/

package controllers;

import java.awt.*;
import javax.swing.*;
import views.Screen;
import views.GameWindow;
import models.Stack;
import models.Room;

public class GameController {
    
    private String gameStatus;
    private final GameWindow window;
    private Screen titleScreen;
    private Screen gameScreen;
    private Timer timer;
    
    private Stack stack;
    
    public GameController() {
        window = new GameWindow(1024, 768, this); 
    }
    
    public void startGame() {
        
        stack = new Stack();
        window.startGame();
        Room currentRoom = new Room("green");
        stack.push(currentRoom);
        //window.showRoom();
    }
    
    public void endGame() {
        window.endGame();
    }
}
