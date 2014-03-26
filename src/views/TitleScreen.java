/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;

public class TitleScreen extends Screen {
    
    public TitleScreen() {
        add(new JLabel("Title Screen"));
        setVisible(true);
    }
    
    @Override
    public void startGame() {
        setVisible(false);
    }
    
    @Override
    public void endGame() {
        
    }   
}
