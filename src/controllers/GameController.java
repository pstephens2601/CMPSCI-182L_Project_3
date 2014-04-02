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
    private Stack stack;
    private int lastCode;
    private Room currentRoom;
     
    public GameController() {
        window = new GameWindow(700, 500, this);
    }
    
    public void startGame() {
        //create new stack, and room
        stack = new Stack(10);
        currentRoom = new Room("green");
        window.startGame(stack);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        window.repaint();
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void moveTo(int code, String color) {
       
       if (codeIsValid(code) && colorIsValid(color) && isAdjacent(color)) { 
           currentRoom.setCode(code);
           stack.push(currentRoom);
           currentRoom = new Room(color);
       }
       else {
           gameOver();
       }
       lastCode = code;
       window.updateRoom();
       window.repaint();
    }
    
    public void moveBack(int code, String color) {
        Room currentRoom = (Room)stack.peek();
        
        stack.pop();
        
        if ((Room)stack.peek() != null) {
            Room destinationRoom = (Room)stack.peek();
        
            if (destinationRoom.getCode() != code || color.compareTo(destinationRoom.getColor()) != 0 ) {
                stack.push(currentRoom);
                gameOver();
            }
        }
        else {
            gameOver();
        }
        
        window.updateRoom();
        window.repaint();
    }
    
    public void dumpStack() {
        Room room;
        Stack tempStack = new Stack(10);
        
        if (stack.peek() != null) {
            do {
                room = (Room)stack.peek();
                tempStack.push(room);
                
                String color = room.getColor();
                int code = room.getCode();
                
                System.out.print("Room: " + color + " - Code: " + code + "\n");
                
                stack.pop();
            } while(stack.peek() != null);
            
            do {
                stack.push(tempStack.peek());
                tempStack.pop();
            } while(tempStack.peek() != null);
        }   
    }
    
    private void gameOver() {
        window.gameOver();
    }
    
    private boolean isAdjacent(String color) {
        
        String roomColor = currentRoom.getColor();
        
        switch (roomColor) {
            case "green":
                if (color.contentEquals("brown") || color.contentEquals("pink") || color.contentEquals("blue")) {
                    return true;
                }
                break;
            case "brown":
                if (color.contentEquals("pink") || color.contentEquals("red") || color.contentEquals("green")) {
                    return true;
                }
                break;
            case "pink":
                if (color.contentEquals("brown") || color.contentEquals("blue") || color.contentEquals("green")) {
                    return true;
                }
                break;
            case "blue":
                if (color.contentEquals("pink") || color.contentEquals("yellow") || color.contentEquals("green")) {
                    return true;
                }
                break;
            case "red":
                if (color.contentEquals("brown") || color.contentEquals("yellow")) {
                    return true;
                }
                break;
            case "yellow":
                if (color.contentEquals("gold") || color.contentEquals("blue") || color.contentEquals("red")) {
                    return true;
                }
                break;
            case "gold":
                if (color.contentEquals("yellow")) {
                    return true;
                }
                break;
            default:
                return false;
        }
        
        return false;
    }
    
    private boolean codeIsValid(int code) {
        if (code <= 999 && code >= 0 && code != lastCode) {
            return true;
        }
        else {
            return false;  
        }
    }
    
    private boolean colorIsValid(String color) {
        
        String [] colors = {"green", "brown", "pink", "blue", "red", "yellow", "gold"};
        
        for (int i = 0; i < colors.length; i++) {
            if (color.compareTo(colors[i]) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public void endGame() {
        window.endGame();
    }
}