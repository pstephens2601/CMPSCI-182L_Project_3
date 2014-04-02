/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;
import models.*;
import controllers.GameController;
import java.awt.event.ActionListener;

public class Map extends Screen {
    private JLabel invalidInputError;
    private boolean gameOver = false;
    private Image gameOverImage;
    private GameController game;
    
    public Map(GameController currentGame) {
        game = currentGame;
        setGameOverImage();
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
    }
    
    @Override
    public void startGame(Stack newStack) {
        stack = newStack;
        setCurrentRoom();
        repaint();
    }
    
    @Override
    public void endGame() {
        
    }
    
    @Override
    public void pauseGame() {
        
    }
    
    public void setCurrentRoom() {
        currentRoom = game.getCurrentRoom();
        setMapColor();
    }
    
    public void gameOver() {
       gameOver = true;
    }
    
    private void setGameOverImage() {
        ImageIcon pic = new ImageIcon(this.getClass().getResource("/images/GameOver.png"));
        gameOverImage = pic.getImage();
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
