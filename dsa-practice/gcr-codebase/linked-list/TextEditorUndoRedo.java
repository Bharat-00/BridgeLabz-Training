/**
 * Undo / Redo functionality using Doubly Linked List
 */
public class TextEditorUndoRedo {
    // Node representing a text state
    static class Node {
        String text;
        Node prev;
        Node next;
        Node(String text) {
            this.text = text;
        }
    }
    private Node head = null;
    private Node current = null;
    private int size = 0;
    private static final int MAX_HISTORY = 10;
    // Add new text state
    public void addState(String text) {
        Node newNode = new Node(text);
        if (current != null) {
            current.next = null; // clear redo history
        }
        if (head == null) {
            head = newNode;
        } else {
            newNode.prev = current;
            if (current != null)
                current.next = newNode;
        }
        current = newNode;
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
        System.out.println("Text updated: " + current.text);
    }
    // Undo operation
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo → Current text: " + current.text);
        } else {
            System.out.println("Nothing to undo");
        }
    }
    // Redo operation
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo → Current text: " + current.text);
        } else {
            System.out.println("Nothing to redo");
        }
    }
    // Display current state
    public void displayCurrentText() {
        if (current != null)
            System.out.println("Current Text: " + current.text);
        else
            System.out.println("Editor is empty");
    }
    // Main method
    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.undo();
        editor.undo();
        editor.redo();
        editor.displayCurrentText();
    }
}
