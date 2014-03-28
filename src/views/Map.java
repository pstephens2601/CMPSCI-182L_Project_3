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

public class Map extends Screen {
    
    private Player player;
    
    public Map(GameController currentGame) {
        player = currentGame.getPlayer();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(player.getImage(), player.getXPosition(), player.getYPosition(), this);  
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
    
    private void setCurrentRoom() {
        currentRoom = (Room)stack.peek();
        setMapColor();
    }
    
    private void setMapColor() {
        switch(currentRoom.getColor()) {
            case "green":
                setBackground(new Color(110, 155, 66));
                break;
        }
    }
}
