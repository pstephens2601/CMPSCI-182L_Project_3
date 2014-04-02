/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Creates a basic room object with variables for color
    and code.
 -----------------------------------------------------------------------------*/

package models;

public class Room {
    
    private String color;
    private int code;
    
    public Room(String newColor, int newCode) {
        color = newColor;
    }
    
    public Room(String newColor) {
        color = newColor;
    }
    
    public void setColor(String newColor) {
        color = newColor;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setCode(int newCode) {
        code = newCode;
    }
    
    public int getCode() {
        return code;
    }
}
