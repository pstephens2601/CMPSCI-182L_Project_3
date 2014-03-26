/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;

public class GameScreen extends Screen {
    
    public GameScreen() {
        add(new JLabel("Game Screen"));
        setVisible(false);
    }
    
    @Override
    public void startGame() {
        setVisible(true);
    }
    
    @Override
    public void endGame() {
        
    }   
}
