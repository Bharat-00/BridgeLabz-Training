import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class LibraryItem {
    // Encapsulated fields
    private final int itemId;
    private final String title;
    private final String author;
    private boolean isAvailable = true;
    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    // Abstract method
    public abstract int getLoanDuration();
    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID     : " + itemId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Loan Period : " + getLoanDuration() + " days");
        System.out.println("Available   : " + (isAvailable ? "Yes" : "No"));
    }
    // Encapsulation
    protected void setAvailability(boolean status) {
        this.isAvailable = status;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
}
/* -------------------- BOOK -------------------- */
class Book extends LibraryItem implements Reservable {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 14;
    }
    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailability(false);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
/* -------------------- MAGAZINE -------------------- */
class Magazine extends LibraryItem implements Reservable {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 7;
    }
    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailability(false);
            System.out.println("Magazine reserved successfully.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
/* -------------------- DVD -------------------- */
class DVD extends LibraryItem implements Reservable {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 5;
    }
    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailability(false);
            System.out.println("DVD reserved successfully.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book(1, "Java Programming", "James Gosling"));
        items.add(new Magazine(2, "Tech Monthly", "Editorial Team"));
        items.add(new DVD(3, "Learning Java", "Oracle"));
        System.out.println("===== Library Items =====");
        // Polymorphism
        for (LibraryItem item : items) {
            item.getItemDetails();
            if (item instanceof Reservable reservable) {
                reservable.reserveItem();
            }
            System.out.println("--------------------------------");
        }
    }
}
