/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

public class Room {
    
    private String color;
    private Door [] doors;
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
    
    public Door[] getDoors() {
        return doors;
    }
   
    public int getNumDoors() {
        return doors.length;
    }
}
