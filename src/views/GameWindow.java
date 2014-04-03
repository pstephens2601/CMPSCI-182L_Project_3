/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Creates the game window.
 -----------------------------------------------------------------------------*/

package views;

import controllers.GameController;
import views.Screen;
import javax.swing.*;
import java.awt.*;
import models.*;

public class GameWindow extends JFrame {
    
    private Screen [] screens = new Screen [2];
    private JPanel screenContainer = new JPanel();
    private MainMenu menu;
    private CardLayout cards = new CardLayout();
    private Stack roomStack;
    
    public GameWindow(GameController game) {
        menu = new MainMenu(game);
        setJMenuBar(menu);
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
        menu = new MainMenu(game);
        setJMenuBar(menu);
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
        menu.startGame();
        screens[1].startGame(stack);
    }
    
    public void restartGame(Stack stack) {
        //cards.show(screenContainer, "game");
        //menu.startGame();
        screens[1].restartGame(stack);
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
        menu.endGame();
    }
    
    public void gameOver() {
        GameScreen screen = (GameScreen)screens[1];
        Map map = screen.getMap();
        map.gameOver();
        repaint();
    }
    
    public void gameWon() {
        GameScreen screen = (GameScreen)screens[1];
        Map map = screen.getMap();
        map.gameWon();
        repaint();
    }
    
    public void keyBoardFound() {
        GameScreen screen = (GameScreen)screens[1];
        Map map = screen.getMap();
        map.keyBoardFound();
        repaint();
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
    }   
}