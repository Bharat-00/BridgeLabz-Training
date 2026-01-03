// Program to demonstrate Library Management System concepts
// Concepts used: static, this, final, instanceof
// Book class definition
class Book {
    // Static variable shared across all Book objects
    static String libraryName = "Egmore Library";
    // Instance variables
    private final String title;
    private final String author;
    private final String isbn; // final variable (cannot be changed)
    // Constructor using 'this' keyword
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}
// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Creating Book object
        Book book = new Book(
                "Effective Java",
                "Joshua Bloch",
                "978-0134685991"
        );
        // Display library name using static method
        Book.displayLibraryName();
        // Using instanceof before displaying details
        if (book instanceof Book) {
            book.displayBookDetails();
        }
    }
}
