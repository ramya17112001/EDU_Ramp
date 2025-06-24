package com.day12;

import java.util.Stack;

public class TextEditorUndoRedo { 
	private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private String currentText = "";

    public void type(String newText) {
        undoStack.push(currentText);       
        currentText = newText;             
        redoStack.clear();               
        System.out.println("Typed: " + currentText);
    } 

   
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);  
            currentText = undoStack.pop(); 
            System.out.println("Undo: " + currentText);
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);   
            currentText = redoStack.pop();
            System.out.println("Redo: " + currentText);
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public void printCurrentText() {
        System.out.println("Current Text: " + currentText);
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        editor.type("Hello");
        editor.type("chatgpt");
        editor.type("Openai"); 

        editor.undo(); 
        editor.undo(); 

        editor.redo(); 

        editor.type("Openai");  

        editor.undo(); 
        editor.redo(); 

        editor.printCurrentText();  
    }
} 



