import java.util.ArrayList;
import java.util.List;
/* ================= Book ================= */
class Book {
    String title;
    Book(String title) {
        this.title = title;
    }
}
/* ================= SmartShelf ================= */
class SmartShelf {
    private final List<Book> books = new ArrayList<>();
    // Insert book using insertion sort
    public void addBook(String title) {
        Book newBook = new Book(title);
        books.add(newBook);
        int i = books.size() - 1;
        while (i > 0 && books.get(i - 1).title.compareToIgnoreCase(title) > 0) {
            books.set(i, books.get(i - 1));
            i--;
        }
        books.set(i, newBook);
    }
    public void displayBooks() {
        System.out.println("Sorted Book List:");
        for (Book b : books) {
            System.out.println(b.title);
        }
    }
}
/* ================= Main ================= */
public class SmartShelfSystem {
    public static void main(String[] args) {
        SmartShelf shelf = new SmartShelf();
        shelf.addBook("Java Programming");
        shelf.addBook("Algorithms");
        shelf.addBook("Data Structures");
        shelf.addBook("Operating Systems");
        shelf.displayBooks();
    }
}
