public class PracticeProgram1 {
    // Private attributes (Encapsulation)
    private String title;
    private String author;
    private double price;
    // Default Constructor
    public PracticeProgram1() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }
    // Parameterized Constructor
    public PracticeProgram1(String title, String author, double price) {
        // Using 'this' to resolve ambiguity between field and parameter
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void displayDetails() {
        System.out.println("Book: " + title + " | Author: " + author + " | Price: $" + price);
    }
    // Main method to test the code
    public static void main(String[] args) {
        System.out.println("--- Problem 1: Book Class ---");
        PracticeProgram1 defaultBook = new PracticeProgram1();
        defaultBook.displayDetails();
        PracticeProgram1 paramBook = new PracticeProgram1("The Alchemist", "Paulo Coelho", 15.50);
        paramBook.displayDetails();
    }
}