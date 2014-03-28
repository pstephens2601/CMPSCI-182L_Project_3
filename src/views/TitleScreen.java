/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import java.awt.*;
import javax.swing.*;
import models.Stack;

public class TitleScreen extends Screen {
    
    public TitleScreen() {
        add(new JLabel("Title Screen"));
        setBackground(Color.WHITE);
        setVisible(true);
    }
    
    @Override
    public void startGame(Stack stack) {
        setVisible(false);
    }
    
    @Override
    public void pauseGame() {
        
    }
    
    @Override
    public void endGame() {
        setVisible(true);
    }   
}
