/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Creates the colored screen at the top of the game
    window.
 -----------------------------------------------------------------------------*/

package views;

import javax.swing.*;
import java.awt.*;
import models.*;
import controllers.GameController;
import java.awt.event.ActionListener;

public class Map extends Screen {
    private JLabel invalidInputError;
    private boolean gameOver = false;
    private boolean gameWon = false;
    private boolean keyBoardFound = false;
    private Image gameOverImage;
    private Image gameWonImage;
    private Image keyBoardFoundImage;
    private GameController game;
    
    
    public Map(GameController currentGame) {
        game = currentGame;
        setGameOverImage();
        setGameWonImage();
        setKeyboardFoundImage();
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        //g2d.drawImage(player.getImage(), player.getXPosition(), player.getYPosition(), this);
        
        if (gameOver == true) {
            g2d.drawImage(gameOverImage, 150, 100, this);
        }
        if (gameWon == true) {
            g2d.drawImage(gameWonImage, 200, 150, this);
        }
        if (keyBoardFound == true) {
            g2d.drawImage(keyBoardFoundImage, 550, 25, this);
        }
    }
    
    @Override
    public void startGame(Stack newStack) {
        stack = newStack;
        setCurrentRoom();
        repaint();
    }
    
    @Override
    public void restartGame(Stack newStack) {
        stack = newStack;
        gameOver = false;
        gameWon = false;
        keyBoardFound = false;
        setCurrentRoom();
        repaint();
    }
    
    @Override
    public void endGame() {
        gameOver = false;
        gameWon = false;
    }
    
    public void setCurrentRoom() {
        currentRoom = game.getCurrentRoom();
        setMapColor();
    }
    
    public void gameOver() {
       gameOver = true;
    }
    
    public void gameWon() {
       gameWon = true;
    }
    
    public void keyBoardFound() {
       keyBoardFound = true;
    }
    
    private void setGameOverImage() {
        ImageIcon pic = new ImageIcon(this.getClass().getResource("/images/GameOver.png"));
        gameOverImage = pic.getImage();
    }
    
    private void setGameWonImage() {
        ImageIcon pic = new ImageIcon(this.getClass().getResource("/images/GameWon.png"));
        gameWonImage = pic.getImage();
    }
    
    private void setKeyboardFoundImage() {
        ImageIcon pic = new ImageIcon(this.getClass().getResource("/images/KeyBoard.png"));
        keyBoardFoundImage = pic.getImage();
    }
    
    private void setMapColor() {
        switch(currentRoom.getColor()) {
            case "green":
                setBackground(new Color(110, 155, 66));
                break;
            case "brown":
                setBackground(new Color(61, 28, 0));
                break;
            case "pink":
                setBackground(new Color(255, 132, 124));
                break;
            case "blue":
                setBackground(new Color(11, 72, 107));
                break;
            case "red":
                setBackground(new Color(163, 0, 6));
                break;
            case "yellow":
                setBackground(new Color(255, 229, 69));
                break;
            case "gold":
                setBackground(new Color(255, 188, 17));
                break;
        }
    }
    
}
