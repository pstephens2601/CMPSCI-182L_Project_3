/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.GameController;
import views.Screen;
import javax.swing.*;
import java.awt.*;
import models.*;
        
public abstract class Screen extends JPanel {
    
    protected Room currentRoom;
    protected Stack stack;
    
    public abstract void startGame(Stack stack);
    public abstract void endGame();
    public abstract void pauseGame();
}
