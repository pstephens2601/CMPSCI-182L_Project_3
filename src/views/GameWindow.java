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

public class GameWindow extends JFrame {
    
    private Screen [] screens = new Screen [3];
    private JPanel screenContainer = new JPanel();
    private CardLayout cards = new CardLayout();
    private Stack roomStack;
    
    public GameWindow(GameController game) {
        setJMenuBar(new MainMenu(game));
        setTitle("The Golden Keyboard");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildScreens(game);
        cards.show(screenContainer, "title");
        setVisible(true);
    }
    
    public GameWindow(int width, int height, GameController game) {
        
        setJMenuBar(new MainMenu(game));
        setTitle("The Golden Keyboard");
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildScreens(game);
        cards.show(screenContainer, "title");
        setVisible(true);
    }
    
    public void startGame(Stack stack) {
        cards.show(screenContainer, "game");
        screens[1].startGame(stack);
    }
    
    public void getDoorCode() {
        cards.show(screenContainer, "doorCode");
    }
    
    public void updateRoom() {
        GameScreen screen = (GameScreen)screens[1];
        screen.updateRoom();
    }
    
    public void endGame() {
        cards.show(screenContainer, "title");
        for (int i = 0; i < screens.length; i++) {
            screens[i].endGame();
        } 
    }
    
    public void gameOver() {
        GameScreen screen = (GameScreen)screens[1];
        Map map = screen.getMap();
        map.gameOver();
    }
     
    public void setStack(Stack newStack) {
        roomStack = newStack;
    }
    
    private void buildScreens(GameController currentGame) {
        screenContainer.setLayout(cards);
        add(screenContainer);
        screens[0] = new TitleScreen();
        screenContainer.add(screens[0], "title");
        screens[1] =  new GameScreen(currentGame);
        screenContainer.add(screens[1], "game");
        screens[2] = new EnterRoomScreen(currentGame);
        screenContainer.add(screens[2], "doorCode");
    }   
}