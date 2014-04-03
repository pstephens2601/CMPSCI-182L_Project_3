/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Creates the games title screen.
 -----------------------------------------------------------------------------*/

package views;

import java.awt.*;
import javax.swing.*;
import models.Stack;

public class TitleScreen extends Screen {
    
    private Image titleImage;
    
    public TitleScreen() {
        setTitleImage();
        setBackground(new Color(255, 188, 17));
        setVisible(true);
        repaint();
    }
    
     @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(titleImage, 100, -50, this);
    }
    
    private void setTitleImage() {
        ImageIcon pic = new ImageIcon(this.getClass().getResource("/images/Title.png"));
        titleImage = pic.getImage();
    }
    
    @Override
    public void startGame(Stack stack) {
        setVisible(false);
    }
    
    @Override
    public void restartGame(Stack stack) {
        setVisible(false);
    }
    
    @Override
    public void endGame() {
        setVisible(true);
    }   
}
