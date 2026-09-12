package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditor {
    private String currentText;
    private final Deque<String> undoStack;
    private final Deque<String> redoStack;
    private static final int MAX_HISTORY = 100;

    public TextEditor() {
        this.currentText = "";
        this.undoStack = new ArrayDeque<>();
        this.redoStack = new ArrayDeque<>();
    }
    public TextEditor(String initialText) {
        this.currentText = initialText;
        this.undoStack = new ArrayDeque<>();
        this.redoStack = new ArrayDeque<>();
    }
    /**
     * Types (adds) text to the current position (appends to end)
     * Clears the redo stack as per standard undo/redo behavior
     * Pushes current state to undo stack before making change
     *
     * @param text The text to type
     */
    public void type(String text){
        if (text == null || text.isEmpty()){
            return;
        }
        // save current state to undo stack
        pushToUndo(currentText);
        //make the change
        currentText += text;

        // clear redo stack
        clearRedoStack();
        System.out.println("Typed: " + text);
    }

    private void pushToUndo(String text) {
        undoStack.push(text);
        // Limit undo stack size to prevent memory issues
        if (undoStack.size() > MAX_HISTORY) {
            undoStack.removeLast();
        }
    }
    public void deleteRange(int start, int end) {
        if (start < 0 || end > currentText.length() || start >= end) {
            return;
        }

        pushToUndo(currentText);
        String deletedText = currentText.substring(start, end);
        currentText = currentText.substring(0, start) + currentText.substring(end);
        clearRedoStack();

        System.out.println("  Deleted: \"" + deletedText + "\" from position " + start + " to " + end);
    }

    // insert a text at a specific position
    public void insertAt(int position, String text) {
        if (text == null || text.isEmpty()) {
            return;
        }
        if (position < 0 || position > currentText.length()) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        pushToUndo(currentText);
        currentText = currentText.substring(0, position) + text + currentText.substring(position);
        clearRedoStack();

        System.out.println("Inserted: " + text + " at position " + position);
    }
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("   Nothing to undo!");
            return;
        }

        // Save current state to redo stack
        redoStack.push(currentText);

        // Restore previous state
        currentText = undoStack.pop();
        System.out.println("  Undo performed");
    }
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("    Nothing to redo!");
            return;
        }

        // Save current state to undo stack
        undoStack.push(currentText);

        // Restore from redo stack
        currentText = redoStack.pop();
        System.out.println("   Redo performed");
    }
    /**
     * Clears the redo stack
     * Called when a new action is performed
     */
    private void clearRedoStack() {
        redoStack.clear();
    }

    /**
     * Gets the current text
     */
    public String getText() {
        return currentText;
    }
    /**
     * Sets the text directly (useful for loading files)
     * Also stores in undo stack
     */
    public void setText(String text) {
        if (text == null) {
            text = "";
        }
        pushToUndo(currentText);
        currentText = text;
        clearRedoStack();
    }

    /**
     * Clears all text
     */
    public void clear() {
        if (currentText.isEmpty()) {
            return;
        }
        pushToUndo(currentText);
        currentText = "";
        clearRedoStack();
        System.out.println("  Cleared all text");
    }

    /**
     * Returns the current state as a formatted string
     */
    public String getState() {
        return currentText.isEmpty() ? "[empty]" : "\"" + currentText + "\"";
    }

    /**
     * Prints the current state with context
     */
    public void printState(String context) {
        System.out.println( context + ": " + getState());
        System.out.println(" Undo size: " + undoStack.size() +
                ", Redo size: " + redoStack.size());
        System.out.println("  _________________________");
    }

    /**
     * Gets the undo stack size (for debugging)
     */
    public int getUndoSize() {
        return undoStack.size();
    }

    /**
     * Gets the redo stack size (for debugging)
     */
    public int getRedoSize() {
        return redoStack.size();
    }

    /**
     * Checks if undo is available
     */
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    /**
     * Checks if redo is available
     */
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    @Override
    public String toString() {
        return "TextEditor{text='" + currentText +
                "', undoSize=" + undoStack.size() +
                ", redoSize=" + redoStack.size() + "}";
    }
}
