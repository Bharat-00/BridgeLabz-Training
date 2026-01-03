// Program to display book details
// Book class definition
class Book {
    // Instance variables
    private final String title;
    private final String author;
    private final double price;
    // Constructor to initialize book details
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // Method to display book details
    public void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
}
// Main class
public class BookDetails {
    public static void main(String[] args) {
        // Creating first Book object
        Book book1 = new Book("2States", "Chetan Bhagat", 500.0);
        book1.displayDetails();
        // Creating second Book object
        Book book2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);
        book2.displayDetails();
    }
}
