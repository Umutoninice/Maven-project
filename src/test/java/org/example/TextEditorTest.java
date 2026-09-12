package org.example;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {

    public static void main(String[] args) {

        System.out.println("   TEXT EDITOR WITH UNDO/REDO DEMONSTRATION");
        System.out.println("----------------------------------------------");

        // Create editor with initial text
        TextEditor editor = new TextEditor("Hello");
        editor.printState("Initial state");

        System.out.println("SEQUENCE OF 5 TYPES\n");

        // Sequence of 5 types
        editor.type(" World");
        editor.printState("After typing ' World'");

        editor.type(" from");
        editor.printState("After typing ' from'");

        editor.type(" Java");
        editor.printState("After typing ' Java'");

        editor.type("!");
        editor.printState("After typing '!'");

        editor.type(" Welcome");
        editor.printState("After typing ' Welcome'");

        System.out.println(" TWO UNDOS");

        // Two undos
        editor.undo();
        editor.printState("After 1st undo");

        editor.undo();
        editor.printState("After 2nd undo");

        System.out.println("\n  ONE REDO\n");

        // One redo
        editor.redo();
        editor.printState("After 1st redo");

        System.out.println("\n  MORE TYPING (clears redo stack)\n");

        // More typing - this should clear redo stack
        editor.type(" Again");
        editor.printState("After typing ' Again'");

        System.out.println(" ADVANCED OPERATIONS\n");

        // Test advanced features
        editor.insertAt(5, " Beautiful");
        editor.printState("After inserting ' Beautiful' at position 5");

        editor.deleteRange(5, 15);
        editor.printState("After deleting positions 5-15");

        System.out.println("FULL SEQUENCE DEMONSTRATION\n");
        fullSequenceDemo();

        System.out.println("\nEDGE CASES\n");
        edgeCasesDemo();

        System.out.println("   DEMONSTRATION COMPLETE");
        System.out.println("============================");
    }

    private static void fullSequenceDemo() {
        TextEditor editor = new TextEditor("Start");
        System.out.println("Starting with: " + editor.getState());

        // Detailed sequence with visual representation
        String[] operations = {
                "adding", "some", "text", "to", "demonstrate"
        };

        int step = 1;
        for (String op : operations) {
            System.out.println("\n  Step " + step++ + ": Type '" + op + "'");
            editor.type(" " + op);
            System.out.println("  Text: " + editor.getState());
            System.out.println("  Undo stack: " + editor.getUndoSize() +
                    " | Redo stack: " + editor.getRedoSize());
        }

        System.out.println("\n  " + "─".repeat(40));
        System.out.println("  Performing 3 undos:");
        for (int i = 0; i < 3; i++) {
            editor.undo();
            System.out.println("  After undo " + (i+1) + ": " + editor.getState());
            System.out.println("  Undo size: " + editor.getUndoSize() +
                    " | Redo size: " + editor.getRedoSize());
        }

        System.out.println("\n  Performing 2 redos:");
        for (int i = 0; i < 2; i++) {
            editor.redo();
            System.out.println("  After redo " + (i+1) + ": " + editor.getState());
            System.out.println("  Undo size: " + editor.getUndoSize() +
                    " | Redo size: " + editor.getRedoSize());
        }
    }

    private static void edgeCasesDemo() {
        TextEditor editor = new TextEditor();

        System.out.println("  Testing undo on empty history:");
        editor.undo(); // Should show warning

        System.out.println("  Testing redo on empty history:");
        editor.redo(); // Should show warning

        System.out.println("  Testing typing null/empty:");
        editor.type(null);
        editor.type("");
        System.out.println("  Text still: " + editor.getState());

        System.out.println("  Testing clear:");
        editor.type("Some text");
        System.out.println("  Before clear: " + editor.getState());
        editor.clear();
        System.out.println("  After clear: " + editor.getState());
        editor.undo(); // Should restore text
        System.out.println("  After undo clear: " + editor.getState());
    }
}