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

public class GameScreen extends Screen {
    
    private Map map;
            
    public GameScreen(GameController currentGame) {
        setLayout(new BorderLayout());
        buildSubScreens(currentGame);
        setVisible(false);
    }
    
    public Map getMap() {
        return map;
    }
    
    @Override
    public void startGame(Stack newStack) {
        setVisible(true);
        map.startGame(newStack);
    }
    
    public void restartGame(Stack newStack) {
        map.restartGame(newStack);
    }
    
    @Override
    public void endGame() {
        
    }
    
    public void updateRoom() { 
        map.setCurrentRoom();
    }
    
    private void buildSubScreens(GameController currentGame) {
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.setPreferredSize(new Dimension(60, 60));
        bottom.add(new EnterRoomScreen(currentGame));
        add(bottom, BorderLayout.SOUTH);
        
        map = new Map(currentGame);
        map.setBackground(Color.BLACK);
        map.setPreferredSize(new Dimension(425, 425));       
        add(map, BorderLayout.CENTER);
    }
}