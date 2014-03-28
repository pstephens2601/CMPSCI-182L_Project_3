/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

public class GamePiece {
    
    private int xPosition;
    private int yPosition;
    
    public void setXPosition(int newXPosition) {
        xPosition =  newXPosition;
    }
    
    public int getXPosition() {
        return xPosition;
    }
    
    public void setYPosition(int newYPosition) {
        yPosition = newYPosition;
    }
    
    public int getYPosition() {
        return yPosition;
    }
}
