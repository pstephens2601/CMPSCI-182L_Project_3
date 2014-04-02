/*------------------------------------------------------------------------------
    Programmer: Patrick Stephens
    Email: pstephens2601@gmail.com
    Date: 3/21/14
    Title/Class: Project 3  / CMPSCI 182L - Ferguson

    Class Description:  Creates an array based stack that can increase or
    decrease in size if needed.
 -----------------------------------------------------------------------------*/

package models;

public class Stack {
    
    private Object [] stack;
    private int top;
    private int minStackSize;
    
    //creates a stack with only one availible slot
    public Stack() {
        stack = new Object[1];
        minStackSize = 1;
        top = -1;
    }
    
    //sets alloted size for new stack, recommended for most applications
    public Stack(int size) {
        stack = new Object[size];
        minStackSize = size;
        top = -1;
    }
    
    //push an object onto the stack
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
    
    //pop an object off of the stack
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
    
    //returns the top item on the stack
    public Object peek() {
        if (top >= 0) {
            return stack[top];
        }
        else {
            return null;
        }
    }
    
    //return true if the stack is empty, false if it is not
    public boolean empty() {   
        if (top == -1) {
            return true;
        }
        else {
            return false;
        }
    }
   
    //icreases the size of the stack
    private void increaseStackSize(int sizeIncrease) {
        Object [] newStack = new Object[stack.length + sizeIncrease];
        copyArray(newStack, stack);
        stack = newStack;
    }
    
    //decreases the size of the array containing the stack
    private void decreaseStackSize(int sizeDecrease) {
        Object [] newStack = new Object[stack.length - sizeDecrease];
        copyArray(newStack, stack);
        stack = newStack;
    }
    
    //copies the old stack to a new array
    private void copyArray(Object [] targetArray, Object [] sourceArray) {
        if (targetArray.length < sourceArray.length) {
            for (int i = 0; i < targetArray.length; i++) {
                targetArray[i] = sourceArray[i];
            }
        }
        else {
            for (int i = 0; i < sourceArray.length; i++) {
                targetArray[i] = sourceArray[i];
            }
        }
    }   
}