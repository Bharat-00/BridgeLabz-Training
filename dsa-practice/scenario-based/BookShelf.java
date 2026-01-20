import java.util.*;
class Library {
    private HashMap<String, LinkedList<String>> catalog;
    private HashSet<String> uniqueBooks;
    public Library() {
        catalog = new HashMap<>();
        uniqueBooks = new HashSet<>();
    }
    // Add book
    public void addBook(String genre, String book) {
        if (uniqueBooks.contains(book)) {
            System.out.println("Duplicate book not allowed: " + book);
            return;
        }
        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        uniqueBooks.add(book);
        System.out.println("Book added: " + book + " [" + genre + "]");
    }
    // Borrow book
    public void borrowBook(String genre, String book) {
        if (!catalog.containsKey(genre) || !catalog.get(genre).remove(book)) {
            System.out.println("Book not available: " + book);
            return;
        }
        uniqueBooks.remove(book);
        System.out.println("Book borrowed: " + book);
    }
    // Display catalog
    public void displayCatalog() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println(genre + " → " + catalog.get(genre));
        }
    }
}
// Main class
public class BookShelf {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("Fiction", "1984");
        library.addBook("Fiction", "Animal Farm");
        library.addBook("Science", "A Brief History of Time");
        library.addBook("Fiction", "1984"); // duplicate
        library.displayCatalog();
        library.borrowBook("Fiction", "1984");
        library.borrowBook("Science", "Unknown Book");
        library.displayCatalog();
    }
}
