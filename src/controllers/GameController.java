/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Class which compares the number of array slots looked 
    at in linear and binary searches.
 -----------------------------------------------------------------------------*/

package controllers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import views.Screen;
import views.GameWindow;
import models.*;

public class GameController implements ActionListener {
    
    private String gameStatus;
    private final GameWindow window;
    private Screen titleScreen;
    private Screen gameScreen;
    private Timer timer;
    private Stack stack;
    private Player player;
    
    private Room greenRoom;
    private Room brownRoom;
    private Room pinkRoom;
    private Room blueRoom;
    private Room redRoom;
    private Room yellowRoom;
    private Room goldRoom;
     
    public GameController() {
        player = new Player(100, 100);
        player.setImage("/images/TrickOrTreater3.png");
        window = new GameWindow(1024, 768, this);
        
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void startGame() {
        //create new stack, generate player, and room
        stack = new Stack();
        
        buildRooms();
        stack.push(greenRoom);
        resetPlayerPosition();
       
        //create timer object
        timer = new Timer(15, this);
        window.startGame(stack);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.getHealth() > 0 || playerAtDoor()) {
            player.move();
        }
        else if (playerAtDoor()) {
            getDoorCode();
        }
        else {
            endGame();
        }
        
        gameScreen.repaint();
    }
    
    private Room getCurrentRoom() {
        Room currentRoom = (Room)stack.peek();
        return currentRoom;
    }
    
    private void moveToRoom(String color) {
       
    }
    
    private void buildRooms() {
        greenRoom = new Room("green");
        brownRoom = new Room("brown");
        pinkRoom = new Room("pink");
        blueRoom = new Room("blue");
        redRoom =  new Room("red");
        yellowRoom = new Room("yellow");
        goldRoom = new Room("gold"); 
    }
    
    private void restPlayerPosition() {
        
    }
    
    private void getDoorCode() {
        
    }
    
    private void resetPlayerPosition() {
        
    }
    
    private boolean playerAtDoor() {
        
        Room currentRoom = getCurrentRoom();
        Door [] doors = currentRoom.getDoors();
        
        for (int i = 0; i < currentRoom.getNumDoors(); i++) {
            if (doors[i].getXPosition() < player.getXPosition() + 10 ||
                doors[i].getXPosition() > player.getXPosition() - 10 ||
                doors[i].getYPosition() < player.getYPosition() + 10 ||
                doors[i].getYPosition() > player.getYPosition() - 10) {
                
                
                
            }
        }
        
                
        return false;
    }
    
    public void endGame() {
        window.endGame();
    }
}
