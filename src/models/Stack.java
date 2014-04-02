/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

public class Stack {
    
    private Object [] stack;
    private int top;
    private int minStackSize;
    
    public Stack() {
        stack = new Object[1];
        minStackSize = 1;
        top = -1;
    }
    
    public Stack(int size) {
        stack = new Object[size];
        minStackSize = size;
        top = -1;
    }
    
    public void push(Object obj) {
        if (top < stack.length - 1) {
            stack[++top] = obj;
        }
        else
        {
            increaseStackSize(1);
            stack[++top] = obj; 
        }
    }
    
    public Object pop() {
        if (top >= 0) {
            Object currentObject = stack[top--];
            if (top > minStackSize) {
                decreaseStackSize(1);
            }
            return currentObject;
        }
        else {
            return null;
        }
    }
    
    public Object peek() {
        if (top >= 0) {
            return stack[top];
        }
        else {
            return null;
        }
    }
    
    public void empty() {   
        top = -1;
    }
   
    //icreases the size of the stack
    private void increaseStackSize(int sizeIncrease) {
        Object [] newStack = new Object[stack.length + sizeIncrease];
        copyArray(newStack, stack);
        stack = newStack;
    }
    
    private void decreaseStackSize(int sizeDecrease) {
        Object [] newStack = new Object[stack.length - sizeDecrease];
        copyArray(newStack, stack);
        stack = newStack;
    }
    
    private void copyArray(Object [] targetArray, Object [] sourceArray) {
        for (int i = 0; i < stack.length; i++) {
            targetArray[i] = sourceArray[i];
        }
    }   
}