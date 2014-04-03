/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:
 -----------------------------------------------------------------------------*/

package views;

import javax.swing.*;
import models.*;
        
public abstract class Screen extends JPanel {
    
    protected Room currentRoom;
    protected Stack stack;
    
    public abstract void startGame(Stack stack);
    public abstract void endGame();
    public abstract void restartGame(Stack stack);
}
