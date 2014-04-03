/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Creates the screen at the bottom of the game window
    with text fields and buttons.
 -----------------------------------------------------------------------------*/

package views;

import controllers.GameController;
import models.Stack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class EnterRoomScreen extends Screen implements ActionListener {
    
    private JButton pushButton,popButton,dumpButton,exitButton;
    private JTextField codeField, colorField;
    private GameController game;
    
    public EnterRoomScreen(GameController currentGame) {
        
        game = currentGame;
        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        
        //Add color text field
        add(new JLabel("Enter A Color: "));
        colorField = new JTextField("", 15);
        add(colorField);
        
        //Add code text field
        add(new JLabel("Enter Code:"));
        codeField = new JTextField("", 5);
        add(codeField);
        
        //Add buttons
        pushButton = new JButton("Push");
        add(pushButton);
        pushButton.addActionListener(this);
        popButton = new JButton("Pop");
        add(popButton);
        popButton.addActionListener(this);
        dumpButton = new JButton("Dump");
        dumpButton.addActionListener(this);
        add(dumpButton); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== exitButton) {
            //dispose();
            System.exit(0);
        }

        if (e.getSource()== popButton) {
            String codeInput = codeField.getText();
            String colorInput = colorField.getText().toLowerCase();
            try {
                int code = Integer.parseInt(codeInput);
                game.moveBack(code, colorInput);
            }
            catch(NumberFormatException exp) {
                game.moveBack(-1, colorInput);
            }  
        }

        if (e.getSource()== pushButton) {
            String codeInput = codeField.getText();
            String colorInput = colorField.getText().toLowerCase();
            try {
                int code = Integer.parseInt(codeInput);
                game.moveTo(code, colorInput);
            }
            catch(NumberFormatException exp) {
                game.moveTo(-1, colorInput);
            }  
        }

        if (e.getSource()== dumpButton) {
            System.out.println("Stack Contents Dump: ");
            game.dumpStack();
        }
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
