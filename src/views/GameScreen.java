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
        setBackground(Color.YELLOW);
        setLayout(new BorderLayout());
        buildSubScreens(currentGame);
        setVisible(false);
    }
    
    @Override
    public void startGame(Stack newStack) {
        setVisible(true);
        map.startGame(newStack);
    }
    
    @Override
    public void pauseGame() {
        
    }
    
    @Override
    public void endGame() {
        
    }
    
    private void buildSubScreens(GameController currentGame) {
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.setPreferredSize(new Dimension(60, 60));       
        add(bottom, BorderLayout.SOUTH);
        
        map = new Map(currentGame);
        map.setBackground(Color.BLACK);
        map.setPreferredSize(new Dimension(425, 425));       
        add(map, BorderLayout.CENTER);
    }
}