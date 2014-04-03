/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Main controller for the game.  Handles all of the
    game logic.
 -----------------------------------------------------------------------------*/

package controllers;

import views.Screen;
import views.GameWindow;
import models.*;

public class GameController {
    
    private String gameStatus;
    private final GameWindow window;
    private Screen titleScreen;
    private Screen gameScreen;
    private Stack stack;
    private int lastCode;
    private Room currentRoom;
    private boolean gameOver;
    private boolean keyBoardFound;
    private boolean gameWon;
     
    public GameController() {
        window = new GameWindow(700, 500, this);
    }
    
    //starts a new game
    public void startGame() {
        keyBoardFound = false;
        gameWon = false;
        gameOver = false;
        stack = new Stack();
        currentRoom = new Room("green");
        window.startGame(stack);   
    }
    
    //restarts a game in progress
    public void restartGame() {
        //create new stack, and room
        lastCode = 0;
        keyBoardFound = false;
        gameWon = false;
        gameOver = false;
        stack = new Stack();
        currentRoom = new Room("green");
        window.restartGame(stack);
    }
    
    //returns the current room
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    //executes when the push button in pressed, moves the player forward
    public void moveTo(int code, String color) {
        if (!gameOver && !gameWon) {
            if (codeIsValid(code, "push") && colorIsValid(color) && isAdjacent(color)) { 
                currentRoom.setCode(code);
                stack.push(currentRoom);
                currentRoom = new Room(color);
                if (currentRoom.getColor().contentEquals("gold")) {
                    keyBoardFound();
                }
            }
            else {
                gameOver();
            }
            lastCode = code;
            window.updateRoom();
            window.repaint();   
        }
    }
    
    //executes when the back button is pressed, moves the player backwards
    public void moveBack(int code, String color) {
        if (!gameOver && !gameWon) {
            if (!stack.empty()) {   
                Room room = (Room)stack.peek();
        
                if (color.contentEquals(room.getColor()) && room.getCode() == code) {
                    stack.pop();
                    currentRoom = room;
                    if (currentRoom.getColor().contentEquals("green") && keyBoardFound && stack.empty()) {
                        gameWon();
                    }
                }
                else {
                    gameOver();
                }

                window.updateRoom();
                window.repaint();
            }
            else {
                gameOver();
            }
        }
    }
    
    //dumps the contents to the stack to the console for testing
    public void dumpStack() {
        Room room;
        Stack tempStack = new Stack(10);
        
        if (!stack.empty()) {
            while (!stack.empty()) {
                room = (Room)stack.peek();
                tempStack.push(room);

                String color = room.getColor();
                int code = room.getCode();

                System.out.print("Room: " + color + " - Code: " + code + "\n");

                stack.pop();
            }
            
            do {
                stack.push(tempStack.peek());
                tempStack.pop();
            } while(!tempStack.empty());
        }   
    }
    
    //executes when the player dies
    private void gameOver() {
        gameOver = true;
        window.gameOver();
    }
    
    //executes when the player reaches the gold room
    private void keyBoardFound() {
        keyBoardFound = true;
        window.keyBoardFound();
    }
    
    //executes when the player returns to the green room with the keyboard
    private void gameWon() {
        gameWon = true;
        window.gameWon();
    }
    
    //checks to make sure that the room the player is leaving is adjacent tp the room the are moving to
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
    
    //checks to make sure that the code entered is a valid three digit code
    private boolean codeIsValid(int code, String action) {
        if (code <= 999 && code >= 1) {
            if (action.contentEquals("push")) {
                if (code != lastCode) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            } 
        }
        else {
            return false;  
        }
    }
    
    //checks to make sure the player has entered a valid color
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